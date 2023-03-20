public class Person {
    private String firstName;
    private String lastName;
    private String SSN;
    public Person(String firstName, String lastName, String SSN){
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
    }
    public String toString(){
        String personInfo = "";
        personInfo += firstName + " : " + lastName + " : " + SSN + " :";
        return (personInfo);
    }
}
