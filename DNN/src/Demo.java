import DNN.NNModel.NN;
import DNN.NNModel.Type.NNType;

public class Demo {
    public static void main(String[] args) {
        Integer[] arch = { 10, 2, 5, 3, 4, 1, 5 };

        NN neuralNetwork = new NN(NNType.DENSE, arch);

        // neuralNetwork.printNN();

        neuralNetwork.buildModel();

        neuralNetwork.printLayers();
    }
}