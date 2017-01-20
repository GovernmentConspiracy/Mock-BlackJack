/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Player
{
    private ArrayList<Card> hand;
    private String[] suits = {"S", "C", "D", "H"};
    public Player()
    {
        hand = new ArrayList<Card>();
    }
    
    public ArrayList<Card> getHand()
    {
        return hand;
    }
    
    public void addCard(Card c) //double down + hit
    {
        hand.add(c);
    }
    
    public int totalHand(Player a)
    {
        int total = 0;
        int count = 0;
        int current;
        for (int i = 0; i < getHand().size(); i++)
        {
            current = hand.get(i).getValue();
            if (current == 11)
            {
                current = 0;
                count++;
            }
            total = total + current;
        }
        for (int i = 0; i < count; i++)
        {
            if (total + 11 > 21)
            {
                total++;
            }
            else
            {
                total = total + 11;
            }
        }
        return total;
    }
    
    public boolean checkLoss(int handValue)
    {
        return (handValue>21);
    }
    
    public void display(ArrayList<Card> decks)
    {
        for (int i = 0; i < decks.size(); i++)
        {
            Card current = decks.get(i);
            System.out.print(current.getValue());
            System.out.print(suits[current.getSuit()]);
            if (decks.size() > i + 1)
            System.out.print(", ");
        }
        System.out.println("");
    }
}
