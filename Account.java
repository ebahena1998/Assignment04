import java.util.ArrayList;

public class Account {
    private Person customer;
    private int id;
    private double balance;
    private boolean status;
    private ArrayList<Statement> statementList = new ArrayList<Statement>();
    public Account(Person customer, int id){
        this.customer = customer;
        this.id = id;
        this.balance = 0.00;
        this.status = true;
    }
    //Getters
    public int getId(){
        return (this.id);
    }
    //Methods
    public void withdraw(double amount){
        if((status == true) && (amount > 0.00)){
            Statement newDebit = new DebitStatements("Debit : ", amount);
            statementList.add(newDebit);
            this.balance -= amount;
        }
        else if((status == false) && (balance > 0.00)){
            if(balance - amount < balance){
                this.balance -= amount;
            }
        }
    }
    public void deposit(double amount){
        if((status == true) && (amount > 0.00)){
            Statement newCredit = new CreditStatements("Credit : ", amount);
            statementList.add(newCredit);
            this.balance += amount;
        }
        else if((status == false) && (balance < 0.00)){
            if(balance + amount > balance){
                this.balance += amount;
            }
        }
    }
    public void printStatements(){
        for(Statement temp : statementList){
            System.out.println(temp);
        }
        System.out.println("Balance: " + balance);
    }
    public void setStatus(boolean status){
        this.status = status;
    }
    public boolean getStatus(){
        return this.status;
    }
    public double getBalance(){
        return (this.balance);
    }
    public String toString(){
        String accountInfo = "";
        accountInfo += customer.toString() + " ";
        accountInfo += String.format("%.2f : ", balance);
        if(status == true){
            accountInfo += "Account Open";
            return accountInfo;
        }
        accountInfo += "Account Closed";
        return accountInfo;
    }
}
