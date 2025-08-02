import java.util.Scanner;

public class BasicCalculator {

    public static void main(String[] args) {

        String savedResultStr = "";
        double savedResult = 0;

        double num1 = 0;
        double num2 = 0;

        while(true) {
            Scanner input = new Scanner(System.in);

            if(savedResultStr.isEmpty()) {
                System.out.println("Enter first number:");
                num1 = input.nextDouble();

            } else {
                num1 = savedResult;
                System.out.println("First number: " + num1);
            }

            System.out.println("Enter second number:");
            num2 = input.nextDouble();

            System.out.println("Choose an operator: +, -, *, or /");
            char operator = input.next().charAt(0);

            double result = 0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    System.out.println(num1 + " + " + num2 + " = " + result);
                    break;

                case '-':
                    result = num1 - num2;
                    System.out.println(num1 + " - " + num2 + " = " + result);
                    break;

                case '*':
                    result = num1 * num2;
                    System.out.println(num1 + " * " + num2 + " = " + result);
                    break;

                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.println(num1 + " / " + num2 + " = " + result);
                    } else {
                        System.out.println("Error! Division by zero is not allowed.");
                    }
                    break;

                default:
                    System.out.println("Invalid operator!");
                    break;
            }

            savedResult = result;
            savedResultStr = String.valueOf(result);
            System.out.println("Saved result: " + savedResult);

            

        }
    }
}