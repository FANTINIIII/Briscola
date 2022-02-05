import java.util.Scanner;

public class Player {
    
    private Hand hand;
    private String name;
    private Scanner scan;
    private Card briscola;
    private int points;
    private int index;

    Player(Hand h, String n, Card b)
    {
        this.scan = new Scanner(System.in);
        this.hand = h;
        this.briscola = b;
        if (n.equals("")) this.askName();
        else this.name = n;
        this.points = 0;
    }

    public int getPoints()
    {
        return this.points;
    }

    public void addPoints(int i)
    {
        this.points += i;
    }

    public Hand getHand()
    {
        return this.hand;
    }

    public String getName()
    {
        return this.name;
    }

    public void askName()
    {
        System.out.print("\033[H\033[2J");
        System.out.print("Enter your name: ");
        this.name = this.scan.next();
    }

    public void print()
    {
        System.out.print("\033[H\033[2J");
        System.out.println(this.name + " - " + this.points);
        for (int i = 0; i < this.hand.getCards().size(); i++)
        {
            System.out.println((i + 1) +". " + this.hand.getCard(i).getName());
        }
        System.out.println("\nThe briscola card is " + briscola.getName());
    }

    public Card chooseCard(String n, Card c)
    {
        this.print();
        this.index = -1;
        if (n != null) System.out.println("\n" + n + " played the " + c.getName());
        System.out.print("\nWhich card do you wanna choose? (Type the number): ");
        do {
            this.index = this.scan.nextInt();
        } while (this.index < 1 || this.index > this.hand.getCards().size());
        System.out.println(this.getHand().getCard(this.index - 1).getName());
        return this.getHand().getCard(this.index - 1);
    }

    public void nextCard(Deck d)
    {
        this.hand.remove(this.index - 1);
        if (d.index < 40) this.hand.add(d.getCard(d.index));
        d.index++;
    }
}
