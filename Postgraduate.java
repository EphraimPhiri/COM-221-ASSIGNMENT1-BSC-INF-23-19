import java.util.*;
public class Postgraduate extends StudentLoanAccount{
    private double researchGrantLoan;
    Scanner input = new Scanner(System.in);

    Postgraduate(){

    }
    Postgraduate(String name,String programEnrolled,int currentYear,double tuition,double subsistence,double researchGrantLoan){
        while(researchGrantLoan!=0&&(researchGrantLoan<50000 || researchGrantLoan >100000)){
            System.out.println("Amount entered for research grant should be within 50000 and 100000.");
           researchGrantLoan = input.nextDouble();
        }
        this.researchGrantLoan = researchGrantLoan;
    }

    public void setResearchGrantLoan(double researchGrantLoan){
        while(researchGrantLoan!=0&&(researchGrantLoan<50000 || researchGrantLoan >100000)){
            System.out.println("Amount entered for research grant should be within 50000 and 100000.");
           researchGrantLoan = input.nextDouble();
        }
        this.researchGrantLoan = researchGrantLoan;
    }

    public double getResearchGrantLoan(){
        return researchGrantLoan;
    }
    // public String toString(){
    //     return "Account name "+ getName() + "\tprogram name" + getProgramEnrolled() + "\tAccount Number PG" + getAccNumber() + "\n";
    // }
}