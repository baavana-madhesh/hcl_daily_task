public class MonthlyUsageAnalyser {

    // Slab constants
    static final int SLAB_1_LIMIT = 100;
    static final int SLAB_2_LIMIT = 200;

    public static void main(String[] args) {

        // 12 months' usage
        int[] monthlyUsage = {
            120, 150, 180, 210,
            190, 250, 300, 275,
            220, 160, 140, 130
        };

        // Total, maximum and minimum
        long total = 0;
        int max = monthlyUsage[0];
        int min = monthlyUsage[0];

        for (int usage : monthlyUsage) {
            total += usage;

            if (usage > max) {
                max = usage;
            }

            if (usage < min) {
                min = usage;
            }
        }

        // Average with casting
        double average = (double) total / monthlyUsage.length;

        // Grade using ternary operator
        char grade = average >= 250 ? 'A'
                   : average >= 200 ? 'B'
                   : average >= 150 ? 'C'
                   : 'D';

        // Overflow demonstration/fix
        int largeValue = Integer.MAX_VALUE;
        long fixedValue = (long) largeValue + 100;

        // 2-D array for 3 houses
        int[][] houseUsage = {
            {120, 150, 180},
            {200, 220, 240},
            {300, 280, 260}
        };

        System.out.println("===== Monthly Usage Analyser =====");

        System.out.println("Total Usage   : " + total);
        System.out.println("Average Usage : " + average);
        System.out.println("Maximum Usage : " + max);
        System.out.println("Minimum Usage : " + min);
        System.out.println("Grade         : " + grade);

        System.out.println("\n===== Overflow Fix =====");
        System.out.println("Integer max + 100 using long: " + fixedValue);

        System.out.println("\n===== 3 Houses Usage =====");

        for (int house = 0; house < houseUsage.length; house++) {
            System.out.print("House " + (house + 1) + ": ");

            for (int month = 0; month < houseUsage[house].length; month++) {
                System.out.print(houseUsage[house][month] + " ");

            }

            System.out.println();
        }
    }
}