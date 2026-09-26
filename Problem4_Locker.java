public class Problem4_Locker {

    static class Locker {
        private final int lockerNumber;
        private String combination;

        public Locker(int lockerNumber, String combination) {
            this.lockerNumber = lockerNumber;
            this.combination = combination;
        }

        public boolean changeCode(String currentCode, String newCode) {
            if (combination.equals(currentCode)) {
                combination = newCode;
                return true;
            }
            return false;
        }

        public int getLockerNumber() {
            return lockerNumber;
        }
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        System.out.println("Change with correct code: " + l.changeCode("1234", "5678"));
        System.out.println("Change with wrong code: " + l.changeCode("0000", "9999"));
    }
}