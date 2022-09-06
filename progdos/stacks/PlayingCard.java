public class PlayingCard
{
    String value, suit;
    public PlayingCard(String value, String suit)
    {
        this.value = value;
        this.suit = suit;
    }
    
    public String getValue()
    {   return value;   }
    public String getSuit()
    {   return suit;    }
    public String toString()
    {    return value + " of " + suit;   }
}