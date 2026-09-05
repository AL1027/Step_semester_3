package string.assigment_problems;

/**
 * Problem 3: Product Inventory CSV Parser
 *
 * Splits inventory update CSV lines into fields, validates field count,
 * and prints formatted product records.
 */
public class InventoryCsvParser {

    /**
     * Parses a CSV record representing product inventory.
     *
     * @param csvLine CSV formatted line ("ProductName,SKU,Quantity")
     */
    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String quantity = fields[2].trim();

        System.out.println("Product: " + productName + " | SKU: " + sku + " | Qty: " + quantity);
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        parseInventoryRecord("Wireless Mouse,WM-2201,150");

        System.out.println("\n--- Test Case 2 ---");
        parseInventoryRecord("Wireless Mouse,150");
    }
}
