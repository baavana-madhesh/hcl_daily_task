
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Order {
    private final int id;
    private final String customer;
    private final String category;
    private final String product;
    private final double amount;
    private final String status;

    public Order(int id, String customer, String category,
                 String product, double amount, String status) {
        this.id = id;
        this.customer = customer;
        this.category = category;
        this.product = product;
        this.amount = amount;
        this.status = status;
    }

    public String getCustomer() {
        return customer;
    }

    public String getCategory() {
        return category;
    }

    public String getProduct() {
        return product;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }
}

public class SalesAnalytics {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, "Arun", "Electronics", "Laptop", 55000, "DELIVERED"),
                new Order(2, "Priya", "Electronics", "Mouse", 800, "PENDING"),
                new Order(3, "Arun", "Furniture", "Chair", 4500, "DELIVERED"),
                new Order(4, "Kavin", "Electronics", "Phone", 25000, "DELIVERED"),
                new Order(5, "Priya", "Furniture", "Desk", 7000, "CANCELLED"),
                new Order(6, "Meena", "Books", "Java Book", 900, "DELIVERED"),
                new Order(7, "Kavin", "Books", "SQL Book", 700, "PENDING"),
                new Order(8, "Meena", "Electronics", "Keyboard", 1800, "DELIVERED")
        );

        System.out.println("=== Revenue by Category ===");
        Map<String, Double> revenueByCategory = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCategory,
                        Collectors.summingDouble(Order::getAmount)
                ));
        revenueByCategory.forEach((category, revenue) ->
                System.out.println(category + ": ₹" + revenue));

        System.out.println("\n=== Top 3 Customers ===");
        orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomer,
                        Collectors.summingDouble(Order::getAmount)
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue()
                        .reversed())
                .limit(3)
                .forEach(System.out::println);

        System.out.println("\n=== Orders by Status ===");
        Map<Boolean, List<Order>> partitioned = orders.stream()
                .collect(Collectors.partitioningBy(
                        order -> order.getStatus().equals("DELIVERED")
                ));
        System.out.println("Delivered: " + partitioned.get(true).size());
        System.out.println("Not delivered: " + partitioned.get(false).size());

        System.out.println("\n=== Average Basket Size ===");
        double average = orders.stream()
                .collect(Collectors.averagingDouble(Order::getAmount));
        System.out.println("₹" + average);

        System.out.println("\n=== Product List ===");
        String productList = orders.stream()
                .map(Order::getProduct)
                .distinct()
                .collect(Collectors.joining(", "));
        System.out.println(productList);

        System.out.println("\n=== Order Summary ===");
        System.out.println(orders.stream()
                .collect(Collectors.summarizingDouble(Order::getAmount)));

        System.out.println("\n=== Sequential vs Parallel ===");
        long sequentialStart = System.nanoTime();
        long sequentialCount = orders.stream()
                .mapToLong(order -> (long) (Math.sqrt(order.getAmount()) * 1000))
                .sum();
        long sequentialTime = System.nanoTime() - sequentialStart;

        long parallelStart = System.nanoTime();
        long parallelCount = orders.parallelStream()
                .mapToLong(order -> (long) (Math.sqrt(order.getAmount()) * 1000))
                .sum();
        long parallelTime = System.nanoTime() - parallelStart;

        System.out.println("Sequential result: " + sequentialCount);
        System.out.println("Sequential time: " + sequentialTime + " ns");
        System.out.println("Parallel result: " + parallelCount);
        System.out.println("Parallel time: " + parallelTime + " ns");
    }
}
