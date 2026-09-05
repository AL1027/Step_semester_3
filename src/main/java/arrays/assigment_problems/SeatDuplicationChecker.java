package arrays.assigment_problems;

/**
 * Problem 1: The Exam Hall Seat Duplication Checker
 *
 * Scans the full list of assigned seat numbers to flag any duplicates before an exam starts.
 * Uses nested loops and arrays only (no Collections class).
 */
public class SeatDuplicationChecker {

    /**
     * Checks for duplicate seat numbers using nested loops without Collections.
     *
     * @param seatNumbers array of seat numbers assigned to students
     */
    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length <= 1) {
            System.out.println("No Duplicate Seats Found");
            return;
        }

        boolean foundDuplicate = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            // Check if seatNumbers[i] has already been checked and reported earlier
            boolean alreadyReported = false;
            for (int k = 0; k < i; k++) {
                if (seatNumbers[k] == seatNumbers[i]) {
                    alreadyReported = true;
                    break;
                }
            }
            if (alreadyReported) {
                continue;
            }

            // Check against remaining elements
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    foundDuplicate = true;
                    break;
                }
            }
        }

        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        int[] seats1 = {101, 102, 103, 102, 105};
        checkDuplicateSeats(seats1);

        System.out.println("\n--- Test Case 2 ---");
        int[] seats2 = {101, 102, 103, 104, 105};
        checkDuplicateSeats(seats2);
    }
}
