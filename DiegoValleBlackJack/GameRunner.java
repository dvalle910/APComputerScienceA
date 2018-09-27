/**
 * Write a description of class GameRunner here.
 *
 * @author Diego Oscar Valle
 * @version 9.12.2018
 */

import java.util.Scanner;
public class GameRunner{
    public static void BlackJack(String[] args){
        Scanner scanner = new Scanner(System.in);
        Hand player = new Hand();
        Hand dealer = new Hand();
        boolean trigger = true;
        
        System.out.println("The dealer is showing a 'X' and a " + dealer.getCardTwo() + ".");
        System.out.println("You have a " + player.getCardOne() + " and a " + player.getCardTwo() + ".");
        //player loop until scanner != hit
        while(trigger == true){
            String input = scanner.next().toLowerCase();
            if(input.equals("hit")){
                System.out.println("You drew a " + player.hit());
                System.out.println("Your total is " + player.getTotal() + ".");
            }else if(input.equals("stay")){
                System.out.println("You stayed.");
                trigger = false;
            }else{
                System.out.println("Please state if you want to be hit or if you want to stay.");
            }
            if(player.getTotal() > 21){
                System.out.println("You busted.");
                trigger = false;
            }
        }
        
        //player loop until dealer.getTotal() < 17
        System.out.println();
        System.out.println("The dealer is now showing a " + dealer.getCardTwo() +" and a " + dealer.getCardTwo() + ".");
        while(dealer.getTotal() < 17){
            System.out.println("The dealer drew a " + dealer.hit() + ".");
        }
        System.out.println("The dealer stays.");
        
        //vitory/loss/bust checker
        if(player.getTotal() > 21){
            System.out.println("Dealer wins...");
        }else{
            if(dealer.getTotal() > 21){
                System.out.println("Player wins!");
            }else if(dealer.getTotal() > player.getTotal()){
                System.out.println("Dealer wins...");
            }else if(player.getTotal() > dealer.getTotal()){
                System.out.println("Player wins!");
            }else{
                System.out.println("It's a push.");
            }
        }
    }
}