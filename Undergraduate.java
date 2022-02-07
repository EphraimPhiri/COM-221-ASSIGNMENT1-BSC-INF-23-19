public class Undergraduate extends StudentLoanAccount{
    private double stationaryLoan;
    private double stationaryLoanInterest; 
    private final double stationaryInterestRate = 0.15;
    // Undergraduate(){

    // }
    Undergraduate(String name,String programEnrolled, int currentYear){
        super(name, programEnrolled, currentYear, 0.11, 4, "UG");// The duration for under graduate is 4 years and subsistence rate is 11%
    }
    //applying for stationary loan
    public void applyForStationaryLoan(double stationaryAmount){
        double payBackAmount =  AnnualCompoundInterest(stationaryAmount, this.stationaryInterestRate);
        this.stationaryLoan += payBackAmount;
        this.stationaryLoanInterest += payBackAmount - stationaryAmount; 
        System.out.println("____Stationary Loan granted____");
    }
    //Repaying stationary Loan
    public void payBackStationaryLoan(double amount){
        //returns cash when user has no loan
        if(this.stationaryLoan <= 0){
            System.out.printf("You don't have any stationary loan at the moment..." + 
                            "\nMWK%.2f returned \n", amount );
            return;
        }
        double extra = 0 ; // variable keeps the amount of money remaining after repaying loan
        //When the user fully repays  stationary loan
        if(this.stationaryLoan - amount <= 0){
            System.out.println("You have Successfully repaid your stationary loan.");
            
            //Returns extra money if the amount paid back is > loan
            if(this.stationaryLoan - amount < 0.00) {
                extra = amount - this.stationaryLoan;
                System.out.printf("The extra money: MWK%.2f returned \n", extra );
            }
            //apparently user has no loan
            this.stationaryLoan = 0;
            this.stationaryLoanInterest =0; //sets interest to zero when the loan is fully repaid
        }
        //when the amount paid did not fully repay the loan 
        else{ 
            System.out.printf("You've paid MWK%.2f to your stationary loan\n", amount);
            this.stationaryLoan -= amount;
        } 
    }
     public double getStationaryLoan(){
        return this.stationaryLoan;
    }
    @Override
    public void getAllLoans() {
        //When user has no loan 
        if(super.getTuitionLoan() ==0 && super.getSubsistenceLoan() ==0 && this.stationaryLoan ==0 ){
            System.out.println("\n___You don't have any Loan right now___ ");
            return; //terminates the method
        }
        super.getAllLoans();
        System.out.printf("\nStationary  \t\t %12.2f \t\t %9.2f \n", this.stationaryLoan, this.stationaryLoanInterest);
    }
    @Override
    public double getTotalLoans() {
        return super.getTotalLoans() + this.stationaryLoan;
    }
}