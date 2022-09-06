import java.util.*;
public class Deck
{
    ArrayList<PlayingCard> deck = new ArrayList<PlayingCard>();
    Stack<PlayingCard> shuffled = new Stack<PlayingCard>();
    String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"};
    String[] values = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    
    public Deck()
    {
        for (int x = 0; x < values.length; x++)
            for (int y = 0; y < suits.length; y++)
                deck.add(new PlayingCard(values[x], suits[y]));        
    }
    
    public int[] generator(int min, int max, int amount) {
        int[] nums = new int[amount];
        for (int x = 0; x < amount; x += 1)
            nums[x] = (int)((Math.random() * max) + min);
        return nums;
    }
    
    public void shuffle()
    {
        ArrayList<Integer> generated = new ArrayList<Integer>();
        while (deck.size() > shuffled.size()) {
            int num;
            do num = (int)(Math.random() * deck.size());
            while (generated.indexOf(num) > -1);
            generated.add(num);
            shuffled.push(deck.get(num));
        }
    }
   
    public PlayingCard getCard()
    {
        return shuffled.pop();
    }
}
