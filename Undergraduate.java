public class Undergraduate extends StudentLoanAccount{
    private double stationeryLoan;

    Undergraduate(){

    }
    Undergraduate(String name,String programEnrolled, int currentYear,double tuition, double subsistence, double stationerLoan,double allowance){
        this.stationeryLoan = stationerLoan;
        this.allowance = allowance;
    }

    public void setAllowance(double allowance){
        this.allowance = allowance;
    }
    private double getAllowance(){
        return allowance;
    }

    /***
     * this method calculates stationery allowance with interest
     * stationeryLoan
     */

    public void setStationeryLoan(double stationeryLoan){
        this.stationeryLoan = Math.pow(getAllowance()*(1+(0.15/1)),1);
    }

    public double getStationeryLoan(){
        return stationeryLoan;
    }
    //  public String toString(){
    //     return "Account name "+ getName() + "\tprogram name" + getProgramEnrolled() + "\tAccount Number UG" + getAccNumber() + "\n";
    // }
}
