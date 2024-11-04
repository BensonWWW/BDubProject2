import java.util.Scanner;

public class LinearEquationLogic {
    private Scanner scanner;

    public LinearEquationLogic() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the Linear Equation Program!");
        boolean continueProgram = true;

        while (continueProgram) {
            int[] coordinates = getCoordinates();
            LinearEquation equation = new LinearEquation(coordinates[0], coordinates[1], coordinates[2], coordinates[3]);

            System.out.println(equation.lineInfo());

            if (coordinates[0] != coordinates[2]) {
                double xValue = getXValue();
                System.out.println("Point on the line: " + equation.coordinateForX(xValue));
            } else {
                System.out.println("This line is vertical.");
            }

            continueProgram = askToContinue();
        }

        System.out.println("Thank you for using the Linear Equation Program!");
    }

    private int[] getCoordinates() {
        System.out.print("Enter the first coordinate (format: (x, y)): ");
        int[] point1 = parseCoordinate(scanner.nextLine());

        System.out.print("Enter the second coordinate (format: (x, y)): ");
        int[] point2 = parseCoordinate(scanner.nextLine());

        return new int[] { point1[0], point1[1], point2[0], point2[1] };
    }

    private int[] parseCoordinate(String input) {
        input = input.replaceAll("[()]", "");
        String[] parts = input.split(", ");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        return new int[] { x, y };
    }

    private double getXValue() {
        System.out.print("Enter an x value to get a coordinate on the line: ");
        return Double.parseDouble(scanner.nextLine());
    }

    private boolean askToContinue() {
        System.out.print("Would you like to enter another set of coordinates? (y/n): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("y");
    }
}