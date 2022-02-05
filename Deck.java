public class Deck {
    
    public int index = 6;
    private Card[] cards = new Card[40];
    private String[] names = {
        "Ace of swords", "2 of swords", "3 of swords", "4 of swords", "5 of swords", "6 of swords", "7 of swords", "Jack of swords", "Horse of swords", "King of swords",
        "Ace of clubs", "2 of clubs", "3 of clubs", "4 of clubs", "5 of clubs", "6 of clubs", "7 of clubs", "Jack of clubs", "Horse of clubs", "King of clubs",
        "Ace of coins", "2 of coins", "3 of coins", "4 of coins", "5 of coins", "6 of coins", "7 of coins", "Jack of coins", "Horse of coins", "King of coins",
        "Ace of cups", "2 of cups", "3 of cups", "4 of cups", "5 of cups", "6 of cups", "7 of cups", "Jack of cups", "Horse of cups", "King of cups"
    };
    private int[] suits = {
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
        3, 3, 3, 3, 3, 3, 3, 3, 3, 3
    };
    private int[] values = {
        12, 2, 11, 4, 5, 6, 7, 8, 9, 10,
        12, 2, 11, 4, 5, 6, 7, 8, 9, 10,
        12, 2, 11, 4, 5, 6, 7, 8, 9, 10,
        12, 2, 11, 4, 5, 6, 7, 8, 9, 10
    };
    private int[] points = {
        11, 0, 10, 0, 0, 0, 0, 2, 3, 4,
        11, 0, 10, 0, 0, 0, 0, 2, 3, 4,
        11, 0, 10, 0, 0, 0, 0, 2, 3, 4,
        11, 0, 10, 0, 0, 0, 0, 2, 3, 4
    };

    Deck()
    {
        for (int i = 0; i < 40; i++)
        {
            this.cards[i] = new Card(this.names[i], this.values[i], this.suits[i], this.points[i]);
        }
    }

    public void shuffle()
    {
        //selects a random card and puts it at the end
        int n = (int)(Math.random() * 40);
        swap(names, n, 39);
        swap(suits, n, 39);
        swap(points, n, 39);
        swap(values, n, 39);
        this.cards[39] = new Card(names[39], values[39] + 11, suits[39], points[39]);

        //shuffles and creates a new shuffled deck
        for (int i = 0; i < names.length - 1; i++)
        {
            int j = (int)(Math.random() * (39 - i) + i);
            if (suits[j] == suits[39])
                values[j] += 11;
            swap(names, i, j);
            swap(suits, i, j);
            swap(points, i, j);
            swap(values, i, j);
            this.cards[i] = new Card(names[i], values[i], suits[i], points[i]);
        }
    }

    public Card getCard(int i)
    {
        return this.cards[i];
    }

    private void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void swap(String[] a, int i, int j)
    {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
