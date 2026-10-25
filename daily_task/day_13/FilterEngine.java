
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Product {
    private final String name;
    private final String category;
    private final double price;
    private final boolean inStock;

    public Product(String name, String category, double price, boolean inStock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.inStock = inStock;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isInStock() {
        return inStock;
    }

    @Override
    public String toString() {
        return name + " | " + category + " | ₹" + price
                + " | In stock: " + inStock;
    }
}

public class FilterEngine {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Laptop", "Electronics", 55000, true),
                new Product("Mouse", "Electronics", 800, true),
                new Product("Chair", "Furniture", 4500, false),
                new Product("Keyboard", "Electronics", 1800, true),
                new Product("Desk", "Furniture", 7000, true)
        );

        Predicate<Product> affordable = p -> p.getPrice() < 10000;
        Predicate<Product> electronics =
                p -> p.getCategory().equals("Electronics");
        Predicate<Product> available = Product::isInStock;

        Predicate<Product> filter =
                affordable.and(electronics).and(available);

        Function<Product, String> getName = Product::getName;
        Function<String, String> uppercase = String::toUpperCase;
        Function<Product, String> transform = getName.andThen(uppercase);

        Consumer<String> printer = System.out::println;
        Supplier<Product> defaultProduct =
                () -> new Product("Notebook", "Stationery", 100, true);

        System.out.println("=== Filtered Products ===");
        products.stream()
                .filter(filter)
                .map(transform)
                .forEach(printer);

        System.out.println("\n=== Default Product ===");
        System.out.println(defaultProduct.get());
    }
}
