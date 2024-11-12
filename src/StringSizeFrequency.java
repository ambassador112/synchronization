import java.util.HashMap;
import java.util.Map;

public class StringSizeFrequency {

    public static final Map<Integer, Integer> sizeToFreq = new HashMap<>();

    public static void processString(String str) {
        int size = str.length();

        synchronized (sizeToFreq) {
            sizeToFreq.put(size, sizeToFreq.getOrDefault(size, 0) + 1);
        }
    }

    public static Map.Entry<Integer, Integer> getMostFrequentSize() {
        int mostFrequentSize = -1;
        int mostFrequentCount = -1;

        synchronized (sizeToFreq) {
            for (Map.Entry<Integer, Integer> entry : sizeToFreq.entrySet()) {
                if (entry.getValue() > mostFrequentCount) {
                    mostFrequentSize = entry.getKey();
                    mostFrequentCount = entry.getValue();
                }
            }
        }

        return Map.entry(mostFrequentSize, mostFrequentCount);
    }
}
