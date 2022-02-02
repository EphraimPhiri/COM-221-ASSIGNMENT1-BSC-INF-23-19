public class StudentLoanAccount{
    private String name;
    private String programEnrolled;
    private int currentYear;
    private double tuition;
    private double subsistence;
    StudentLoanAccount(){

    }
    StudentLoanAccount(String name,String programEnrolled,int currentYear,double tuition,double subsistence){
        this.name = name;
        this.programEnrolled = programEnrolled;
        this.currentYear = currentYear;
        this.tuition = tuition;
        this.subsistence = subsistence;
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
}