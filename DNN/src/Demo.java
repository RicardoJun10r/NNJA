import java.util.Random;
public class Demo {

    static Random random = new Random();

    public static void main(String[] args) {
        
        double[][]treino = {
            { 0.0, 0.0, 0.0 },
            { 1.0, 0.0, 1.0 },
            { 0.0, 1.0, 1.0 },
            { 1.0, 1.0, 1.0 },
        };

        double[] res = new double[treino.length];

        double[] x = new double[treino[0].length-1];
        
        x[0] = random.nextDouble();        
        
        x[1] = random.nextDouble();

        double b = random.nextDouble()+1;

        double l_rate = 0.25;
        
        // W[1x2] * A[2x1] = SOP[1x1]
        double erro = 0.0;
        
        for(int e = 0; e < 100*1000; e++){
            
            erro = 0.0;

            for(int i = 0; i < treino.length; i++){
                
                double y = (treino[i][0]*x[0] + treino[i][1]*x[1]) + b;

                res[i] = fsigmoide(y);

                erro += fcusto(res[i], treino[i][2]);
                
            }
            double [] nw = gradient(res, treino, x, l_rate, b);
            x[0] = nw[0];
            x[1] = nw[1];
            b = nw[2];
        }

        for(int i = 0; i < 4; i++){
            double y = fsigmoide((treino[i][0]*x[0] + treino[i][1]*x[1]) + b);
            System.out.println(treino[i][0] + " | " + treino[i][1] + " = " + y);
        }

        System.out.println("Erro = " + (erro/4));

    }

    static double fcusto(double predicted, double desired){
        double erro = (predicted - desired);
        return (erro*erro);
    }

    static double fsigmoide(double valor){
        return(1/(1+Math.exp(-valor)));
    }

    static double[] gradient(double[] predicted, double[][] train, double[]w, double lr, double b){

        Integer size = train.length;

        double dw1 = 0.0, dw2 = 0.0, db = 0.0;

        for(int i = 0; i < size; i++){
            double zi = train[i][2];
            double di = 2*(predicted[i]-zi)*predicted[i]*(1-predicted[i]);
            dw1 += di*train[i][0];
            dw2 += di*train[i][1];
            db += di;
        }

        dw1 /= size;
        dw2 /= size;
        db /= size;

        double []nw = new double[3];

        nw[0] = w[0] - dw1*lr;
        nw[1] = w[1] - dw2*lr;
        nw[2] = b - db*lr;

        return nw;

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