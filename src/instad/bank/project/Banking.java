package instad.bank.project;


import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Banking {
    public static void main(String[] args) throws IOException {
        //Cannot withdraw or deposit greater than 1000$ or withdraw greater than amount of money in the balance.
        LocalDateTime now = LocalDateTime.now().plusDays(10);//check if the card is expired.
        Card account = new Card();
        if(now.isBefore(account.checkExpire(LocalDate.from(now)))){
            Account card = new Card();
            card.account();
            card.deposit(1000);//Be able to deposit only 1000 once.
            card.deposit(1000);//Be able to deposit only 1000 once.
            card.deposit(1200);//cannot deposit.
            card.deposit(-1000);//Invalid insertion from your computer
            card.showBalance();
            card.withDraw(1000);//Be able to withdraw only 1000 once.
            card.withDraw(1200);//cannot withdraw.
            card.withDraw(-190);//Invalid insertion from your computer
            card.showBalance();
            card.withDraw(10);//cannot withdraw.
            card.showBalance();
            card.riel();
            card.usd();
            System.out.println("----------------------------------------------".toUpperCase());
        }else {

        }
    }
}