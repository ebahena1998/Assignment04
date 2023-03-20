public class SavingsAccount extends Account{
    public SavingsAccount(Person customer, int id){
        super(customer, id);
    }
    public String toString(){
        String saveInfo = "";
        saveInfo += getId() + "(Savings) : " + super.toString();
        return saveInfo;
    }
}
