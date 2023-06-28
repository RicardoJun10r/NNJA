package NNModel.Interfaces;

import NNModel.NeuronNodes.Neuron;

public abstract class InterLayer {
    
    private Neuron[] neurons;
    
    private Integer NUM_NEURONS;

    private InterLayer next_layer;

    private InterLayer prev_layer;
    
    public InterLayer(){}

    public InterLayer(Integer num_neurons){
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

    public Integer getNUM_NEURONS() {
        return NUM_NEURONS;
    }

    public void setNUM_NEURONS(Integer nUM_NEURONS) {
        NUM_NEURONS = nUM_NEURONS;
    }

    public InterLayer getNext_layer() {
        return next_layer;
    }

    public void setNext_layer(InterLayer next_layer) {
        this.next_layer = next_layer;
    }

    public InterLayer getPrev_layer() {
        return prev_layer;
    }

    public void setPrev_layer(InterLayer prev_layer) {
        this.prev_layer = prev_layer;
    }

}
