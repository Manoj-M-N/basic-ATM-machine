import java.util.Scanner;

public class Atm {

    Scanner s = new Scanner(System.in);
    int balance = 0;

    // Method to check PIN
    public void checkPin() {
        int pin = 4325;
        System.out.println("Enter your PIN:");
        int enteredPin = s.nextInt();

        if (enteredPin == pin) {
            System.out.println("**** WELCOME TO ATM ****");
            menu();
        } else {
            System.out.println("Invalid PIN. Please try again.");
            checkPin(); // Retry if PIN is incorrect
        }
    }

    // Menu method to show options
    public void menu() {
        System.out.println("\n---- Menu ----");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int option = s.nextInt();

        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                deposit();
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
                menu();
        }
    }

    // Check balance method
    void checkBalance() {
        System.out.println("Your current balance is: " + balance);
        menu();
    }

    // Withdraw method
    void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        int amount = s.nextInt();

        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Successfully withdrawn: " + amount);
        }
        menu();
    }

    // Deposit method
    void deposit() {
        System.out.print("Enter the amount to deposit: ");
        int amount = s.nextInt();

        balance += amount;
        System.out.println("Successfully deposited: " + amount);
        menu();
    }

    public static void main(String[] args) {
        Atm atm = new Atm();
        atm.checkPin();
    }
}
