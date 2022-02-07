public class StudentLoanAccount{
    private String name;
    private String programEnrolled;
    private int currentYear;
    private double tuition;
    private double subsistence;
    private int programDuration;
    private double tuitionLoanInterest;
    private double subsistenceLoanInterest;
    StudentLoanAccount(){

    }
    StudentLoanAccount(String name,String programEnrolled,int currentYear,double tuition,double subsistence,int programDuration){
        this.name = name;
        this.programEnrolled = programEnrolled;
        this.currentYear = currentYear;
        this.tuition = tuition;
        this.subsistence = subsistence;
        this.programDuration = programDuration;
    }
    public String getName(){
        return name;
    }
    public String getProgramEnrolled(){
        return programEnrolled;
    }
    public int getCurrentYear(){
        return currentYear;
    }
    public double getTuition(){
        return tuition;
    }
    public double getSubsistence(){
        return subsistence;
    }
    public int getProgramDuration(){
        return programDuration;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setProgramEnrolled(String programEnrolled){
        this.programEnrolled=programEnrolled;
    }
    public void setCurrentYear(int currentYear){
        this.currentYear=currentYear;
    }
    public void setTuition(double tuition){
        this.tuition=tuition;
    }
    public void setSubsistence(double subsistence){
        this.subsistence=subsistence;
    }
    public void setProgramDuration(int programDuration){
        this.programDuration = programDuration;
    }
    public void applyForTuitionLoan(double amount){
        double repayAmount = AnnualCompoundInterest(amount, 0.1);
        this.tuitionLoan += repayAmount; 
        this.tuitionLoanInterest = repayAmount - amount;
    }
    public void applyForSubsistenceLoan(double amount, double rate){
        double repayAmount = AnnualCompoundInterest(amount, rate);
        this.subsistenceLoan += repayAmount;
        this.subsistenceLoanInterest = repayAmount - amount;
    }
    public double AnnualCompoundInterest(double amount, double rate) {
        int time =  this.programDuration - this.currentYear;
        double A = amount * (Math.pow((1 + rate), time ));
        return A;
    }
}