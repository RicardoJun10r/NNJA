import java.util.Random;
public class Demo {

    static Random random = new Random();

    public static void main(String[] args) {
        
        Double[][]treino = {
            { 0.0, 0.0, 0.0 },
            { 1.0, 0.0, 0.0 },
            { 0.0, 1.0, 0.0 },
            { 1.0, 1.0, 1.0 },
        };

        Double[] res = new Double[treino.length];

        Double[] x = new Double[treino[0].length-1];
        
        x[0] = random.nextDouble();        
        
        x[1] = random.nextDouble();

        Double b = random.nextDouble();

        Double l_rate = 0.25;
        
        // W[1x2] * A[2x1] = SOP[1x1]
        Double erro = 0.0;
        
        for(int e = 0; e < 2; e++){
            
            erro = 0.0;

            for(int i = 0; i < treino.length; i++){
                
                Double y = (treino[i][0]*x[0] + treino[i][1]*x[1]) + b;
                System.out.println("treino[i][0] = " + treino[i][0] + " * x[0] = " + x[0] + " + treino[i][1] = " + treino[i][1] + " * x[1] = " + x[1] + " + b = " + b);
                res[i] = fsigmoide(y);
                System.out.println("res["+i+"] = " + res[i]);
                
                erro += fcusto(res[i], treino[i][2]);
                
            }
            System.out.println("ERRO = " + (erro/4) + " w0 = " + x[0] + " w1 = " + x[1]);
            gradient(res, treino, x, l_rate, b);
        }

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                System.out.println(treino[j][0] + " | " + treino[i][0] + " = " + fsigmoide(treino[j][0]*x[0] + treino[i][0]*x[1]) + b);
            }
        }

        System.out.println("Erro = " + (erro/4));

    }

    static Double fcusto(Double predicted, Double desired){
        Double erro = (predicted - desired);
        return (erro*erro);
    }

    static Double fsigmoide(Double valor){
        return(1/(1+Math.exp(-valor)));
    }

    static void gradient(Double[] predicted, Double[][] train, Double[]w, Double lr, Double b){

        Integer size = train.length;

        Double dw1 = 0.0, dw2 = 0.0, db = 0.0;

        for(int i = 0; i < size; i++){
            Double zi = train[i][2];
            Double di = 2*(predicted[i]-zi)*predicted[i]*(1-predicted[i]);
            dw1 += di*train[i][0];
            dw2 += di*train[i][1];
            db += di;
            System.out.println("predicted["+i+"] = " + predicted[i] + " - zi = " + zi);
            System.out.println("train[i][0] = " + train[i][0] + " train[i][1] = " + train[i][1]);
        }

        dw1 /= size;
        dw2 /= size;
        db /= size;

        w[0] -= dw1*lr;
        w[1] -= dw2*lr; 
        b -= db*lr;

    }

    // static Double[][]init(Double[][]res){
        
    //     for(int i = 0; i < res.length; i++){
    //         for(int j = 0; j < res[0].length; j++){
    //             res[i][j] = random.nextDouble();       
    //         }
    //     }

    //     return res;

    // }

    // static Double[][]sum(Double[][]res, Double[][]mat1, Double[][]mat2){

    //     for(int i = 0; i < res.length; i++){
    //         for(int j = 0; j < res[0].length; j++){
    //             res[i][j] = mat1[i][j] + mat2[i][j];
    //         }
    //     }

    //     return res;
    // }

    // static Double[][]mult(Double[][]res, Double[][]mat1, Double[][]mat2){
        
    //     for(int i = 0; i < res.length; i++){
    //         for(int j = 0; j < res[0].length; j++){
    //             for(int k = 0; k < mat1[0].length; k++){
    //                 res[i][j] += mat1[i][k]*mat2[k][j];
    //             }
    //         }
    //     }

    //     return res;
    // }

}