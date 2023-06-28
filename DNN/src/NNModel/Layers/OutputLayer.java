package NNModel.Layers;

import NNModel.Interfaces.InterHiddenOutputLayer;

public class OutputLayer extends InterHiddenOutputLayer {
    
    private Double[] train;

    private Double[] test;

    public OutputLayer(Integer NUM_NEURONS) {
        super(NUM_NEURONS);
    }

    public OutputLayer(Double[] train) {
        this.train = train;
    }

    public OutputLayer(Double[] train, Double[] test) {
        this.train = train;
        this.test = test;
    }

    public void init(){

        initializeWheightsAndBias();
        
    }

    public OutputLayer(Integer num_neurons, Double[] train, Double[] test) {
        super(num_neurons);
        this.train = train;
        this.test = test;
    }

    public Double[] getTrain() {
        return train;
    }

    public void setTrain(Double[] train) {
        this.train = train;
    }

    public Double[] getTest() {
        return test;
    }

    public void setTest(Double[] test) {
        this.test = test;
    }
    
}
