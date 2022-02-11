package week2.bank_account;

import java.util.Random;

public class BankAccount {
    
    protected static int numAccounts = 0;
    protected static double totalMoney = 0.0;
    protected static Random myRands = new Random();
    
    protected String accountId;
    protected double checkingBalance;
    protected double savingsBalance;
    
    public BankAccount(){
        this.accountId = generateAccountId();
        numAccounts += 1;
    }

    private static String generateAccountId() {
        String result = "";
        for (int i = 0; i < 10; i++){
            result += myRands.nextInt(10);
        }
        return result;
    } 

    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public void adjustSavings(double amount) {
        if (this.savingsBalance + amount >= 0.0) {
            this.savingsBalance += amount;
            totalMoney += amount;
        }
    }
    
    public void adjustChecking(double amount) {
        if (this.checkingBalance + amount >= 0.0) {
            this.checkingBalance += amount;
            totalMoney += amount;
        }
    }

    public double accountTotalBalance() {
        return this.checkingBalance + this.savingsBalance;
    }

    public void close() {
        totalMoney -= this.accountTotalBalance();
        numAccounts -= 1;
    }

    public String toString() {
        String result = "";
        result += String.format("Account id: %s%n", this.accountId);
        result += String.format("Checking Balance: %,.2d%n", this.checkingBalance);
        result += String.format("Savings Balance: %,.2d%n", this.savingsBalance);
        return result;
    }

    public static void main(String[] args) {


    }

}
