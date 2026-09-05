package string.assigment_problems;

/**
 * Problem 1: ATM PIN Length Validator
 *
 * Checks whether a customer's PIN string is exactly 4 characters long using length()
 * and conditional logic.
 */
public class AtmPinValidator {

    /**
     * Checks if the PIN string has exactly 4 digits.
     *
     * @param pin the PIN string to validate
     */
    public static void checkPinLength(String pin) {
        if (pin != null && pin.length() == 4) {
            System.out.println("PIN length OK.");
        } else {
            System.out.println("Invalid PIN - must be exactly 4 digits.");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        checkPinLength("482");

        System.out.println("\n--- Test Case 2 ---");
        checkPinLength("4820");
    }
}
