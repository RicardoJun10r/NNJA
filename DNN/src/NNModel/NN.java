package NNModel;

import NNModel.Exceptions.ArchNotSuported;
import NNModel.Interfaces.InterHiddenOutputLayer;
import NNModel.Interfaces.InterLayer;
import NNModel.Layers.HiddenLayer;
import NNModel.Layers.InputLayer;
import NNModel.Layers.Layer;
import NNModel.Layers.OutputLayer;
import NNModel.Layers.LayersType.LayerType;
import NNModel.Type.NNType;

public class NN {
    
    private Integer NUM_ENTRADA;
    
    private Integer[][] NUM_OCULTA;
    
    private Integer NUM_SAIDA;

    private Layer input;

    private Layer hidden;
    
    private Layer output;

    private Integer[] arquitetura;

    private NNType nnType;

    public NN(NNType flag, Integer[] arquitetura) {
        this.arquitetura = arquitetura;
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

    public <T> void printVet(T[]vet){
        for(int index = 0; index < vet.length; index++){
            System.out.print("\t\t\t" + vet[index] + " ");
            System.out.println();
        }
    }

    private void buildModel(){

        if(this.nnType == NNType.NO_DENSE){

            this.input = new Layer(LayerType.INPUT, this.arquitetura);
            this.output = new Layer(LayerType.OUTPUT, this.arquitetura);

        }
        else{

            this.input = new Layer(LayerType.INPUT, this.arquitetura);
            this.hidden = new Layer(LayerType.HIDDEN, this.arquitetura);
            this.output = new Layer(LayerType.OUTPUT, this.arquitetura);

        }

    }

    public void allocLayers(){
        if(verify()){
            throw new ArchNotSuported("Arquitetura não suportada!!!");
        } else {
            this.buildModel();
        }
    }

    private Boolean verify(){
        
        if(arquitetura.length < 1) return false;

        else if(arquitetura.length == 1 && arquitetura[0] == 0) return false;

        else if(arquitetura.length <= 2 && this.nnType == NNType.DENSE) return false;

        else if(arquitetura.length > 2 && this.nnType == NNType.NO_DENSE) return false;

        else return true;

    }
    
}
