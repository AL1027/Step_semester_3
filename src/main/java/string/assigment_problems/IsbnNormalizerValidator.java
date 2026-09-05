package string.assigment_problems;

/**
 * Problem 4: Library ISBN Normalizer & Validator
 *
 * Normalizes raw book-intake codes (trims spaces, uppercases 3-letter publisher code),
 * validates structural constraints (3 letters + 4-digit year + 6-digit catalog) without regex,
 * and formats the display string.
 */
public class IsbnNormalizerValidator {

    /**
     * Trims spaces and uppercases the first 3 characters using substring() and concatenation.
     *
     * @param raw raw scanned code string
     * @return normalized code string
     */
    public static String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    /**
     * Validates normalized code and constructs formatted display line using StringBuilder.
     *
     * @param code normalized 13-character code
     * @return formatted record or specific invalid reason
     */
    public static String validateAndFormat(String code) {
        if (code == null || code.length() != 13) {
            String msg = "Invalid: wrong length (must be exactly 13 characters)";
            System.out.println(msg);
            return msg;
        }

        // Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                String msg = "Invalid: publisher code must be 3 letters";
                System.out.println(msg);
                return msg;
            }
        }

        // Validate remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                String msg = "Invalid: body must be 10 digits";
                System.out.println(msg);
                return msg;
            }
        }

        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] YEAR: ").append(year).append(" | CATALOG: ").append(catalog);
        String result = sb.toString();
        System.out.println(result);
        return result;
    }

    /**
     * Convenience method to normalize and validate in a single step.
     *
     * @param raw raw scanned code string
     * @return formatted record or invalid message
     */
    public static String process(String raw) {
        String normalized = normalizeCode(raw);
        return validateAndFormat(normalized);
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        process(" pen2026004251 ");

        System.out.println("\n--- Test Case 2 ---");
        process("12N2026004251");
    }
}
