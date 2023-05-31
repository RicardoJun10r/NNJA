package DNN.NNModel.Layers;

import DNN.NNModel.NeuronNodes.Neuron;

public class Layer {
    
    private Neuron[] neurons;
    
    private Double[] weights;

    private Integer NUM_NEURONS;

    private Layer next_layer;

    private Layer prev_layer;
    
    public Layer(Integer num_neurons) {
        this.NUM_NEURONS = num_neurons;
        this.next_layer = null;
        this.prev_layer = null;
    }

    public Neuron[] getNeurons() {
        return neurons;
    }

    public void setNeurons(Neuron[] neurons) {
        this.neurons = neurons;
    }

    public Double[] getWeights() {
        return weights;
    }

    public void setWeights(Double[] weights) {
        this.weights = weights;
    }

    public Integer getNUM_NEURONS() {
        return NUM_NEURONS;
    }

    public void setNUM_NEURONS(Integer nUM_NEURONS) {
        NUM_NEURONS = nUM_NEURONS;
    }

    public Layer getNext_layer() {
        return next_layer;
    }

    public void setNext_layer(Layer next_layer) {
        this.next_layer = next_layer;
    }

    public Layer getPrev_layer() {
        return prev_layer;
    }

    public void setPrev_layer(Layer prev_layer) {
        this.prev_layer = prev_layer;
    }
    
}
