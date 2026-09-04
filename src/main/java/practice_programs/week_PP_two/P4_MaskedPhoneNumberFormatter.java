public class P4_MaskedPhoneNumberFormatter {
    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        for (char c : phone.toCharArray()) {
            if (!Character.isDigit(c)) {
                return "Invalid phone number";
            }
        }

        StringBuilder masked = new StringBuilder("XXXXXX");
        masked.append("-");
        masked.append(phone.substring(6));

        return masked.toString();
    }

    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210"));
        System.out.println(maskPhoneNumber("98765"));
        System.out.println(maskPhoneNumber("1234567890"));
    }
}