public class Problem3_PasswordChecker {

    static class PasswordChecker {
        private final String password;

        public PasswordChecker(String password) {
            this.password = password;
        }

        public String getStrength() {
            int length = password.length();
            if (length < 6) {
                return "Weak";
            } else if (length < 10) {
                return "Medium";
            } else {
                return "Strong";
            }
        }
    }

    public static void main(String[] args) {
        PasswordChecker pc = new PasswordChecker("abcd");
        System.out.println("Strength (abcd): " + pc.getStrength());
        PasswordChecker pc2 = new PasswordChecker("abcdefghij");
        System.out.println("Strength (abcdefghij): " + pc2.getStrength());
    }
}