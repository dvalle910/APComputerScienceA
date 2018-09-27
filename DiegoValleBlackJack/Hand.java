/**
 * Write a description of class Hand here.
 *
 * @author Diego Oscar Valle
 * @version 9.12.2018
 */
import java.lang.Math;
public class Hand{
    private int card1;
    private int card2;
    private int total;
    
    public Hand(){
        card1 = (int)(Math.random() * 12) + 1;
        card2 = (int)(Math.random() * 12) + 1;
        total = card1 + card2;
    }
    
    public int hit(){
        int randomCard = (int)(Math.random() * 12) + 1;
        total = total + randomCard;
        return randomCard;
    }
    
    public int getTotal(){
        return total;
    }
    
    public int getCardOne(){
        return card1;
    }
    
    public int getCardTwo(){
        return card2;
    }
}
