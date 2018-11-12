import java.util.ArrayList;
import java.util.Random;
/**
 * This program is used to simulate BlackJack hands.
 * Date modified: 1 November 2018
 * @author Akash Kumar
 * @version 1.0
 */
public class BlackJackHand extends Hand
{
  public static void main(String[] args)
  {
    Deck d1 = new Deck();
    d1.shuffle(); // shuffle the deck.
    Random rand = new Random();
    // generate a random number between 16-21.
    int ceiling = rand.nextInt(6) + 16;
    ArrayList<String> dealerHand = new ArrayList<String>();
    ArrayList<String> playerHand = new ArrayList<String>();
    int dealerTotal = 0, playerTotal = 0;
    // play continues until either the dealerTotal or playerTotal exceeds the ceiling.
    while(dealerTotal <= ceiling && playerTotal <= ceiling)
    {
      dealerTotal += addCard(d1, dealerTotal, dealerHand); // addCard is inherited from Hand.
      playerTotal += addCard(d1, dealerTotal, playerHand);
    }

    // sort the dealer's and player's hands.
    // sortCards is inherited from Hand.
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
    // call BlackJack if only two cards are drawn and total value is 21.
    if((sortedDealerHand.length) == 2 && (dealerTotal == 21))
      System.out.println("Dealer's hand is a BlackJack!");
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
    // call BlackJack if only two cards are drawn and total value is 21.
    if((sortedPlayerHand.length) == 2 && (playerTotal == 21))
      System.out.println("Player's hand is a BlackJack!");
  } // end main.
}
