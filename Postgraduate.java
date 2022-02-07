import java.util.Scanner;
public class Postgraduate extends StudentLoanAccount{
    private double researchGrantLoan;
    Scanner input = new Scanner(System.in);

    // Postgraduate(){

    // }
    Postgraduate(String name,String programEnrolled,int currentYear){
        super( name, programEnrolled, currentYear, 0.15, 3, "PG");//prepend for postgraduate is PG, subsistence loan interest is 15% and duration is 3 years
    }
    public void applyResearchGrantLoan(double researchGrantLoan){
        //loop to ensure that user enters a value within the range
        while(researchGrantLoan<50000 || researchGrantLoan >100000){
            System.out.print("\nSorry, amount entered for research grant should be within 50000 and 100000. \n Enter amount within the given range:");
            researchGrantLoan = input.nextDouble();
        }
         this.researchGrantLoan += researchGrantLoan ;     
           System.out.println("___Research-grant granted___");
    }
    public double getResearchGrantLoan(){
        return this.researchGrantLoan;
    }
    @Override
    public void getAllLoans() {
        //when user has no loanS
        if(super.getTuitionLoan() ==0 && super.getSubsistenceLoan() ==0 && this.researchGrantLoan == 0 ){
            System.out.println("\nYou don't have any Loan at the moment.");
            return;
        }
        super.getAllLoans();
        System.out.printf("\nResearch     \t\t %12.2f \t\t %9s",this.researchGrantLoan," Not applicable \n" );
    }
}