import java.util.Scanner;

public class Briscola
{
    static Deck deck = new Deck();
    static Card briscola = deck.getCard(39);
    
    public static void main(String args[])
    {
        deck.shuffle();
        Player player1 = new Player(new Hand(deck.getCard(0), deck.getCard(1), deck.getCard(2)), "", briscola);
        Player player2 = new Player(new Hand(deck.getCard(3), deck.getCard(4), deck.getCard(5)), "", briscola);

        int winner = 1;

        while (deck.index < 46)
        {
            if (winner == 1) winner = turn(player1, player2);
            else if (winner == 2) winner = turn(player2, player1);
        }
        end(player1, player2);
    }

    static int turn(Player player1, Player player2)
    {
        Card card1 = player1.chooseCard(null, null);
        pause();
        Card card2 = player2.chooseCard(player1.getName(), card1);
        pause();

        System.out.print("\033[H\033[2J");
        int winner = evaluate(card1, card2);
        
        System.out.print("\033[H\033[2J");
        System.out.println("The briscola card is " + briscola.getName());
        System.out.println(player1.getName() + " played " + card1.getName());
        System.out.println(player2.getName() + " played " + card2.getName());

        if (winner == 1) 
        {
            System.out.println(player1.getName() + " wins");
            player1.nextCard(deck);
            player2.nextCard(deck);
            player1.addPoints(card1.getPoints() + card2.getPoints());
        }
        else if (winner == 2)
        {
            System.out.println(player2.getName() + " wins");
            player2.nextCard(deck);
            player1.nextCard(deck);
            player2.addPoints(card2.getPoints() + card1.getPoints());
        }
        pause();
        return winner;
    }

    static void end(Player p1, Player p2)
    {
        System.out.println(p1.getName() + " has " + p1.getPoints() + " points");
        System.out.println(p2.getName() + " has " + p2.getPoints() + " points\n");
        if (p1.getPoints() > p2.getPoints()) System.out.println(p1.getName() + " won the game!");
        else if (p2.getPoints() > p1.getPoints()) System.out.println(p2.getName() + " won the game!");
        else System.out.println("This is a draw!");
    }

    public static int evaluate(Card c1, Card c2)
    {
        if (c1.getSuit() == c2.getSuit())
        {
            if (c1.getValue() > c2.getValue()) return 1;
            else return 2;
        }
        else if (c1.getSuit() == briscola.getSuit()) return 1;
        else if (c2.getSuit() == briscola.getSuit()) return 2;
        else return 1;
    }

    static void pause()
    {
        Scanner p = new Scanner(System.in);
        System.out.print("\nPress any key to continue: ");
        p.nextLine();
    }
}
