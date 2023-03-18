package instad.bank.project;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;

abstract public class Account implements SavingAccount {
    private String name;
    private String card_number;
    private  int pin_number;
    protected double balance=0;
    private int phone_number;
    public void account(){
        this.name = "Opp Pi";
        this.card_number = "1234567******12";
        this.pin_number = 223344;
        this.accountDetail();
    }
    public void accountDetail(){
        System.out.println("--------- Account Detail ------------".toUpperCase());
        System.out.println("account number: ".toUpperCase() + this.card_number);
        System.out.println("account name: ".toUpperCase() + this.name);
        System.out.println("total money balance: ".toUpperCase() + this.balance + "$");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E, dd-MMMM-YY");
        System.out.println("Date: ".toUpperCase() + LocalDate.now().format(dateTimeFormatter));
    }
    public LocalDateTime checkExpire(LocalDate now){
        LocalDateTime check = LocalDateTime.now().plusDays(365);
        if(now.isAfter(ChronoLocalDate.from(check))){
            System.out.println("-> Your card is expired!!!!".toUpperCase());
            System.out.println("----------------------------");
        }else {
            return check;
        }
        return check;
    }
    public void deposit(double amount_of_money){}
    //check amount of deposit
    public void checkLimit(double limiter){}
    public void withDraw(double amount_of_withdraw){}
    public void showBalance(){}
    String accountInfo(){
        return "Card number: ".toUpperCase() + card_number + "\nAccount name: ".toUpperCase() + this.name;
    }
}

