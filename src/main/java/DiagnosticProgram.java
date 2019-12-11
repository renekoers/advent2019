import java.util.Arrays;

public class DiagnosticProgram {
    private int[] referenceMemory = {3, 225, 1, 225, 6, 6, 1100, 1, 238, 225, 104, 0, 1101, 65, 39, 225, 2, 14, 169, 224, 101, -2340, 224, 224, 4, 224, 1002, 223, 8, 223, 101, 7, 224, 224, 1, 224, 223, 223, 1001, 144, 70, 224, 101, -96, 224, 224, 4, 224, 1002, 223, 8, 223, 1001, 224, 2, 224, 1, 223, 224, 223, 1101, 92, 65, 225, 1102, 42, 8, 225, 1002, 61, 84, 224, 101, -7728, 224, 224, 4, 224, 102, 8, 223, 223, 1001, 224, 5, 224, 1, 223, 224, 223, 1102, 67, 73, 224, 1001, 224, -4891, 224, 4, 224, 102, 8, 223, 223, 101, 4, 224, 224, 1, 224, 223, 223, 1102, 54, 12, 225, 102, 67, 114, 224, 101, -804, 224, 224, 4, 224, 102, 8, 223, 223, 1001, 224, 3, 224, 1, 224, 223, 223, 1101, 19, 79, 225, 1101, 62, 26, 225, 101, 57, 139, 224, 1001, 224, -76, 224, 4, 224, 1002, 223, 8, 223, 1001, 224, 2, 224, 1, 224, 223, 223, 1102, 60, 47, 225, 1101, 20, 62, 225, 1101, 47, 44, 224, 1001, 224, -91, 224, 4, 224, 1002, 223, 8, 223, 101, 2, 224, 224, 1, 224, 223, 223, 1, 66, 174, 224, 101, -70, 224, 224, 4, 224, 102, 8, 223, 223, 1001, 224, 6, 224, 1, 223, 224, 223, 4, 223, 99, 0, 0, 0, 677, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1105, 0, 99999, 1105, 227, 247, 1105, 1, 99999, 1005, 227, 99999, 1005, 0, 256, 1105, 1, 99999, 1106, 227, 99999, 1106, 0, 265, 1105, 1, 99999, 1006, 0, 99999, 1006, 227, 274, 1105, 1, 99999, 1105, 1, 280, 1105, 1, 99999, 1, 225, 225, 225, 1101, 294, 0, 0, 105, 1, 0, 1105, 1, 99999, 1106, 0, 300, 1105, 1, 99999, 1, 225, 225, 225, 1101, 314, 0, 0, 106, 0, 0, 1105, 1, 99999, 108, 226, 226, 224, 102, 2, 223, 223, 1005, 224, 329, 101, 1, 223, 223, 1107, 226, 677, 224, 1002, 223, 2, 223, 1005, 224, 344, 101, 1, 223, 223, 8, 226, 677, 224, 102, 2, 223, 223, 1006, 224, 359, 101, 1, 223, 223, 108, 677, 677, 224, 1002, 223, 2, 223, 1005, 224, 374, 1001, 223, 1, 223, 1108, 226, 677, 224, 1002, 223, 2, 223, 1005, 224, 389, 101, 1, 223, 223, 1007, 677, 677, 224, 1002, 223, 2, 223, 1006, 224, 404, 1001, 223, 1, 223, 1108, 677, 677, 224, 102, 2, 223, 223, 1006, 224, 419, 1001, 223, 1, 223, 1008, 226, 677, 224, 102, 2, 223, 223, 1005, 224, 434, 101, 1, 223, 223, 107, 677, 677, 224, 102, 2, 223, 223, 1006, 224, 449, 1001, 223, 1, 223, 1007, 226, 677, 224, 102, 2, 223, 223, 1005, 224, 464, 101, 1, 223, 223, 7, 677, 226, 224, 102, 2, 223, 223, 1005, 224, 479, 101, 1, 223, 223, 1007, 226, 226, 224, 102, 2, 223, 223, 1005, 224, 494, 101, 1, 223, 223, 7, 677, 677, 224, 102, 2, 223, 223, 1006, 224, 509, 101, 1, 223, 223, 1008, 677, 677, 224, 1002, 223, 2, 223, 1006, 224, 524, 1001, 223, 1, 223, 108, 226, 677, 224, 1002, 223, 2, 223, 1006, 224, 539, 101, 1, 223, 223, 8, 226, 226, 224, 102, 2, 223, 223, 1006, 224, 554, 101, 1, 223, 223, 8, 677, 226, 224, 102, 2, 223, 223, 1005, 224, 569, 1001, 223, 1, 223, 1108, 677, 226, 224, 1002, 223, 2, 223, 1006, 224, 584, 101, 1, 223, 223, 1107, 677, 226, 224, 1002, 223, 2, 223, 1005, 224, 599, 101, 1, 223, 223, 107, 226, 226, 224, 102, 2, 223, 223, 1006, 224, 614, 1001, 223, 1, 223, 7, 226, 677, 224, 102, 2, 223, 223, 1005, 224, 629, 1001, 223, 1, 223, 107, 677, 226, 224, 1002, 223, 2, 223, 1005, 224, 644, 1001, 223, 1, 223, 1107, 677, 677, 224, 102, 2, 223, 223, 1006, 224, 659, 101, 1, 223, 223, 1008, 226, 226, 224, 1002, 223, 2, 223, 1006, 224, 674, 1001, 223, 1, 223, 4, 223, 99, 226};
//    private int[] referenceMemory = {3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9};
    private void compute(int input) {
        int[] memory = referenceMemory.clone();
        int output = 0;


        compute:
        for (int pos = 0; pos < memory.length; ) {
            int[] parameterModes = getParameterModes(memory[pos]);
            int instructionCode = memory[pos]%100;
                switch (instructionCode) {
                    case 1:
                        memory[memory[pos + 3]] = getValue(memory, parameterModes[0], pos+1) + getValue(memory, parameterModes[1], pos+2);
                        pos += 4;
                        break;
                    case 2:
                        memory[memory[pos + 3]] = getValue(memory, parameterModes[0], pos+1) * getValue(memory, parameterModes[1], pos+2);
                        pos += 4;
                        break;
                    case 3:
                        memory[memory[pos + 1]] = input;
                        pos += 2;
                        break;
                    case 4:
                        output = getValue(memory, parameterModes[0], pos+1);
                        pos += 2;
                        System.out.println("Output value: " + output);
                        break;
                    case 5:
                        if (getValue(memory, parameterModes[0], pos+1) != 0){
                            pos = getValue(memory, parameterModes[1], pos+2);
                        } else {
                            pos += 3;
                        }
                        break;
                    case 6:
                        if (getValue(memory, parameterModes[0], pos+1) == 0){
                            pos = getValue(memory, parameterModes[1], pos+2);
                        } else {
                            pos += 3;
                        }
                        break;
                    case 7:
                        if (getValue(memory, parameterModes[0], pos+1) < getValue(memory, parameterModes[1], pos+2)) {
                            memory[memory[pos+3]] = 1;
                        } else {
                            memory[memory[pos+3]] = 0;
                        }
                            pos += 4;
                        break;
                    case 8:
                        if (getValue(memory, parameterModes[0], pos+1) == getValue(memory, parameterModes[1], pos+2)) {
                            memory[memory[pos+3]] = 1;
                        } else {
                            memory[memory[pos+3]] = 0;
                        }
                        pos += 4;
                        break;
                    case 99:
                        break compute;
                }
        }
        System.out.println("Computing halted.");
    }

    private int getValue(int[] memory, int parameterMode, int pos){
        switch(parameterMode) {
            case 0:
                return memory[memory[pos]];
            case 1:
                return memory[pos];
            default:
                throw new RuntimeException("AAAAAAAAAAAAAAAAAA");
        }
    }

    private int[] getParameterModes(int code) {
        StringBuilder parameterModes = new StringBuilder(""+ (code/100));
        parameterModes.reverse();
        String[] digitArray = parameterModes.toString().split("");

        int[] codeDigits = new int[3];

        for (int i = 0; i < digitArray.length; i++) {
            codeDigits[i] = Integer.parseInt(digitArray[i]);
        }
        return codeDigits;
    }

    public static void main(String[] args) {
        DiagnosticProgram diag = new DiagnosticProgram();
        diag.compute(5);
    }
}
