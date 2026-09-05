package arrays.assigment_problems;

/**
 * Problem 4: The Warehouse Inventory Balancer
 *
 * Compares total quantities across two warehouse sections and identifies the single
 * highest-quantity item across both sections.
 */
public class InventoryBalancer {

    /**
     * Compares section totals and finds the highest quantity item.
     *
     * @param sectionA item quantities in Section A
     * @param sectionB item quantities in Section B
     */
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null || sectionA.length != sectionB.length || sectionA.length == 0) {
            System.out.println("Invalid inventory data");
            return;
        }

        int totalA = 0;
        int totalB = 0;
        int maxQty = Integer.MIN_VALUE;
        String maxSection = "Section A";
        int maxItemIndex = 1; // 1-based index (e.g., Item 3)

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > maxQty) {
                maxQty = sectionA[i];
                maxSection = "Section A";
                maxItemIndex = i + 1;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > maxQty) {
                maxQty = sectionB[i];
                maxSection = "Section B";
                maxItemIndex = i + 1;
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.println("Section A Total: " + totalA + 
                           " | Section B Total: " + totalB + 
                           " | Status: " + status + 
                           " | Highest Quantity: " + maxQty + 
                           " (" + maxSection + ", Item " + maxItemIndex + ")");
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};
        analyzeInventory(sectionA, sectionB);

        System.out.println("\n--- Test Case 2 (Unbalanced) ---");
        int[] sectionA2 = {10, 20, 30};
        int[] sectionB2 = {15, 20, 40};
        analyzeInventory(sectionA2, sectionB2);
    }
}
