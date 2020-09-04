package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private int result = 0;
    List<Integer> arabNumbers = new ArrayList<>();
    private int number1;
    private int number2;
    char operation;

    public int calculate(String input) throws Exception {
        arabNumbers = getListNumbers(input);
        number1 = arabNumbers.get(0);
        number2 = arabNumbers.get(1);

        if ((number1 < 1) || (number1 > 10) || (number2 < 1) || (number2 > 10)) {
            throw new Exception("You can input numbers from 1 to 10");
        }
        if (input.contains("+")) {
            result = number1 + number2;
        }
        if (input.contains("*")) {
            result = number1 * number2;
        }
        if (input.contains("-")) {
            result = number1 - number2;
        }
        if (input.contains("/")) {
            result = number1 / number2;
        }
        return result;
    }

    private List<Integer> getListNumbers(String input) throws Exception {
        String num1 = null;
        String num2 = null;

        if (input.contains(".")) {
            throw new Exception("You can use only integer numbers");
        }
        if (input.contains("+") || input.contains("-") || input.contains("*") || input.contains("/")) {
            for (String number : input.split("[+-/*]")) {
                num1 = num2;
                num2 = number;
            }

            if (isArabic(num1) && isArabic(num2)) {
                arabNumbers.add(Integer.parseInt(num1));
                arabNumbers.add(Integer.parseInt(num2));
            } else {

                if (!isArabic(num1) && !isArabic(num2)) {
                    arabNumbers.add(toConvertToArabic(num1.toUpperCase()));
                    arabNumbers.add(toConvertToArabic(num2.toUpperCase()));
                } else {
                    throw new Exception("You can input simultaniously only arabic or roman numbers");
                }
            }
        } else {
            throw new Exception("This operation is unavailable");
        }
        return arabNumbers;
    }

    private boolean isArabic(String number) {
        boolean isArabic = true;
        char[] numberAtChar = number.toCharArray();
        for (char c : numberAtChar) {
            isArabic = !Character.isLetter(c);
        }
        return isArabic;
    }

    private int toConvertToArabic(String number) {
        return switch (number) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> -1;
        };
    }
}

