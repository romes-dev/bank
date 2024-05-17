public class ProductOperations {
    private final Datastore datastore;

    public ProductOperations(Datastore datastore) {
        this.datastore = datastore;
    }

    public void addProduct(Product product) {
        datastore.save(product);
    }

    public Product findProductByName(String name) {
        return datastore.find(Product.class).field("name").equal(name).first();
    }
}
