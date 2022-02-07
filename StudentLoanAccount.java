import java.util.ArrayList;
import java.util.Random;

public class StudentLoanAccount{
    public static ArrayList<StudentLoanAccount> loanAccounts = new ArrayList<>();
    private String name;
    private String programEnrolled;
    private int currentYear;
    private int programDuration;
    private double tuition;
    private double tuitionInterest;
    private double subsistence;
    private double subsistenceInterest;
    private String accountNumber;
    public final double subsistenceInterestRate;

    // StudentLoanAccount(){

    // }
    public StudentLoanAccount(String name,String programEnrolled, int currentYear, double subsistenceInterestRate, int programDuration, String accountNumberCode){
        this.name = name;
        this.programEnrolled = programEnrolled;
        this.currentYear = currentYear;
        this.programDuration = programDuration;
        this.subsistenceInterestRate = subsistenceInterestRate;
        //generate an account number using the method generateAccountNumber and assigning it to the variable 
        this.accountNumber = generateAccountNumber(accountNumberCode);
    }
    // method to generate an  account Number for a particular Student
    private String generateAccountNumber(String prepend){
        Random random = new Random(3);
        String accountNum;
        //generates an account number without checking the array
        if((StudentLoanAccount.loanAccounts).isEmpty()){
            accountNum = prepend + random.nextInt(1000);
            return accountNum;
        }
        //compares the account number generated with other account numbers generated
        else{
            Boolean accountExists = true;
            //iterates until account number generated is unique
            do{
                //generates account number before comparing
                accountNum = prepend + random.nextInt(1000);
                //comparing operation
                for(int i = 0; i< (StudentLoanAccount.loanAccounts).size(); i++){
                    
                    if(StudentLoanAccount.loanAccounts.get(i).getAccountNumber().equals(accountNum)){
                        accountExists = true;
                        break;  //breaks the for loop to generate another number in do while since the account exists
                    }
                    //Reaching the last index implies the account number does not exists therefore use the account Number generated
                    if(i+1 == StudentLoanAccount.loanAccounts.size()){
                        accountExists = false;
                    }
                }

            }while(accountExists);
            return accountNum;
        }
    }
    public String getAccountNumber() {
        return this.accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getProgramEnrolled() {
        return programEnrolled;
    }

    public void setProgramEnrolled(String programEnrolled) {
       this.programEnrolled = programEnrolled;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public int getProgramDuration() {
        return programDuration;
    }

    public void setProgramDuration(int programDuration) {
        this.programDuration = programDuration;
    }
    // sum up all the loans
     public double getTotalLoans(){
        return this.tuition + this.subsistence;
    }

    public void applyForTuitionLoan(double amount){
        /** 
         the amount to be applied is specified in the  method parameters and using the Annual Compound interest the amount to be paid back
         is calculated and passed to the private field Tuition and the interest is calculated by subtracting 
         the amount to be repaid minus the amount applied
        */
        double amountToBePaid = AnnualCompoundInterest(amount, 0.10);
        this.tuition += amountToBePaid;
        this.tuitionInterest = amountToBePaid - amount;
        System.out.println("___Tuition Loan Applied successfully___");
    }
    public void repayTuitionLoan(double amount){
        if(this.tuition <= 0){
            System.out.printf("You don't have any tuition loan right now...");
            return;
        }
        double extra = 0 ; //Amount left after paying the loan
        //message when the amount paid fully repays the loan 
        if(this.tuition - amount <= 0){
            System.out.println("You've Successfully repaid your tuition loan in full ");
            
            //returns Money left when amount is greater than the specified loan
            if(this.tuition - amount < 0) {
                extra = amount - this.tuition;
                System.out.printf("The money left is : MWK%.2f returned \n", extra );
            }
            //When User has no Tuition Loan
            this.tuition = 0;
            this.tuitionInterest = 0; //sets interest to zero when the loan is fully repaid
        }
        //message when the amount paid does not fully repay the loan 
        else{ 
            System.out.printf("You've paid MWK%.2f to your tuition loan\n", amount);
            this.tuition -= amount;
        }     
    }
    public double getTuitionLoan(){
        return this.tuition;
    }
    public void applyForSubsistenceLoan(double amount){
        /** 
         the amount to be applied is specified in the  method parameters and using the Annual Compound interest. the amount to be paid back
         is calculated and passed to the private field Subsistence and the interest is calculated by subtracting 
         the amount to be repaid minus the amount applied
        */
        double amountToBePaid = AnnualCompoundInterest(amount, this.subsistenceInterestRate);
        this.subsistence += amountToBePaid;
        this.subsistenceInterest = amountToBePaid - amount;
        System.out.println("___ Subsistence loan Applied successfully ___");
    }
    public void repaySubsistenceLoan(double amount){
            //returns amount paid when user has no loans
            if(this.subsistence <= 0){
                System.out.printf("You currently do not have any subsistence loan..." + 
                                "\nMWK%.2f returned \n", amount );
                return;
            }
        double extra = 0 ; //money left after paying the loan
        if(this.subsistence - amount <= 0){
            System.out.println("You've Successfully repaid your subsistence loan.");
            //returns extra money if the amount paid back is Greater than the loan 
            if(this.subsistence - amount < 0) {
                extra = amount - this.subsistence;
                System.out.printf("The extra money: MWK%.2f returned \n", extra );
            }
            //When User has no loans...
            this.subsistence = 0;
            this.subsistenceInterest = 0;//sets interest to zero when the loan is fully repaid
        }
        else{ 
            System.out.printf("You've paid MWK%.2f to your subsistence loan\n", amount);
            this.subsistence -= amount;
        }
    }
    public double getSubsistenceLoan(){
        return this.tuition;
    }
    //method to display all loans available  alongside their interests
    public void getAllLoans(){
        System.out.println("Type of Loan \t\t Loan amount\t\t Interest added" + 
        "\n------------------------------------------------------------------------------");
        System.out.printf("Tuition      \t\t %12.2f \t\t %9.2f" , this.tuition, this.tuitionInterest);
        System.out.printf("\nSubsistence  \t\t %12.2f \t\t %9.2f", this.subsistence, this.subsistenceInterest);
    }
    public double AnnualCompoundInterest(double amount, double rate){
        int numOfYears = this.programDuration - this.currentYear;
        double ACI = amount * ( Math.pow((1 + rate), numOfYears));
        return ACI;
    }
}