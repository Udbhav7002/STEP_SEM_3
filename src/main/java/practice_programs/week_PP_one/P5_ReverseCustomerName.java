public class P5_ReverseCustomerName {
    public static String reverseCustomerName(String customerName) {
        StringBuilder reversed = new StringBuilder();
        for (int i = customerName.length() - 1; i >= 0; i--) {
            reversed.append(customerName.charAt(i));
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        String[] names = {"Sunil", "Ananya", "Rahul", "Priya"};

        for (String name : names) {
            String reversed = reverseCustomerName(name);
            System.out.println("Original Name: " + name);
            System.out.println("Reversed Name: " + reversed);
            System.out.println();
        }
    }
}