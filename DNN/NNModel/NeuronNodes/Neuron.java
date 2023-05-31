package DNN.NNModel.NeuronNodes;

public class Neuron {
    
    private Double values;
    
    private Double bias;
    
    public Neuron(){}
    
    public Neuron(Double values){
        this.values = values;
    }
    
    public Double getBias() {
        return bias;
    }

    public void setBias(Double bias) {
        this.bias = bias;
    }

    public Double getValues() {
        return values;
    }

    public void setValues(Double values) {
        this.values = values;
    }
    
}
