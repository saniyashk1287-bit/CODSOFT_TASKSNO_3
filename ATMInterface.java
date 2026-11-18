import java.util.Scanner;

// class for the bank account
class BankAccount {
    private double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    double getBalance() {
        return balance;
    }

    void setBalance(double balance) {
        this.balance = balance;
    }
}

// class for the ATM machine
class ATM {
    BankAccount account;

    ATM(BankAccount account) {
        this.account = account;
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Enter a positive number.");
        } else if (amount > account.getBalance()) {
            System.out.println("Transaction failed. Not enough balance.");
        } else {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Withdrawal successful. Please take your cash.");
            System.out.println("Remaining balance: " + account.getBalance());
        }
    }

    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Enter a positive number.");
        } else {
            account.setBalance(account.getBalance() + amount);
            System.out.println("Deposit successful.");
            System.out.println("New balance: " + account.getBalance());
        }
    }

    void checkBalance() {
        System.out.println("Your balance is: " + account.getBalance());
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount(5000);
        ATM atm = new ATM(account);
        int choice = 0;

        System.out.println("Welcome to the ATM");

        while (choice != 4) {
            System.out.println();
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a number between 1 and 4.");
                sc.next();
                continue;
            }
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter amount to withdraw: ");
                if (sc.hasNextDouble()) {
                    atm.withdraw(sc.nextDouble());
                } else {
                    System.out.println("Invalid input.");
                    sc.next();
                }
            } else if (choice == 2) {
                System.out.print("Enter amount to deposit: ");
                if (sc.hasNextDouble()) {
                    atm.deposit(sc.nextDouble());
                } else {
                    System.out.println("Invalid input.");
                    sc.next();
                }
            } else if (choice == 3) {
                atm.checkBalance();
            } else if (choice == 4) {
                System.out.println("Thank you for using the ATM. Bye!");
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }
}
