package NNModel.Layers;

import NNModel.Interfaces.InterHiddenOutputLayer;

public class HiddenLayer extends InterHiddenOutputLayer {
    
    public HiddenLayer(){}

    public HiddenLayer(Integer NUM_NEURONS){
        super(NUM_NEURONS);
    }
    
    public void init(){

        initializeWheightsAndBias();
        
    }
}
