public class P5_BankTransactionValidator {
    public static String normalizeReference(String raw) {
        if (raw == null) return "";
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed.toUpperCase();
        String bankCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return bankCode + rest;
    }

    public static String validateAndFormat(String reference) {
        String normalized = normalizeReference(reference);

        if (normalized.length() != 14) {
            return "Invalid: wrong length (expected 14, got " + normalized.length() + ")";
        }

        String bankCode = normalized.substring(0, 3);
        String body = normalized.substring(3);

        for (char c : bankCode.toCharArray()) {
            if (!Character.isLetter(c)) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (char c : body.toCharArray()) {
            if (!Character.isDigit(c)) {
                return "Invalid: body must be 11 digits";
            }
        }

        String datePart = body.substring(0, 6);
        String seqPart = body.substring(6);

        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(bankCode).append("] ");
        formatted.append("DATE: ").append(datePart.substring(0, 2)).append("/")
                 .append(datePart.substring(2, 4)).append("/")
                 .append(datePart.substring(4, 6)).append(" | ");
        formatted.append("SEQ: ").append(seqPart);

        return formatted.toString();
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat(" hdf03022600042 "));
        System.out.println(validateAndFormat("12F03022600042"));
        System.out.println(validateAndFormat(" abc12345678901 "));
    }
}