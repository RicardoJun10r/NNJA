package NNModel.NeuronNodes;

public class Neuron {
    
    private Double value;
    
    private Double bias;
    
    public Neuron(){}
    
    public Neuron(Double value){
        this.value = value;
    }
    
    public Double getBias() {
        return bias;
    }

    public void setBias(Double bias) {
        this.bias = bias;
    }

    public Double getvalue() {
        return value;
    }

    public void setvalue(Double value) {
        this.value = value;
    }
    
}
