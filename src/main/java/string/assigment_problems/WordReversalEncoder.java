package string.assigment_problems;

/**
 * Problem 2: Word Reversal Encoder
 *
 * Reverses every word in a sentence individually while preserving word order.
 */
public class WordReversalEncoder {

    /**
     * Reverses each individual word in the sentence.
     *
     * @param sentence the input sentence with words separated by single spaces
     * @return the sentence with each word reversed
     */
    public static String reverseEachWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder reversedWord = new StringBuilder();
            // Build reverse using a loop and StringBuilder as required
            for (int j = word.length() - 1; j >= 0; j--) {
                reversedWord.append(word.charAt(j));
            }
            result.append(reversedWord);
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        String finalResult = result.toString();
        System.out.println(finalResult);
        return finalResult;
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        reverseEachWord("hello club");
    }
}
