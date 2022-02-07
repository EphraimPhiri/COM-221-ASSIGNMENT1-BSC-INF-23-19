import java.util.*;

public class StudentLoanManagementSystem{
    public static void main(String [] args){

        Scanner input = new Scanner(System.in);
        ArrayList<Postgraduate> postArray = new ArrayList<>();
        ArrayList<Undergraduate> postArray = new ArrayList<>();

        home();
        System.out.println("\nENTER YOUR CHOICE:");
        int choice = input.nextInt();
        switch(choice){
            case 1: createAccount();
            case 2: 
            case 3: 
        Postgraduate postGraduate = new Postgraduate("ephr", "info", 1, 100, 100, 5000);
    }
     public static void home(){
         System.out.println("\n------------------------WELCOME TO LOAN MANAGEMENT SERVICES-------------------------\n");
         System.out.println("\nSELECT OPTION\n1.CREATE ACCOUNT\n2.PAYBACK LOAN\n3.EXIT"); 
     }
     public static void createAccount(){
         System.out.println("__________SELECT STUDENT TYPE__________\n\n1. UNDERGRADUATE \n2.POSTGRADUATE\n");
                    System.out.print("ENTER YOUR CHOICE:");
                    int choice1 = input.nextInt();

                    switch(choice1){
                        case 1: 
                        case 2: 
                    }
        }
     }  
}