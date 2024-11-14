package Source;

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double IB) {
        balance = IB;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else if (amount > 0) {
            balance = balance - amount;
            System.out.println("Successfully withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }
    public double checkBalance() {
        return balance;
    }
}
class ATM {
    private BankAccount account;
    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the ATM!");

        while (running) {
            System.out.println("ATM Menu : ");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Select the option : ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance is: " + account.checkBalance());
                    break;

                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:                   
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 4:
                    running = false;
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.print("Invalid option!");
                    System.out.println("Please try again.");
                    break;
            }
        }
        sc.close();
    }
}

public class ATM_Interface {
    public static void main(String[] args) {
        BankAccount UserAccount = new BankAccount(100000.00);
        ATM atm = new ATM(UserAccount);
        atm.start();
    }
}
