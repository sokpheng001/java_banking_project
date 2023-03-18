package instad.bank.project;



import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Card extends Account implements SavingAccount {
    protected String getDate;
    private double amount_of_money,amount_of_withdraw,amount_of_deposit;
    private double number_of_withdraw=0;
    private final double limiter =1000;
    @Override
    public void deposit(double amount_of_deposit) {
        if((amount_of_deposit<limiter &&!(amount_of_deposit<0))||amount_of_deposit==limiter){
            System.out.println("----------------------------------------------".toUpperCase());
            this.amount_of_deposit = amount_of_deposit;
            this.amount_of_money += amount_of_deposit;
            System.out.println("Deposited: ".toUpperCase() + this.amount_of_deposit + "$");
            super.balance = super.balance+amount_of_deposit;
        }else if(amount_of_deposit>limiter || amount_of_deposit<0 ||amount_of_deposit<0){
            if(amount_of_deposit<0){
                System.out.println("Invalid insertion".toUpperCase());
            }else{
                System.out.println("Cannot deposit".toUpperCase());
            }
        }
    }
    @Override
    public void withDraw(double amount_of_withdraw) {
        DateTimeFormatter  dateTimeFormatter  = DateTimeFormatter.ofPattern("E, dd-MMMM-YY");
        this.amount_of_withdraw = amount_of_withdraw;
        this.getDate = String.valueOf(LocalDate.now().format(dateTimeFormatter));//get date in format
        if(this.amount_of_withdraw>super.balance || this.amount_of_withdraw<=0 ||this.amount_of_withdraw>limiter){
            if(this.amount_of_withdraw<0){
                System.out.println("Invalid insertion".toUpperCase());
            }else {
                System.out.println("Cannot withdraw".toUpperCase());
            }
        }else {
            super.balance = super.balance-amount_of_withdraw;
            this.number_of_withdraw+=amount_of_withdraw;
            System.out.println("Amount of withdraw: ".toUpperCase() + amount_of_withdraw+ "$");
        }

    }
    @Override
    public void showBalance() {
        System.out.println("------------ Information ------------".toUpperCase());
        System.out.println(super.accountInfo());
        System.out.println("Total money balance in account: ".toUpperCase() + super.balance + "$");
        DateTimeFormatter  dateTimeFormatter  = DateTimeFormatter.ofPattern("E, dd-MMMM-YY");
        this.getDate = String.valueOf(LocalDate.now().format(dateTimeFormatter));
        if(this.amount_of_withdraw<=0){
            if(super.balance<0||this.amount_of_withdraw>super.balance){
                System.out.println("Cannot withdraw.".toUpperCase());
                return;
            }
        }else{
            System.out.println("Amount withdrawn: ".toUpperCase() + this.number_of_withdraw + "$ "+ "ON " + this.getDate);
        }
        System.out.println("DATE: " + LocalDate.now() + "\nTime: ".toUpperCase()  + LocalTime.now());
        System.out.println("----------------------------------------------".toUpperCase());
    }

    @Override
    public void usd() {
        System.out.println("the interest in usd: ".toUpperCase() + super.balance*0.06 + "$");
    }

    @Override
    public void riel() {
        System.out.println("The interest in KHMER Riel: ".toUpperCase() + super.balance*0.09 + "$");

    }
}
