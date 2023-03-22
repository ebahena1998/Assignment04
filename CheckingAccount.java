public class CheckingAccount extends Account{
    public CheckingAccount(Person customer, int id, double overdraft) throws AccountClosedException{
        super(customer, id);
        super.withdraw(overdraft);
    }
    @Override
    public String toString(){
        String checkingInfo = "";
        checkingInfo += getId() + "(Checking) : " + super.toString();
        return checkingInfo;
    }
}
