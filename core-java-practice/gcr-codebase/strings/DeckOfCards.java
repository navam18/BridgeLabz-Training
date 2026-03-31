import java.util.*;
public class DeckOfCards {
    static String[] initializeDeck() {
        String[] suits={"Hearts","Diamonds","Clubs","Spades"};
        String[] ranks={"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};

        String[] deck=new String[suits.length*ranks.length];
        int ind=0;
        for(String s:suits){
            for(String r:ranks){
                deck[ind++]=r+ " of " +s;
            }
        }
        return deck;
    }
    static void shuffleDeck(String[] deck) {
        int n=deck.length;
        for(int i=0;i<n;i++){
            int r=i+(int)(Math.random() * (n - i));
            String temp = deck[i];
            deck[i]=deck[r];
            deck[r] = temp;
        }
    }
    static String[][] distributeCards(String[] deck, int players, int cards) {
        if (players * cards > deck.length) return null;

        String[][] result = new String[players][cards];
        int index = 0;

        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cards; j++) {
                result[i][j] = deck[index++];
            }
        }
        return result;
    }

    static void printPlayers(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player" + (i + 1));
            for (String card : players[i]) {
                System.out.println(card);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int p=sc.nextInt();
        System.out.print("Enter number of cards per player: ");
        int c=sc.nextInt();
        String[] dec=initializeDeck();
        shuffleDeck(dec);
        String[][] dis=distributeCards(dec,p,c);
        if(dis==null){
            System.out.println("Cannot distribute cards");
        } else {
            printPlayers(dis);
        }
    }

}
