package service_app;
import custom_exceptions.InSufficientFundsException;
import models.Account;
import java.util.Scanner;
public class Main {
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter name\n");
        String accountHolder=sc.nextLine();
        Account customer= new Account(accountHolder);
        int choice=0;
        while(choice!=4){
            System.out.println("submit your choice of action \n 1. Deposit\n 2. Withdraw\n 3. View History\n 4. Exit\n");
            choice=sc.nextInt();
            double amount;
            switch(choice){
                case 1:
                    System.out.println("Enter amount to deposit\n");
                    amount=sc.nextDouble();
                    try{
                        customer.deposit(amount);
                        System.out.println("Transaction successfull money is deposited\n");
                    }catch (IllegalArgumentException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw\n");
                    amount=sc.nextDouble();
                    try{
                        customer.processTransaction(amount);
                        System.out.println("Transaction successfull money is deducted");
                    }catch (IllegalArgumentException e) {
                        System.out.println("Transaction failed: "+e.getMessage());
                    }catch (InSufficientFundsException e)
                    {
                        System.out.println("Transaction Failed: "+e.getMessage());
                    }
                    break;
                case 3:
                    customer.printMiniStatement();
                    break;
                case 4:
                    choice=4;
                    break;


            }
        }
    }

}
