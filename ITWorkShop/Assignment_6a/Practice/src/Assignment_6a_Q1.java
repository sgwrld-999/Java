import java.util.Scanner;

public class Assignment_6a_Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Command: ");
        String input = sc.nextLine().toUpperCase();

        int sum = 0;

        if (input.length() <= 4) {
            System.out.println("Error: NO OPERAND GIVEN!");
        } else if (input.length() <= 6) {
            System.out.println("Error: ONLY 1 OPERAND GIVEN!");
        } else if (!input.startsWith("ADD")) {
            System.out.println("Error: Invalid Operation");
        } else {
            String operand = input.substring(4);
            String[] operandsArray = operand.split("\\s+");
            for (String numStr : operandsArray) {
                int num = Integer.parseInt(numStr);
                sum += num;
            }
            System.out.println("SUM: " + sum);
        }
    }
}
