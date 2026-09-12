public class Problem4_HallTicket {

    static class HallTicket {
        String studentName;
        int seatNumber;

        public HallTicket(String studentName, int seatNumber) {
            this.studentName = studentName;
            this.seatNumber = seatNumber;
        }
    }

    public static void main(String[] args) {
        HallTicket priya = new HallTicket("Priya", 0);
        HallTicket copy = priya;
        copy.seatNumber = 45;
        HallTicket separate = new HallTicket("Priya", 45);

        System.out.printf("Priya's seatNumber (via first variable): %d%n", priya.seatNumber);
        System.out.printf("copy == priya: %b%n", copy == priya);
        System.out.printf("separate == priya: %b%n", separate == priya);
    }
}