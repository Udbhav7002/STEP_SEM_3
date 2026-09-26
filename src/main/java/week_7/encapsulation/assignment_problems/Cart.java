package week_7.encapsulation.assignment_problems;

public class Cart {
    private final String cartId;
    private final int maxItems;
    private final int[] prices;
    private int count;

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.maxItems = maxItems;
        this.prices = new int[maxItems];
        this.count = 0;
    }

    public void addItem(int price) {
        if (count < maxItems && price > 0) {
            prices[count] = price;
            count++;
        }
    }

    public int getTotal() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return count;
    }

    public String getCartId() {
        return cartId;
    }
}