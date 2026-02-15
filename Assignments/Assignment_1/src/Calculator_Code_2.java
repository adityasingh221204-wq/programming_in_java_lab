import java.util.Scanner;

class Calculator_2 {
    int add(int a, int b) {
        return a + b;
    }
    int subs(int a, int b) {
        return a - b;
    }
    int mul(int a, int b) {
        return a * b;
    }
    int div(int a, int b) {
        return a / b;
    }
}

class CalculatorApp_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();
        System.out.println("-----SymbiCalc-----");
        System.out.println("1. Add\n2. Subtract\n3. Multiply\n4. Divide\n5. Exit");
        System.out.println("Enter your choice:");
        int choice = sc.nextInt();
        if (choice == 5) {
            System.out.println("Program exiting");
            sc.close();
            return;
        } else if (choice < 1 || choice > 5) {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }
        System.out.println("Enter first number:");
        int x = sc.nextInt();
        System.out.println("Enter second number:");
        int y = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Addition result: " + calc.add(x, y));
                break;
            case 2:
                System.out.println("Subtract result: " + calc.sub(x, y));
                break;
            case 3:
                System.out.println("Multiplication result: " + calc.mul(x, y));
                break;
            case 4:
                if (y != 0) {
                    System.out.println("Divide result: " + calc.div(x, y));
                } else {
                    System.out.println("Error: Cannot divide by zero");
                }
                break;
        }
        sc.close();
    }
}