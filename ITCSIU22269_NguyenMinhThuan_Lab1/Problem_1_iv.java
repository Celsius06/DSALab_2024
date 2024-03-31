import java.util.Scanner;

public class Problem_1_iv {
    public static class BankAccount {
        private double balance; 
    
        public BankAccount(double openingBalance) 
        {
            balance = openingBalance;
        }
    
        public void deposit(double amount) 
        {
            balance = balance + amount;
            System.out.println("Deposit: " + amount + ", New Balance: " + getBalance());
        }
    
        public void withdraw(double amount) 
        {
            balance = balance - amount;
            System.out.println("Withdrawal: " + amount + ", New Balance: " + getBalance());
        }
    
        public double getBalance() 
        {
            return balance;
        }
    
        // Method to transfer the entire balance to another account
        public void transferBalance(BankAccount recipient) {
            recipient.deposit(balance);
            balance = 0; // Set the balance of this account to zero after transfer
            System.out.println("Balance transferred to the second account.");
        }
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            // Creating two bank accounts
            System.out.print("Enter the opening balance for Account 1: ");
            double openingBalance1 = scanner.nextDouble();
            BankAccount account1 = new BankAccount(openingBalance1);
            
            System.out.print("Enter the opening balance for Account 2: ");
            double openingBalance2 = scanner.nextDouble();
            BankAccount account2 = new BankAccount(openingBalance2);

            System.out.println();
    
            // Depositing and withdrawing from account 1
            System.out.print("Enter the amount to deposit into Account 1: ");
            double depositAmount = scanner.nextDouble();
            account1.deposit(depositAmount);
    
            System.out.print("Enter the amount to withdraw from Account 1: ");
            double withdrawAmount = scanner.nextDouble();
            account1.withdraw(withdrawAmount);
    
            System.out.println();
            
            // Printing balance of account 1
            System.out.println("Current Balance in Account 1: " + account1.getBalance());
    
            // Transferring the entire balance from account 1 to account 2
            account1.transferBalance(account2);
    
            // Printing balance of account 2
            System.out.println("Final Balance in Account 2: " + account2.getBalance());
    
            scanner.close(); // Close the scanner
        }
    }
}
