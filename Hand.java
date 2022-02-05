import java.util.ArrayList;

public class Hand {
    
    private ArrayList<Card> cards = new ArrayList<Card>();

    Hand(Card c1, Card c2, Card c3)
    {
        this.cards.add(c1);
        this.cards.add(c2);
        this.cards.add(c3);
    }

    public ArrayList<Card> getCards()
    {
        return this.cards;
    }

    public Card getCard(int i)
    {
        return this.cards.get(i);
    }

    public void add(Card c)
    {
        this.cards.add(c);
    }

    public void remove(int i)
    {
        this.cards.remove(i);
    }
}
