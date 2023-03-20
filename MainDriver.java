//Title: Banking Application
//Author: Edgar Bahena
//Email: ebahena5@toromail.csudh.edu
//Date: 03/19/2023

import java.util.Scanner;

public class MainDriver{
    public static Scanner scnr = new Scanner(System.in);
    public static Bank chase = new Bank();
    public static void main(String[] args){
        int userInput = printMenu();
        checkChoices(userInput);
    }

    public static int printMenu(){
        System.out.println("\n1 - Open a Checking Account");
        System.out.println("2 - Open a Savings Account");
        System.out.println("3 - List Accounts");
        System.out.println("4 - Account Statements");
        System.out.println("5 - Deposit Funds");
        System.out.println("6 - Withdraw Funds");
        System.out.println("7 - Close an Account");
        System.out.println("8 - Exiting\n");
        System.out.print("Please Enter your choice: ");
        int userInput = scnr.nextInt();
        scnr.nextLine();

        //Error checking
        while( !((userInput >= 1) && (userInput <= 8)) ){
            userInput = printMenu();
        }
        //return valid option
        return userInput;
    }

    public static Person createCustomer(){
        //Returns a Reference to created person obj
        System.out.print("Enter first name: ");
        String firstName = scnr.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scnr.nextLine();
        System.out.print("Enter social security number: ");
        String SSN = scnr.nextLine();
        Person customer = new Person(firstName, lastName, SSN);
        return (customer);
    }
    public static int getAccountNumber(){
        System.out.print("Enter account number: ");
        int accountNumber = scnr.nextInt();
        scnr.nextLine();
        return accountNumber;
    }

    public static void checkChoices(int userSelection){
        switch(userSelection){
            case 1: openCheckingAccount();
                    checkChoices(printMenu());
                break;
            case 2: openSavingsAccount();
                    checkChoices(printMenu());
                break;
            case 3: listAccounts();
                    checkChoices(printMenu());
                break;
            case 4: accountStatements();
                    checkChoices(printMenu());
                break;
            case 5: depositFunds();
                    checkChoices(printMenu());
                break;
            case 6: withdrawFunds();
                    checkChoices(printMenu());
                break;
            case 7: closeAccount();
                    checkChoices(printMenu());
                break;
            case 8: System.out.println("Exiting");
                break;
            default: checkChoices(printMenu());
        }
    }

    public static void openCheckingAccount(){
        Person customer = createCustomer();
        System.out.print("Enter overdraft limit: ");
        double overdraft = scnr.nextDouble();
        Account temp = chase.createCheckAccount(customer, overdraft);
        System.out.println("Thank you, the account number is: " + temp.getId());
    }
    public static void openSavingsAccount(){
        Account temp = chase.createSaveAccount(createCustomer());
        System.out.println("Thank you, the account number is: " + temp.getId());
    }
    public static void listAccounts(){
        //Prints all accounts
        chase.listAccounts();
    }
    public static void accountStatements(){
        int accountNum = getAccountNumber();
        chase.listAccountStatements(accountNum);
    }
    public static void depositFunds() {
        int number = getAccountNumber();
        System.out.print("Enter the amount to deposit: ");
        double depositAmount = scnr.nextDouble();
        scnr.nextLine();
        if (chase.depositToAccount(number, depositAmount) == true) {
            Account temp = chase.findAccount(number);
            System.out.printf("Deposit successful, the new balance is: " + temp.getBalance());
        }
        else if(chase.depositToAccount(number, depositAmount) == false){
            Account temp = chase.findAccount(number);
            System.out.print("Deposit failed, the balance is: " + temp.getBalance());
        }
        else{
            System.out.println("Account not found");
        }
    }
    public static void withdrawFunds(){
        int number = getAccountNumber();
        System.out.print("Enter the amount to withdrawal amount: ");
        double withdrawAmount = scnr.nextDouble();
        scnr.nextLine();
        if(chase.withdrawFromAccount(number, withdrawAmount) == true){
            Account temp = chase.findAccount(number);
            System.out.print("Withdrawal successful, the new balance is: " + temp.getBalance());
        }
        else if(chase.withdrawFromAccount(number, withdrawAmount) == false){
            Account temp = chase.findAccount(number);
            System.out.print("Withdrawal failed, the balance is: " + temp.getBalance());
        }
        else{
            System.out.println("Account not found");
        }

    }
    public static void closeAccount(){
        System.out.println("Enter account number to close: ");
        int accountNumber = scnr.nextInt();
        scnr.nextLine();
        if(chase.closeAccount(accountNumber) == true){
            Account temp = chase.findAccount(accountNumber);
            System.out.print("Account closed, current balance is " + temp.getBalance());
            if(temp.getBalance() > 0){
                System.out.println(", deposits are no longer possible");
            }
            else if(temp.getBalance() < 0){
                System.out.println(", withdrawals are no longer possible");
            }
        }
        else{
            System.out.println("Account not found");
        }
    }
}