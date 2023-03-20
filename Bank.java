import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accountList = new ArrayList<>();
    private static int accountId = 100;
    public Account createCheckAccount(Person customer, double overdraft){
        Account newCheckAccount = new CheckingAccount(customer, accountId++, overdraft);
        accountList.add(newCheckAccount);
        return newCheckAccount;
    }
    public Account createSaveAccount(Person customer){
        Account newSaveAccount = new SavingsAccount(customer, accountId++);
        accountList.add(newSaveAccount);
        return newSaveAccount;
    }
    public Account findAccount(int id) {
        for (Account temp : accountList) {
            if (temp.getId() == id) {
                return temp;
            }
        }
        return null;
    }
    public void listAccounts(){
        for(Account temp : accountList){
            System.out.println(temp);
        }
    }
    public void listAccountStatements(int id){
        if(findAccount(id) != null){
            findAccount(id).printStatements();
        }
    }
    public boolean depositToAccount(int accountId, double amount) {
        Account temp = findAccount(accountId);
        if(temp != null && (temp.getStatus() == true)){
            temp.deposit(amount);
            return true;
        }else if(temp.getStatus() == false && temp.getBalance() < 0.00){
            temp.deposit(amount);
            return true;
        }
        return false;
    }
    public boolean withdrawFromAccount(int accountId, double amount){
        Account temp = findAccount(accountId);
        if(temp != null && (temp.getStatus() == true)) {
            temp.withdraw(amount);
            return true;
        }else if(temp.getStatus() == false && temp.getBalance() > 0.00){
            temp.withdraw(amount);
            return true;
        }
        return false;
    }
    public boolean closeAccount(int accountId){
        Account temp = findAccount(accountId);
        if(temp != null){
            temp.setStatus(false);
            return true;
        }
        return false;
    }
}
