
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Storehouse {

    private Map<String, Integer> price;
    private Map<String, Integer> stock;

    public Storehouse() {
        this.price = new HashMap<String, Integer>();
        this.stock = new HashMap<String, Integer>();
    }

    public void addProduct(String product, int price, int stock) {
        this.price.put(product, price);
        this.stock.put(product, stock);
    }

    public int price(String product) {
        if (!this.price.containsKey(product)) {
            return -99;
        }
        return this.price.get(product);
    }

    public int stock(String product) {
        if (!(this.stock.containsKey(product))) {
            return -0;
        }
        return this.stock.get(product);
    }

    public boolean take(String product) {
        if (this.stock(product) > 0) {
            this.stock.put(product, this.stock.get(product) - 1);
            return true;
        }
        return false;
    }

    public Set<String> products() {
        return this.price.keySet();
    }

}
