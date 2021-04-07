import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        String operation = "", nome, message = "";
        StringBuilder calculation = new StringBuilder();
        float total = 0, auxiliary;
        boolean isStart = true, exit = false, error = false;
        Scanner scanner = new Scanner(System.in);
        do {
            if (isStart) {
                System.out.println("What is your name? ");
                nome = scanner.next();
                System.out.println("Initial value: ");
                try {
                    total = scanner.nextFloat();
                    isStart = false;
                    calculation = new StringBuilder(nome + ":\n " + total);
                } catch (InputMismatchException e) {
                    message = "invalid value!";
                    error = true;
                }
            }
            if (!error) {
                System.out.println("Operation (+, -, /, *, =): ");
                operation = scanner.next();
                if (operation.length() > 1) {
                    message = "Unsupported operation!";
                    error = true;
                } else {
                    calculation.append(" ").append(operation);
                    if (operation.equals("=")) {
                        exit = true;
                    }
                }
            }
            if (!error) {
                if (!exit) {
                    System.out.println("Next number: ");
                    try {
                        auxiliary = scanner.nextFloat();
                        calculation.append(" ").append(auxiliary);

                        try {
                            if (operation.equals("/") && auxiliary == 0) {
                                message = "Math error!";
                                error = true;
                            }
                            if (!error) {
                                switch (operation) {
                                    case "+" -> total += auxiliary;
                                    case "-" -> total -= auxiliary;
                                    case "/" -> total /= auxiliary;
                                    case "*" -> total *= auxiliary;
                                    default -> {
                                        message = "Invalid operation!";
                                        error = true;
                                    }
                                }
                            }
                        } catch (ArithmeticException e) {
                            message = "Math error!";
                            error = true;
                        }
                    } catch (InputMismatchException e) {
                        message = "Invalid value!";
                        error = true;
                    }
                }
            }
        } while (!operation.equals("=") && !error);
        if (error) {
            System.out.println(message);
        } else {
            System.out.println("\n\n\n" + calculation + " " + total);
        }
    }
}
