
import java.util.ArrayList;
import java.util.List;

public class MemoryManagementLab {

    // Experiment 1: StackOverflowError
    static void recursiveMethod(int depth) {
        if (depth % 1000 == 0) {
            System.out.println("Recursion depth: " + depth);
        }

        recursiveMethod(depth + 1);
    }

    // Experiment 2: OutOfMemoryError
    static void heapExperiment() {
        List<byte[]> memory = new ArrayList<>();
        int count = 0;

        while (true) {
            memory.add(new byte[1024 * 1024]); // Approximately 1 MB
            count++;
            System.out.println("Allocated approximately "
                    + count + " MB");
        }
    }

    // Experiment 3: String concatenation
    static void stringExperiment() {
        int count = 20_000;

        long start = System.nanoTime();
        String result = "";

        for (int i = 0; i < count; i++) {
            result += "a";
        }

        long stringTime = System.nanoTime() - start;

        start = System.nanoTime();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < count; i++) {
            builder.append("a");
        }

        String builderResult = builder.toString();
        long builderTime = System.nanoTime() - start;

        System.out.println("String length: " + result.length());
        System.out.println("Builder length: " + builderResult.length());
        System.out.println("String += time: "
                + stringTime / 1_000_000.0 + " ms");
        System.out.println("StringBuilder time: "
                + builderTime / 1_000_000.0 + " ms");
    }

    // Experiment 4: Garbage collection
    static void gcExperiment() {
        for (int i = 0; i < 10; i++) {
            byte[] data = new byte[5 * 1024 * 1024];
            System.out.println("Created temporary array " + i);

            // The array becomes eligible for GC after it is no
            // longer reachable. Collection is not guaranteed here.
        }

        System.gc(); // Request only; not a guarantee
        System.out.println("GC request completed.");
    }

    // Experiment 5: Integer cache
    static void integerExperiment() {
        Integer a = 127;
        Integer b = 127;

        Integer c = 128;
        Integer d = 128;

        System.out.println("127 using == : " + (a == b));
        System.out.println("128 using == : " + (c == d));

        System.out.println("128 using equals(): " + c.equals(d));
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Choose an experiment:");
            System.out.println("stack | heap | string | gc | integer");
            return;
        }

        switch (args[0].toLowerCase()) {
            case "stack" -> recursiveMethod(1);
            case "heap" -> heapExperiment();
            case "string" -> stringExperiment();
            case "gc" -> gcExperiment();
            case "integer" -> integerExperiment();
            default -> System.out.println("Unknown experiment.");
        }
    }
}
