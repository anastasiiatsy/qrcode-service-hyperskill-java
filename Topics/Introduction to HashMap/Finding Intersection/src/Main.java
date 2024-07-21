import java.util.*;
import java.util.stream.Stream;

class Main {
    private static void printCommon(int[] firstArray, int[] secondArray) {
        // Enter your Code Here
        Map<Integer, Integer> values = new HashMap<>();
        List<Integer> list = Stream.of(firstArray, secondArray).flatMap(ints -> Arrays.stream(ints).boxed()).toList();
        List<Integer> intersection = new ArrayList<>();

        for (Integer num : list) {
            if (values.containsKey(num) && !intersection.contains(num)) {
                intersection.add(num);
            } else {
                values.put(num, 1);
            }
        }
        Collections.sort(intersection);
        intersection.forEach(s -> System.out.print(s + " "));
    }

    public static void main(String[] args) {        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] firstArray = new int[n];
        int[] secondArray = new int[n];
        for (int i = 0; i < n; ++i) { 
            firstArray[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; ++i) { 
            secondArray[i] = scanner.nextInt();
        }

        printCommon(firstArray, secondArray);
    }
}
