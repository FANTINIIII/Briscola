public class Card {

    private String name;
    private int value;
    private int suit;
    private int points;

    Card(String n, int v, int s, int p)
    {
        this.name = n;
        this.value = v;
        this.suit = s;
        this.points = p;
    }
    
    String getName()
    {
        return this.name;
    }

    int getValue()
    {
        return this.value;
    }

    int getSuit()
    {
        return this.suit;
    }

    int getPoints()
    {
        return this.points;
    }

    void print()
    {
        System.out.print(this.name + "\t");
        System.out.print(this.value + " ");
        System.out.print(this.suit + " ");
        System.out.print(this.points + "\n");
    }
}
