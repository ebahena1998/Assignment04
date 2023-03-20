public class DebitStatements extends Statement{
    public DebitStatements(String type, double amount){
        super(type, amount);
        super.setType("Debit");
    }
    public String toString(){
        String debitInfo = "";
        debitInfo += super.toString();
        return debitInfo;
    }
}
