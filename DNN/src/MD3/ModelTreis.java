package MD3;

import java.util.Random;

public class ModelTreis {
    
    static Random random = new Random();
    public static void main(String[] args) {
        
        double [][] xor = {
            { 0.0, 0.0, 0.0 },
            { 1.0, 0.0, 1.0 },
            { 0.0, 1.0, 1.0 },
            { 1.0, 1.0, 0.0 },
        };

        double[]w = new double[6];

        double[]b = new double[3];

        final int SIZE = xor.length;

        w[0] = random.nextDouble();
        w[1] = random.nextDouble();
        w[2] = random.nextDouble();
        w[3] = random.nextDouble();
        w[4] = random.nextDouble();
        w[5] = random.nextDouble();

        b[0] = random.nextDouble();
        b[1] = random.nextDouble();
        b[2] = random.nextDouble();

        double[]res00 = new double[xor.length];

        double[]res01 = new double[xor.length];        
        
        double[]res1 = new double[xor.length];

        double lr = 0.005;

        double erro = 0.0;

        for(int e = 0; e < 10000*1000; e++){
            
            erro = 0.0;
            
            for(int i = 0; i < SIZE; i++){

                double y00 = (xor[i][0]*w[0] + xor[i][1]*w[1]) + b[0];
                
                double y01 = (xor[i][0]*w[2] + xor[i][1]*w[3]) + b[1];
                
                double a00 = sigmoidf(y00);

                res00[i] = a00;

                double a01 = sigmoidf(y01);

                res01[i] = a01;

                double y1 = (a00*w[4] + a01*w[5]) + b[2];

                double a1 = sigmoidf(y1);

                res1[i] = a1;

                erro += custo(a1, xor[i][2]);

            }

            double[]nw = backpropagation(res00, res01, res1, xor, w, b, lr);
        
            w[0] = nw[0];
            w[1] = nw[1];
            w[2] = nw[2];
            w[3] = nw[3];
            w[4] = nw[4];
            w[5] = nw[5];
            
            b[0] = nw[6];
            b[1] = nw[7];
            b[2] = nw[8];

        }

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){

                double y0 = (xor[i][0]*w[0] + xor[j][0]*w[1]) + b[0];

                double a0 = sigmoidf(y0);

                double y1 = (a0*w[2]) + b[1];

                double a1 = sigmoidf(y1);

                System.out.println(xor[i][0] + " | " + xor[j][0] + " = " + a1);

            }
        }

        System.out.println("Erro da rede = " + (erro/SIZE));

    }

    static double custo(double a1, double zi){
        double erro = a1 - zi;
        return erro*erro;
    }

    static double sigmoidf(double x){
        return 1/(1+Math.exp(-x));
    }

    static double[] backpropagation(double[]res00, double[]res01, double[]res1, double[][]xor, double[]w, double []b, double lr){

        final int SIZE = xor.length;

        double[]nw = new double[9];
        
        double dw0 = 0.0, dw1 = 0.0, dw2 = 0.0, dw3 = 0.0, dw4 = 0.0, dw5 = 0.0, db0 = 0.0, db1 = 0.0, db2 = 0.0;

        for(int i = 0; i < SIZE; i++){

        }

        dw0 /= SIZE;

        dw1 /= SIZE;

        dw2 /= SIZE;

        dw3 /= SIZE;

        dw4 /= SIZE;

        dw5 /= SIZE;

        db0 /= SIZE;

        db1 /= SIZE;

        db2 /= SIZE;

        nw[0] = w[0] - dw0*lr;

        nw[1] = w[1] - dw1*lr;

        nw[2] = w[2] - dw2*lr;

        nw[3] = w[3] - dw3*lr;

        nw[4] = w[4] - dw4*lr;

        nw[5] = w[5] - dw5*lr;

        nw[6] = b[0] - db0*lr;

        nw[7] = b[1] - db1*lr;

        nw[8] = b[2] - db2*lr;

        return nw;
    }

}
