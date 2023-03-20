public class Statement {
    private static int transactionId = 0;
    private String type;
    private double amount;
    public Statement(String type, double amount){
        this.type = type;
        this.amount = amount;
    }
    //Setters
    public void setType(String type){
        this.type = type;
    }
    public String toString(){
        String statementInfo = "";
        statementInfo += ((transactionId++) + " : " + type + " : " + amount);
        return statementInfo;
    }
}
