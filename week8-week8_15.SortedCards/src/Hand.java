
import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand> {

    private ArrayList<Card> hand;

    public Hand() {
        this.hand = new ArrayList<Card>();
    }

    public void add(Card card) {
        this.hand.add(card);
    }

    public void print() {
        for (Card card : hand) {
            System.out.println(card);
        }
    }

    public void sort() {
        Collections.sort(hand);
        this.print();
    }

    public int compareTo(Hand hand) {
        int thisHand = 0;
        int otherHand = 0;
        for (Card thisH : this.hand) {
            thisHand += thisH.getValue();
        }
        for (Card otherH : hand.hand) {
            otherHand += otherH.getValue();
        }
        return thisHand-otherHand;
    }
    
    public void sortAgainstSuit(){
        Collections.sort(hand, new SortAgainstSuitAndValue());
    }
}
