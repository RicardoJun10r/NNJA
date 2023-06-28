package NNModel.Layers;

import java.util.Vector;

import NNModel.Exceptions.ArchNotSuported;
import NNModel.Layers.LayersType.LayerType;
import NNModel.NeuronNodes.Neuron;

public class Layer {
    
    private Double[][] neurons;

    private Double[][] sums;
    
    private Double[][] weights;

    private Vector<Double[][]> weightsPerLayer;

    private Vector<Double[][]> biasPerLayer;

    private Double[][] bias;

    private Integer[] architecture;

    private LayerType layerType;
    
    public Layer(LayerType layerType, Integer[] architecture) {
        this.architecture = architecture;
        this.layerType = layerType;
    }

    public void buildLayer(){
        switch(this.layerType){
            case INPUT:
            {
                this.neurons = new Double[1][this.architecture[0]];
                initNeurons();
                break;
            }
            case HIDDEN:
            {
                this.weightsPerLayer = new Vector<>(this.architecture.length-2);
                initWheights();
                this.biasPerLayer = new Vector<>(this.architecture.length-2);
                break;
            }
            case OUTPUT:
            {
                this.weightsPerLayer = new Vector<>(1);
                this.biasPerLayer = new Vector<>(this.architecture[this.architecture.length-1]);
                break;
            }
            default:
                break;
        }
    }

    public void initNeurons(){
        
    }

    public void initWheights(){}
    public void initBias(){}
    public void initSums(){}

}
