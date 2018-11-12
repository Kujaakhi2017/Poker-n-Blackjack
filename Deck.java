import java.util.*; // for ArrayList and Collections
/**
 * The Deck class is used to simulate a deck and keep track
 * of which cards are drawn. Shuffling and sorting are also done
 * in this class.
 * Date modified: 1 November 2018
 * @author Akash Kumar
 * @version 1.0
 */
public class Deck
{
  private final int NumOfCards = 52; // total number of cards in a standard deck.
  private final String[] suits = {"SpadesS", "HeartsH", "ClubsC", "DiamondsD"},
                         ranks = {"1 Ace", "2 2", "3 3", "4 4", "5 5", "6 6", "7 7",
                                  "8 8", "9 9", "1010", "11Jack", "12Queen", "13King"};
  private ArrayList<String> cards = new ArrayList<String>(NumOfCards);
  private ArrayList<String> drawnCards = new ArrayList<String>();

  /**
   * The Deck constructor is used to initialize the cards ArrayList
   * with 52 cards.
   */
  public Deck()
  {
    // initilize cards ArrayList.
    for(String suit: suits)
    {
      for(String rank: ranks)
      {
        cards.add(rank + " of " + suit);
      }
    }
  }

  /**
   * The drawCard method takes a card from cards ArrayList
   * and puts it into the drawnCards ArrayList.
   * @param i index of the card in cards ArrayList.
   * @return the drawn card.
   */
  public String drawCard(int i)
  {
    drawnCards.add(cards.get(i));

    return cards.remove(i);
  }

  /**
   * The replaceAll method is used to replace all drawn cards
   * back into the cards ArrayList.
   */
  public void replaceAll()
  {
    for(int i = 0; i < drawnCards.size(); i++)
    {
      cards.add(drawnCards.remove(i));
    }
  }

  /**
   * The shuffle method is used to shuffle the cards in the Deck.
   */
  public void shuffle()
  {
    Collections.shuffle(cards);
  }
}
