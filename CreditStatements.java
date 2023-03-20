public class CreditStatements extends Statement{
    public CreditStatements(String type, double amount){
        super(type, amount);
        super.setType("Credit");
    }
    public String toString(){
        String creditInfo = "";
        creditInfo += super.toString();
        return creditInfo;
    }
}
