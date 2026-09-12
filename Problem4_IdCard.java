public class Problem4_IdCard {

    static class IdCard {
        String name;
        int booksIssued;

        public IdCard(String name, int booksIssued) {
            this.name = name;
            this.booksIssued = booksIssued;
        }
    }

    public static void main(String[] args) {
        IdCard ravi = new IdCard("Ravi", 0);
        IdCard duplicate = ravi;
        duplicate.booksIssued = 3;
        IdCard separate = new IdCard("Ravi", 3);

        System.out.printf("Ravi's booksIssued (via first variable): %d%n", ravi.booksIssued);
        System.out.printf("duplicate == ravi: %b%n", duplicate == ravi);
        System.out.printf("separate == ravi: %b%n", separate == ravi);
    }
}