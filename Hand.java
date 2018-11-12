import java.util.ArrayList;
import java.util.Random;
/**
 * This program is used to create hands for the dealer and player.
 * Date modified: 1 November 2018
 * @author Akash Kumar
 * @version 1.0
 */
public class Hand
{
  public static void main(String[] args)
  {
    Deck d1 = new Deck();
    d1.shuffle(); // shuffle the deck.
    Random rand = new Random();
    // generate a random number between 16-21. This number determines the ceiling.
    int ceiling = rand.nextInt(6) + 16;
    ArrayList<String> dealerHand = new ArrayList<String>();
    ArrayList<String> playerHand = new ArrayList<String>();
    int dealerTotal = 0, playerTotal = 0;
    // play continues until either the dealerTotal or playerTotal exceeds the ceiling.
    while(dealerTotal <= ceiling && playerTotal <= ceiling)
    {
      dealerTotal += addCard(d1, dealerTotal, dealerHand);
      playerTotal += addCard(d1, dealerTotal, playerHand);
    }

    // sort the dealer's and player's hands.
    String[] sortedDealerHand = new String[dealerHand.size()];
    sortedDealerHand = sortCards(dealerHand.toArray(sortedDealerHand));
    String[] sortedPlayerHand = new String[playerHand.size()];
    sortedPlayerHand = sortCards(playerHand.toArray(sortedPlayerHand));

    // output results.
    // print the random number ceiling.
    System.out.println("Random number ceiling between 16-21: " + ceiling + "\n");
    // print the sorted dealer's hand.
    System.out.print("Dealer's hand: ");
    for(int i = 0; i < sortedDealerHand.length; i++)
    {
      if(i < (sortedDealerHand.length-1))
        System.out.print(sortedDealerHand[i].substring(2,sortedDealerHand[i].length()-1) + ", ");
      else
        System.out.print(sortedDealerHand[i].substring(2,sortedDealerHand[i].length()-1));
    }
    System.out.println();
    System.out.println("Dealer's hand total is " + dealerTotal + ".");
    System.out.println();
    // print the sorted player's hand.
    System.out.print("Player's hand: ");
    for(int i = 0; i < sortedPlayerHand.length; i++)
    {
      if(i < (sortedPlayerHand.length-1))
        System.out.print(sortedPlayerHand[i].substring(2,sortedPlayerHand[i].length()-1) + ", ");
      else
        System.out.print(sortedPlayerHand[i].substring(2,sortedPlayerHand[i].length()-1));
    }
    System.out.println();
    System.out.println("Player's hand total is " + playerTotal + ".");
    System.out.println();
  } // end main.

  /* the addCard method adds a card element to the hand ArrayList and adds the
     card's value to the total.
   */
  public static int addCard(Deck d, int handTotal, ArrayList<String> hand)
  {
    String card = d.drawCard(0); // draw a card.
    hand.add(card);                 // add the card to the hand.
    int trueValue = Integer.parseInt(card.substring(0,2).trim());
    // if the card is a face card, its value is 10, else the card's value is its numerical value.
    int gameValue = (trueValue > 10) ? 10 : trueValue;
    /* if the card is an ace, its value is 11 unless it puts
       the total value of the hand over 21.
     */
    if(gameValue == 1 && (handTotal+11 <= 21))
    {
      gameValue = 11;
    }

    return gameValue;
  } // end AddCard method.

  /* The sortCards method is used to sort an array of cards.
   * Sorting is done first by color, then by rank. Ace is always lowest.
   */
  public static String[] sortCards(String[] cards)
  {
    ArrayList<String> reds = new ArrayList<String>();
    ArrayList<String> blacks = new ArrayList<String>();
    // sort the cards based on color.
    for(String i: cards)
    {
      if(i.charAt(i.length()-1) == 'H' || i.charAt(i.length()-1) == 'D') { reds.add(i); }
      else if(i.charAt(i.length()-1) == 'S' || i.charAt(i.length()-1) == 'C') { blacks.add(i); }
    }

    // sort the red cards based on the numerical value.
    boolean swap = true;
    int first, second;
    while(swap)
    {
      swap = false;
      for(int i = 0; i < reds.size()-1; i++)
      {
        first = Integer.parseInt(reds.get(i).substring(0,2).trim());
        second = Integer.parseInt(reds.get(i+1).substring(0,2).trim());
        // if value of first card is greater than the second card,
        // place the first card after the second card.
        if(first > second)
        {
          reds.add((i+1), reds.remove(i));
          swap = true;
        }
      }
    }
    // sort the black cards based on the numerical value.
    swap = true;
    while(swap)
    {
      swap = false;
      for(int i = 0; i < blacks.size()-1; i++)
      {
        first = Integer.parseInt(blacks.get(i).substring(0,2).trim());
        second = Integer.parseInt(blacks.get(i+1).substring(0,2).trim());
        // if value of first card is greater than the second card,
        // place the first card after the second card.
        if(first > second)
        {
          blacks.add((i+1), blacks.remove(i));
          swap = true;
        }
      }
    }

    String[] sortedCards = new String[cards.length]; // to group the sorted cards.
    int m = 0; // index of sortedCards.
    // move the sorted red cards to the sortedCards array.
    for(String redCard: reds)
    {
      sortedCards[m++] = redCard;
    }
    // move the sorted black cards to the sortedCards array.
    for(String blackCard: blacks)
    {
      sortedCards[m++] = blackCard;
    }

    return sortedCards;
  } // end sortCards method.
}
