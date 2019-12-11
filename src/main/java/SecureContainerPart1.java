import java.util.*;

public class SecureContainerPart1 {
    private final static int lowerRange = 231832;
    private final static int upperRange = 767346;
    private int totalPasswordPossibilities = 0;

    private void calculatePasswordPossibilities(){
        for (int code = lowerRange; code <= upperRange ; code++){
            if (isMeetingCriteria(code)){
                totalPasswordPossibilities++;
            }
        }
        System.out.println(totalPasswordPossibilities);
    }

    private boolean isMeetingCriteria(int code){
        String codeStr = "" + code;
        String[] codeArray = codeStr.split("");
        int[] codeDigits = new int[codeArray.length];
        for (int i = 0; i < codeArray.length; i++) {
            codeDigits[i] = Integer.parseInt(codeArray[i]);
        }

        if (isAscending(codeDigits)){
            for (int i = 0; i < codeDigits.length; i++) {
                if (i == codeDigits.length -2){
                    if (codeDigits[i] == codeDigits[i+1]){
                        return true;
                    }
                }

                if (i < codeDigits.length - 2){
                    if (codeDigits[i] == codeDigits[i+1]){
                        if (codeDigits[i] == codeDigits[i+2]){
                           i = findNewNumber(codeDigits, i) -1;
                        } else {
                            return true;
                        }
                    }
                }


            }
        }
        return false;
    }

    private boolean isAscending(int[] digits){
        for (int i = 0; i < digits.length ; i++) {
            if (i > 0 && digits[i] > digits[i-1]) {
                return false;
            }
        }
        return true;
    }

    private int findNewNumber(int[] digits, int i){
        for (int j = i; j < digits.length; j++){
            int digit = digits[i];
            if (digits[j] != digit){
                return j;
            }
        }
        return digits.length;
    }

    public static void main(String[] args) {
        SecureContainerPart1 secCon = new SecureContainerPart1();
        secCon.calculatePasswordPossibilities();
    }
}
