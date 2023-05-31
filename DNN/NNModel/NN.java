package DNN.NNModel;

import DNN.NNModel.Layers.Layer;
import DNN.NNModel.Type.NNType;

public class NN {
    
    private Integer NUM_ENTRADA;
    
    private Integer[][] NUM_OCULTA;
    
    private Integer NUM_SAIDA;

    private Layer inputs;
    
    private Layer hidden;

    private Layer output;

    private NNType nnType;

    public NN(NNType flag, Integer[] arquitetura) {
        this.nnType = flag;
        assertNumOfNeurons(arquitetura);
    }

    private void assertNumOfNeurons(Integer[] arquitetura){
        this.NUM_ENTRADA = arquitetura[0];
        this.NUM_SAIDA = arquitetura[arquitetura.length-1];

        if(this.nnType == NNType.DENSE){
            modeloMuitoDensa(arquitetura);
        }
    }
    
    private void modeloMuitoDensa(Integer[] arquitetura){
        Integer diff = arquitetura.length - 2;
        this.NUM_OCULTA = new Integer[diff][1];
        for(int row = 0; row < diff; row++){
            for(int column = 0; column < NUM_OCULTA[0].length; column++){
                this.NUM_OCULTA[row][column] = arquitetura[row+1];
            }
        }
    }

    public void printNN(){
        System.out.println("  ---------NN---------\n[ ");
        System.out.println("\tCamada ENTRADA = [ " + this.NUM_ENTRADA + " ]");
        System.out.println("\tCamada OCULTA = [ ");
        printMATRIZ(this.NUM_OCULTA);
        System.out.println("\t\t\t] ");
        System.out.println("\tCamada SAÍDA = [ " + this.NUM_SAIDA + " ]");
        System.out.println("]\n  ----------------------");
    }

    public <T> void printMATRIZ(T[][]matriz){
        for(int row = 0; row < matriz.length; row++){
            for(int column = 0; column < matriz[0].length; column++){
                System.out.print("\t\t\t" + matriz[row][column] + " ");
            }
            System.out.println();
        }
    }

    public void buildModel(){
        
        this.inputs = new Layer(this.NUM_ENTRADA);
        this.output = new Layer(this.NUM_SAIDA);

        if(this.nnType == NNType.NO_DENSE){
            this.inputs.setNext_layer(this.output);
            this.output.setPrev_layer(this.inputs);
        }
        else{
            this.hidden = new Layer(this.NUM_OCULTA[0][0]);
            this.inputs.setNext_layer(this.hidden);
            this.hidden.setPrev_layer(this.inputs);
            buildHiddenLayers(this.hidden, this.NUM_OCULTA);
        }

    }

    private void buildHiddenLayers(Layer root, Integer[][] hiddens){
        Layer aux = root;

        int cont = 1;
        while(cont < hiddens.length){
            Layer novo = new Layer(hiddens[cont][0]);
            aux.setNext_layer(novo);
            novo.setPrev_layer(aux);
            aux = novo;
            cont++;
        }
        
        aux.setNext_layer(this.output);
    }

    public void printLayers(){
        Layer index = this.inputs;
        while(index != null){
            System.out.println("Num of neurons: " + index.getNUM_NEURONS());
            index = index.getNext_layer();
        }
        System.out.println();
    }
    
}
