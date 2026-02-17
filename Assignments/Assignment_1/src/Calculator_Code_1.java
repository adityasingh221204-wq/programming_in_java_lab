import java.util.Scanner;

class Calculator {
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

class CalculatorApp{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator(); //Object Creation
        System.out.println("SymbiCalc");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Exit");
        System.out.println("Enter your choice");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("Enter first number");
            int x = sc.nextInt();
            System.out.println("Enter second number");
            int y = sc.nextInt();
            int result = calc.add(x, y);    //Method Call Using Object
            System.out.println("Addition result: " + result);
        }
        else if (choice == 2) {
            System.out.println("Enter first number");
            int x = sc.nextInt();
            System.out.println("Enter second number");
            int y = sc.nextInt();
            int result = calc.sub(x, y);
            System.out.println("Subtract result: " + result);
        }
        else if (choice == 3) {
            System.out.println("Enter first number");
            int x = sc.nextInt();
            System.out.println("Enter second number");
            int y = sc.nextInt();
            int result = calc.mul(x, y);
            System.out.println("Multiplication result: " + result);
        }
        else if (choice == 4) {
            System.out.println("Enter first number");
            int x = sc.nextInt();
            System.out.println("Enter second number");
            int y = sc.nextInt();
            int result = calc.div(x, y);
            System.out.println("Divide result: " + result);
        }
        else if (choice == 5) {
            System.out.println("Program exiting");
        }
        else {
            System.out.println("Invalid choice");
        }
        sc.close();
    }
}