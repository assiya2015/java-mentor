package calculator;


public class Main {

    public static void main(String[] args) throws Exception {
        UserInterface userInterface = new UserInterface();
        String userInput = userInterface.getUserInput();
        int result = new Calculator().calculate(userInput);
        userInterface.printOutput(Integer.toString(result));
    }

}

