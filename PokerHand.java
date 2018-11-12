import java.util.ArrayList;
import java.util.Scanner;
/**
 * This program is used to simulate poker hands.
 * Date modified: 1 November 2018
 * @author Akash Kumar
 * @version 1.0
 */
public class PokerHand
{
  public static void main(String[] args)
  {
    Scanner kb = new Scanner(System.in);
    System.out.print("Enter the number of poker hands needed: ");
    int n = kb.nextInt();          // number of poker hands we need to make. Max = 10.
    while(n < 1 || n > 10)
    {
      System.out.print("Number of poker hands must be within 1-10: ");
      n = kb.nextInt();
    }
    int totalHands = n;            // total number of poker hands. Max = 10.
    System.out.println();          // blank line.

    // create  a Deck object.
    Deck pokerDeck = new Deck();
    pokerDeck.shuffle();           // shuffle the deck.
    int NumOfCards = 52;
    String[] hand = new String[5]; // hand of 5 cards.
    // generate poker hands from the Deck object.
    while(n > 0)
    {
      for(int i = 0; i < hand.length; i++)
      {
        // draw cards from the deck and add to your hand.
        hand[i] = pokerDeck.drawCard(0);
      }

      String[] sortedHand = sortCards(hand); // arrange the cards in the hand.
      // display the sorted hand.
      System.out.print("Hand "+ (totalHands-n+1) + ": ");
      for(int i = 0; i < sortedHand.length; i++)
      {
        if(i < (sortedHand.length-1))
          System.out.print(sortedHand[i].substring(2,sortedHand[i].length()-1) + ", ");
        else
          System.out.print(sortedHand[i].substring(2,sortedHand[i].length()-1));
      }
      System.out.println(); // Move cursor to next line.
      System.out.println(); // blank line.

      n--;                  // one less hand needed to make.
    }

    // replace all used cards back into the poker deck.
    pokerDeck.replaceAll();
  } // end main.

  /* The sortCards method is used to sort an array of cards.
   * Sorting is done first by suit, then by rank. Ace is always lowest.
   * Order is: Spades, Hearts, Clubs, Diamonds
   */
  public static String[] sortCards(String[] cards)
  {
    ArrayList<String> spades = new ArrayList<String>();
    ArrayList<String> clubs = new ArrayList<String>();
    ArrayList<String> hearts = new ArrayList<String>();
    ArrayList<String> diamonds = new ArrayList<String>();
    // sort the cards based on color.
    for(String i: cards)
    {
      if(i.charAt(i.length()-1) == 'S') { spades.add(i); }
      else if(i.charAt(i.length()-1) == 'H') { hearts.add(i); }
      else if(i.charAt(i.length()-1) == 'C') { clubs.add(i); }
      else if(i.charAt(i.length()-1) == 'D') { diamonds.add(i); }
    }

    // sort the spades based on the numerical value.
    boolean swap = true;
    int first, second;
    while(swap)
    {
      swap = false;
      for(int i = 0; i < spades.size()-1; i++)
      {
        first = Integer.parseInt(spades.get(i).substring(0,2).trim());
        second = Integer.parseInt(spades.get(i+1).substring(0,2).trim());
        // if value of first card is greater than the second card,
        // place the first card after the second card.
        if(first > second)
        {
          spades.add((i+1), spades.remove(i));
          swap = true;
        }
      }
    }
    // sort the hearts based on the numerical value.
    swap = true;
    while(swap)
    {
      swap = false;
      for(int i = 0; i < hearts.size()-1; i++)
      {
        first = Integer.parseInt(hearts.get(i).substring(0,2).trim());
        second = Integer.parseInt(hearts.get(i+1).substring(0,2).trim());
        // if value of first card is greater than the second card,
        // place the first card after the second card.
        if(first > second)
        {
          hearts.add((i+1), hearts.remove(i));
          swap = true;
        }
      }
    }
    // sort the clubs based on the numerical value.
    swap = true;
    while(swap)
    {
      swap = false;
      for(int i = 0; i < clubs.size()-1; i++)
      {
        first = Integer.parseInt(clubs.get(i).substring(0,2).trim());
        second = Integer.parseInt(clubs.get(i+1).substring(0,2).trim());
        // if value of first card is greater than the second card,
        // place the first card after the second card.
        if(first > second)
        {
          clubs.add((i+1), clubs.remove(i));
          swap = true;
        }
      }
    }
    // sort the diamonds based on the numerical value.
    swap = true;
    while(swap)
    {
      swap = false;
      for(int i = 0; i < diamonds.size()-1; i++)
      {
        first = Integer.parseInt(diamonds.get(i).substring(0,2).trim());
        second = Integer.parseInt(diamonds.get(i+1).substring(0,2).trim());
        // if value of first card is greater than the second card,
        // place the first card after the second card.
        if(first > second)
        {
          diamonds.add((i+1), diamonds.remove(i));
          swap = true;
        }
      }
    }

    String[] sortedCards = new String[cards.length]; // to group the sorted cards.
    int m = 0; // index of sortedCards.
    // move the sorted spades to the sortedCards array.
    for(String spade: spades)
    {
      sortedCards[m++] = spade;
    }
    // move the sorted hearts to the sortedCards array.
    for(String heart: hearts)
    {
      sortedCards[m++] = heart;
    }
    // move the sorted clubs to the sortedCards array.
    for(String club: clubs)
    {
      sortedCards[m++] = club;
    }
    // move the sorted diamonds to the sortedCards array.
    for(String diamond: diamonds)
    {
      sortedCards[m++] = diamond;
    }

    return sortedCards;
  } // end sortCards method.
}
