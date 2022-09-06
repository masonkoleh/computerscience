public class Cards
{
    public static void main(String[] args)
    {
        Deck deck = new Deck();
        deck.shuffle();
        for (int x = 0; x < 5; x++)
            System.out.println(deck.getCard());
    }
}
