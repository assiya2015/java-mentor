package calculator;

import java.util.Scanner;

public class UserInterface {
    public String getUserInput() {
        System.out.print("Input: ");
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextLine();
        }
    }

    public void printOutput(String output) {
        System.out.println("Output: " + output);
    }

}
