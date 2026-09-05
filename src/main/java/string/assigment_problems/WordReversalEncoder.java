public class WordReversalEncoder {
    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String reversed = new StringBuilder(words[i]).reverse().toString();
            if (i > 0) result.append(" ");
            result.append(reversed);
        }
        return result.toString();
    }
}
