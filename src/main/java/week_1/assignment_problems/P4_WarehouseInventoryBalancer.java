package week_1.assignment_problems;

public class P4_WarehouseInventoryBalancer {
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int sumA = 0, sumB = 0;
        
        for (int qty : sectionA) sumA += qty;
        for (int qty : sectionB) sumB += qty;

        String status = (sumA == sumB) ? "Balanced" : "Not Balanced";

        int maxQty = Integer.MIN_VALUE;
        String maxSection = "";
        int maxIndex = -1;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > maxQty) {
                maxQty = sectionA[i];
                maxSection = "Section A";
                maxIndex = i + 1;
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > maxQty) {
                maxQty = sectionB[i];
                maxSection = "Section B";
                maxIndex = i + 1;
            }
        }

        System.out.println("Section A Total: " + sumA + " | Section B Total: " + sumB + 
            " | Status: " + status + " | Highest Quantity: " + maxQty + 
            " (" + maxSection + ", Item " + maxIndex + ")");
    }

    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};
        analyzeInventory(sectionA, sectionB);
    }
}