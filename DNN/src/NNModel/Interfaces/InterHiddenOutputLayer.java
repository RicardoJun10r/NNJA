package NNModel.Interfaces;

import java.util.Random;

import NNModel.NeuronNodes.Neuron;

public abstract class InterHiddenOutputLayer extends InterLayer {
    
    private Double[] weights;

    private Random random = new Random();

    public InterHiddenOutputLayer(){}

    public InterHiddenOutputLayer(Integer num_neurons){
        super(num_neurons);
    }

    public Double[] getWeights() {
        return weights;
    }

    public void setWeights(Double[] weights) {
        this.weights = weights;
    }

    public void initializeWheightsAndBias(){

        this.weights = new Double[getNUM_NEURONS()];
        for(int i = 0; i < getNUM_NEURONS(); i++){
            this.weights[i] = random.nextDouble();
        }

        Neuron[] neurons = new Neuron[getNUM_NEURONS()];
        for(int i = 0; i < getNUM_NEURONS(); i++){
            Neuron neuron = new Neuron();
            neuron.setBias(random.nextDouble());
            neurons[i] = neuron;
        }
        
        setNeurons(neurons);
        
    }
}
