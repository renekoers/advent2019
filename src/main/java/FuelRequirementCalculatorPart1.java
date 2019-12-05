import java.io.*;

public class FuelRequirementCalculatorPart1 {
    int fuelTotal = 0;

    void importMassFromTxtFile(){
        File massInputFile = new File("../resources/day1input.txt");
        try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(massInputFile));

            while((line = bufferedReader.readLine()) != null) {
                int massAmount = Integer.parseInt(line);
                int fuelAmount = (massAmount/3)-2;
                fuelTotal += fuelAmount;
            }
            bufferedReader.close();

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            System.out.println(fuelTotal);
        }
    }


    public static void main(String[] args) {
        FuelRequirementCalculatorPart1 calc = new FuelRequirementCalculatorPart1();
        calc.importMassFromTxtFile();
        }

}
