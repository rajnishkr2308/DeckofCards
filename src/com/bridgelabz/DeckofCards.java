package com.bridgelabz;
import java.util.Random;


/*
Write a Program DeckOfCards.java, to initialize deck of cards having suit("Clubs", "Diamonds", "Hearts", "Spades")
& Rank ("2", "3", "4", "5", "6", "7", "8","9", "10", "Jack", "Queen", "King", "Ace").Shuffle the cards using Random
method and then distribute 9 Cards to 4 Players and Print the Cards received by the 4 Players using 2D Array...
 */

    public class DeckofCards {
        // total 52 cards
        String[] deckCards = new String[52];
        String[] suit = {"Clubs", "Diamonds", "Hearts", "Spades" };
        String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
        //distribute 9 Cards to 4 Players
        String[][] playCards = new String[4][9];
        static Random random = new Random();
        /*
         * getting cards according to their rank and suits
         */
        public void alignCards() {
            // Initializing with 0;
            int deckIndex = 0;
            for (int i = 0; i < suit.length; i++) {
                for (int j = 0; j < rank.length; j++) {
                    // aligning ranks and suits together
                    deckCards[deckIndex] = rank[j] + " of " + suit[i];
                    deckIndex++;    // incrementing deck index
                }
            }
        }
        /*
         * shuffling of cards
         */
        public String[] shuffleCards() {
            int j = 0;
            String temp;
            for (int i = 0; i < deckCards.length; i++) {
                /*
                 * Shuffle the cards using Random method
                 * getting random numbers from 0 to 52
                 */
                j = random.nextInt(52);
                //swapping existing data with random data
                temp = deckCards[i];
                deckCards[i] = deckCards[j];
                deckCards[j] = temp;
            }
            return deckCards;
        }
        /*
         * displaying cards
         */
        public void displayCards(String[] deck) {
        /*
            Print the Cards received by 4 Players
         */
            int deckindex = 0;
            for (int i = 0; i < playCards.length; i++) {
                System.out.println("*** PLAYER-" + (i + 1)+" ***");
                for (int j = 0; j < playCards[i].length; j++) {
                    playCards[i][j] = deck[deckindex];
                    System.out.println(playCards[i][j]);
                    deckindex++;
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            //method calling
            DeckofCards player = new DeckofCards();
            player.alignCards();
            String[] deck = player.shuffleCards();
            player.displayCards(deck);
        }
    }

