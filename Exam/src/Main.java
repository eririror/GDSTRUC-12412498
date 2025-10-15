import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        CardStack deck = new CardStack();
        CardStack hand = new CardStack();
        CardStack discardPile = new CardStack();

        // Adventure Time Card Wars cards
        String[] cardNames = {
                "Flame Princess", "Ice King", "Tree Trunks", "Lumpy Space Princess",
                "Finn the Human", "Jake the Dog", "Princess Bubblegum", "BMO",
                "Gunter", "Creepy Ghost", "Zombie Finn", "Skeleton Warrior",
                "Fire Elemental", "Water Elemental", "Dark Wizard", "Ancient Giant",
                "Flying Pig", "Magic Cat", "Taco Monster", "Robo-Dog",
                "Thunder Beast", "Mushroom Soldier", "Royal Knight", "Slime Beast",
                "Dragon Turtle", "Crystal Golem", "Ghost Pirate", "Wicked Wizard",
                "Stone Giant", "Time Wizard"
        };

        // Populate deck with 30 cards (names can repeat)
        for (int i = 0; i < 30; i++) {
            deck.push(new Card(cardNames[i]));
        }

        System.out.println("Adventure Time: Card Wars");

        while (!deck.isEmpty()) {
            int commandType = random.nextInt(3);
            int x = random.nextInt(5) + 1;

            switch (commandType) {
                case 0 -> { // Draw cards
                    System.out.println("\nCommand: Draw " + x + " card(s)");
                    for (int i = 0; i < x; i++) {
                        if (!deck.isEmpty()) hand.push(deck.pop());
                        else {
                            System.out.println("Deck is empty!");
                            break;
                        }
                    }
                }
                case 1 -> { // Discard cards
                    System.out.println("\nCommand: Discard " + x + " card(s)");
                    for (int i = 0; i < x; i++) {
                        if (!hand.isEmpty()) discardPile.push(hand.pop());
                        else {
                            System.out.println("Hand is empty, cannot discard.");
                            break;
                        }
                    }
                }
                case 2 -> { // Get cards from discard pile
                    System.out.println("\nCommand: Get " + x + " card(s) from discard pile");
                    for (int i = 0; i < x; i++) {
                        if (!discardPile.isEmpty()) hand.push(discardPile.pop());
                        else {
                            System.out.println("Discard pile is empty!");
                            break;
                        }
                    }
                }
            }

            // Display current hand
            System.out.println("\nYour current hand:");
            if (hand.isEmpty()) System.out.println("[Empty]");
            else {
                for (Card c : hand.getCards()) System.out.print(c + " | ");
                System.out.println();
            }

            System.out.println("Deck remaining: " + deck.size());
            System.out.println("Discard pile size: " + discardPile.size());

            if (deck.isEmpty()) {
                System.out.println("\nDeck is empty! Game Over");
                break;
            }

            System.out.print("\nPress Enter to continue...");
            scanner.nextLine();
        }

        System.out.println("\nThanks for playing Adventure Time: Card Wars!");
        scanner.close();
    }
}

