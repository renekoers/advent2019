import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FuelRequirementCalculatorPart2 {
    private int fuelTotal = 0;

    void importMassFromTxtFile() {
        File massInputFile = new File("D:/Opdrachten/advent2019/src/main/resources/day1input.txt");
        try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(massInputFile));

            while ((line = bufferedReader.readLine()) != null) {
                int massAmount = Integer.parseInt(line);
                int fuelAmount = (massAmount / 3) - 2;
                int moduleFuelRequirement = fuelAmount;

                while(fuelAmount > 0) {
                    if((fuelAmount/3)-2 < 1){
                        break;
                    } else {
                        fuelAmount = (fuelAmount/3)-2;
                        moduleFuelRequirement += fuelAmount;
                    }
                }
                fuelTotal += moduleFuelRequirement;
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(fuelTotal);
        }
    }

    public static void main(String[] args) {
        FuelRequirementCalculatorPart2 calc = new FuelRequirementCalculatorPart2();
        calc.importMassFromTxtFile();
    }
}
