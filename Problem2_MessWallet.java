public class Problem2_MessWallet {

    static class MessWallet {
        private double balance;

        public MessWallet(double openingBalance) {
            if (openingBalance < 0) {
                System.out.println("Warning: Negative opening balance provided. Starting at 0.");
                this.balance = 0;
            } else {
                this.balance = openingBalance;
            }
        }

        public void topUp(double amount) {
            if (amount <= 0) {
                System.out.println("Top-up rejected: amount must be positive");
                return;
            }
            balance += amount;
            System.out.printf("Balance after top-up: %.1f%n", balance);
        }

        public void deduct(double amount) {
            if (amount > balance) {
                System.out.println("Deduct rejected: insufficient balance");
                return;
            }
            balance -= amount;
        }

        public double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.printf("Final balance: %.1f%n", wallet.getBalance());
    }
}