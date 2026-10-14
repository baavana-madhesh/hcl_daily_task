
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void display() {
        System.out.println("Key: " + key + ", Value: " + value);
    }
}

public class GenericToolkit {
    public static void main(String[] args) {

        // Pair with String and Integer
        Pair<String, Integer> person =
                new Pair<>("Baavana", 21);

        // Pair with Integer and String
        Pair<Integer, String> product =
                new Pair<>(101, "Laptop");

        // Display both pairs
        person.display();
        product.display();
    }
}
