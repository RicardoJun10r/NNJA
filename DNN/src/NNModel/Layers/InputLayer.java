package NNModel.Layers;

import NNModel.Interfaces.InterLayer;
import NNModel.NeuronNodes.Neuron;

public class InputLayer extends InterLayer {

    private Double[]train;
    
    public InputLayer() {
    }

    public InputLayer(Integer num_neurons) {
        super(num_neurons);
    }

}
