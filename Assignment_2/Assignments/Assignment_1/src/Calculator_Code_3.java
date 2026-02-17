import java.util.Scanner;

class Calculator_3 {
    int add(int a, int b) {
        return a + b;
    }
    int sub(int a, int b) {
        return a - b;
    }
    int mul(int a, int b) {
        return a * b;
    }
    int div(int a, int b) {
        return a / b;
    }
}

class CalculatorApp_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();
        int choice;

        do {
            System.out.println("\n--- SymbiCalc Menu ---");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            if (choice == 5) {
                System.out.println("Program exiting... Goodbye!");
                break;
            } else if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice! Please try again.");
                continue;
            }
            System.out.print("Enter first number: ");
            int x = sc.nextInt();
            System.out.print("Enter second number: ");
            int y = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Result: " + calc.add(x, y));
                    break;
                case 2:
                    System.out.println("Result: " + calc.sub(x, y));
                    break;
                case 3:
                    System.out.println("Result: " + calc.mul(x, y));
                    break;
                case 4:
                    if (y != 0) {
                        System.out.println("Result: " + calc.div(x, y));
                    } else {
                        System.out.println("Error: Cannot divide by zero.");
                    }
                    break;
            }
        } while (choice != 5);
        sc.close();
    }
}