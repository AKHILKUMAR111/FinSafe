package models;
import custom_exceptions.InSufficientFundsException;

import java.util.ArrayList;

public class Account{
    private String accountHolder;
    private double balance;       
    private ArrayList<Double> transactionHistory; //will hold history of transaction

    public Account(String accountHolder){
        this.accountHolder=accountHolder;
        balance=0.0;
        transactionHistory=new ArrayList<>();


    }

    public void processTransaction(double amount) throws InSufficientFundsException
    {
        if(amount<0)
        {
            throw new IllegalArgumentException("Please enter a positive deposite amount");
        }
        if(amount>balance)
        {
            throw new InSufficientFundsException("Insufficient balance");
        }
        balance=balance-amount;
        if(transactionHistory.size()==5)
        {
            transactionHistory.remove(0);
        }
        transactionHistory.add(-1*amount);

    }

    public double getBalance()
    {
        return balance;
    }

    public String getAccountHolder()
    {
        return accountHolder;
    }

    public void deposit(double amount)
    {
            if(amount<=0)
            {
                throw new IllegalArgumentException("Please enter a positive deposite amount");
            }
            balance+=amount;
            if(transactionHistory.size()==5)
            {
                transactionHistory.remove(0);
            }
            transactionHistory.add(amount);

    }

    public void printMiniStatement(){
        for(double i:transactionHistory){
            if(i<0){
                System.out.println("withdrawn: "+ -1*i);
            }
            else {
                System.out.println("deposited: "+ i);
            }
        }
    }
}