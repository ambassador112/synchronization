import java.util.Map;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        String[] strings = {
                "example",
                "test",
                "another test",
                "one more example",
                "short",
                "medium length string",
                "longer string example",
                "another string example"
        };

        Thread[] threads = new Thread[strings.length];
        for (int i = 0; i < strings.length; i++) {
            final String str = strings[i];
            threads[i] = new Thread(() -> StringSizeFrequency.processString(str));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        Map.Entry<Integer, Integer> mostFrequent = StringSizeFrequency.getMostFrequentSize();

        System.out.println("Самое частое количество повторений " + mostFrequent.getKey() + " (встретилось " + mostFrequent.getValue() + " раз)");

        System.out.println("Другие размеры:");
        for (Map.Entry<Integer, Integer> entry : StringSizeFrequency.sizeToFreq.entrySet()) {
            if (!entry.getKey().equals(mostFrequent.getKey())) {
                System.out.println("- " + entry.getKey() + " (" + entry.getValue() + " раз)");
            }
        }
    }
}
