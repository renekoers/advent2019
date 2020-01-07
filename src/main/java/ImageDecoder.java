import java.io.*;
import java.util.*;

public class ImageDecoder {
    private ArrayList<Integer> input = new ArrayList<>();
    private ArrayList<Layer> layerList = new ArrayList<>();

    public static void main(String[] args) {
        ImageDecoder id = new ImageDecoder();
        id.getIntInput();
        id.makeLayers();
        Layer lowestZerosLayer = id.findFewestZerosLayer();
        id.outputAnswer(lowestZerosLayer);
    }

    private void makeLayers(){
        int maxWidth = 25;
        int maxHeight = 6;
        Layer currentLayer = new Layer();
        for(int i = 0; i < input.size(); i++){
            if( i % (maxWidth * maxHeight) == 0 && i > 0){
                layerList.add(currentLayer);
                currentLayer = new Layer();
            }
            currentLayer.pixels.add(input.get(i));
        }
    }

    private void getIntInput(){
        File inputFile = new File("src/main/resources/input.txt");
        StringBuilder codeLine = new StringBuilder();

        try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));

            while((line = bufferedReader.readLine()) != null) {
                 codeLine.append(line);

            }
            bufferedReader.close();

            String[] codeIntLine = codeLine.toString().split("");

            for (String number : codeIntLine){
                input.add(Integer.parseInt(number));
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            System.out.println(input);
        }
    }

    private Layer findFewestZerosLayer(){
        Layer lowestZeroLayer = new Layer();
        int lowestZeroAmount = Integer.MAX_VALUE;

        for (Layer layer : layerList){
            int zeroAmount = 0;
            for (int pixel : layer.pixels){
                if (pixel == 0) zeroAmount++;
            }
            if (zeroAmount < lowestZeroAmount){
                lowestZeroAmount = zeroAmount;
                lowestZeroLayer = layer;
            }
        }
        return lowestZeroLayer;
    }

    private void outputAnswer(Layer lowestZerosLayer){
        int ones = 0;
        int twos = 0;
        for (int pixel : lowestZerosLayer.pixels){
            if (pixel == 1){
                ones++;
            } else if (pixel == 2){
                twos++;
            }
        }
        System.out.println("Answer is: " + (ones * twos));
    }

    class Layer {
        ArrayList<Integer> pixels;

        Layer(){
            this.pixels = new ArrayList<Integer>();
        }
    }
}