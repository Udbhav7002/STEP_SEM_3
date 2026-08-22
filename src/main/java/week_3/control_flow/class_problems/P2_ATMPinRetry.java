public class P2_ATMPinRetry {
    public static void atmPinRetry(String correctPin, String[] attempts) {
        int attemptCounter = 0;
        boolean success = false;

        while (attemptCounter < attempts.length && attemptCounter < 3 && !success) {
            if (attempts[attemptCounter].equals(correctPin)) {
                success = true;
                System.out.println("PIN accepted");
                break;
            }
            attemptCounter++;
        }

        if (!success) {
            System.out.println("Card blocked — too many incorrect attempts");
        }
    }

    public static void main(String[] args) {
        atmPinRetry("4821", new String[]{"1111", "4821"});
        System.out.println();
        atmPinRetry("4821", new String[]{"1111", "2222", "3333"});
    }
}