import java.util.ArrayList;

public class CardStack {
    private final ArrayList<Card> stack;

    public CardStack() {
        stack = new ArrayList<>();
    }

    public void push(Card card) {
        stack.add(card);
    }

    public Card pop() {
        if (isEmpty()) return null;
        return stack.remove(stack.size() - 1);
    }

    public Card peek() {
        if (isEmpty()) return null;
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public void clear() {
        stack.clear();
    }

    public ArrayList<Card> getCards() {
        return stack;
    }
}
