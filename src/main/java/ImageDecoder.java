import java.io.*;
import java.util.*;

public class ImageDecoder {
    private ArrayList<Integer> input = new ArrayList<>();
    private ArrayList<Layer> layerList = new ArrayList<>();
    private int maxWidth = 25;
    private int maxHeight = 6;

    public static void main(String[] args) {
        ImageDecoder id = new ImageDecoder();
        id.getIntInput();
        id.makeLayers();
//        Layer lowestZerosLayer = id.findFewestZerosLayer();
//        id.outputAnswer(lowestZerosLayer);
        Layer imageLayer = id.decodeImage();
        id.printImage(imageLayer);
    }

    private void makeLayers(){
        Layer currentLayer = null;
        for(int i = 0; i < input.size(); i++){
            if (i % (maxWidth * maxHeight) == 0){
                currentLayer = new Layer();
            }
            currentLayer.pixels.add(input.get(i));
            if (i % (maxWidth * maxHeight) == (maxWidth * maxHeight)-1){
                layerList.add(currentLayer);
            }
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

    private Layer decodeImage(){
        Layer imageLayer = new Layer();
        System.out.println("Total of layers: " + layerList.size());
        int sum = 0;
        for (Layer layer : layerList){
            ++sum;
            for (int i = 0; i < layer.pixels.size(); i++) {
                if (sum == 1){
                    imageLayer.pixels.add(layer.pixels.get(i));
                } else {
                    if (imageLayer.pixels.get(i) == 2){
                        imageLayer.pixels.set(i, layer.pixels.get(i));
                    }
                }
            }
        }

        System.out.println("Total of processed layers: " + sum);
        return imageLayer;
    }

    private void printImage(Layer imageLayer){
        StringBuilder line = new StringBuilder();

        for (int i = 0; i < imageLayer.pixels.size(); i++) {
            if(imageLayer.pixels.get(i) == 0){
                line.append("▒");
            } else if(imageLayer.pixels.get(i) == 1) {
                line.append("▓");
            }

            if (i % maxWidth == maxWidth-1){
                line.append("\n");
            }
        }
        System.out.println(line);
    }

    static class Layer {
        ArrayList<Integer> pixels;

        Layer(){
            this.pixels = new ArrayList<Integer>();
        }
    }
}