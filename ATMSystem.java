import java.util.Scanner;

public class ATMSystem {
    
    private static String userID = "Hartej"; 
    private static String userPIN = "1400"; 
    private static double balance = 10000.00; // initial balance
    private static String[] transactions = new String[100]; // array to store transaction history
    private static int transactionIndex = 0; // index to keep track of transaction history
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the ATM system!");
        System.out.println("Please enter your user ID:");
        String inputID = scanner.nextLine();
        System.out.println("Please enter your PIN:");
        String inputPIN = scanner.nextLine();
        
        if (inputID.equals(userID) && inputPIN.equals(userPIN)) {
            System.out.println("\nWelcome, " + userID + " !");
            boolean quit = false;
            while (!quit) {
                System.out.println("\nPlease select an option:"
                +"\n1. View Transaction History"
                +"\n2. Withdraw"
                +"\n3. Deposit"
                +"\n4. Transfer"
                +"\n5. Quit");
                int option = scanner.nextInt();
                
                switch (option) {
                    case 1:
                        viewTransactionHistory();
                        break;
                    case 2:
                        System.out.println("Please enter the amount to withdraw:");
                        double withdrawAmount = scanner.nextDouble();
                        withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.println("Please enter the amount to deposit:");
                        double depositAmount = scanner.nextDouble();
                        deposit(depositAmount);
                        break;
                    case 4:
                        System.out.println("Please enter the recipient's user ID:");
                        String recipientID = scanner.next();
                        System.out.println("Please enter the amount to transfer:");
                        double transferAmount = scanner.nextDouble();
                        transfer(recipientID, transferAmount);
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM system!");
                        quit = true;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        } else {
            System.out.println("Invalid user ID or PIN. Please try again.");
        }
    }
    
    public static void viewTransactionHistory() {
        if (transactionIndex == 0) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("Transaction History:");
            for (int i = 0; i < transactionIndex; i++) {
                System.out.println(transactions[i]);
            }
        }
    }
    
    public static void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions[transactionIndex] = "Withdraw: $" + amount;
            transactionIndex++;
            System.out.println("Withdrawal successful. Current balance: $" + balance);
        } else {
            System.out.println("Insufficient balance. Please try again.");
        }
    }
    
    public static void deposit(double amount) {
        balance += amount;
        transactions[transactionIndex] = "Deposit: $" + amount;
        transactionIndex++;
        System.out.println("Deposit successful. Current balance: $" + balance);
    }
    
    public static void transfer(String recipientID, double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions[transactionIndex] = "Transfer to " + recipientID + ": $" + amount;
            transactionIndex++;
            System.out.println("Transfer successful. Current balance: $" + balance);
        }
        else{
            System.out.println("Insufficient balance. Please try again.");
        }
    }
}