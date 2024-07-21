import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    private static void printMostFrequentWord(String[] words) {
        // write your code here
        Map<String, Integer> occurrence = new HashMap<>();

        for (String word: words) {
            if (occurrence.containsKey(word)) {
                occurrence.computeIfPresent(word, (k, v) -> ++v);
            } else {
                occurrence.put(word, 1);
            }
        }

        String mostFrequentWord = "";
        Integer occurences = 0;

        for (String word : occurrence.keySet()) {
            if (occurrence.get(word) > occurences) {
                occurences = occurrence.get(word);
                mostFrequentWord = word;
            }

        }

        System.out.println(mostFrequentWord + " " + occurences);

    }

    // don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        printMostFrequentWord(words);
    }
}