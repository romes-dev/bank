import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Validation;
import org.bson.types.ObjectId;

@Entity("products")
@Validation("{ 'price': { '$gt': 0 } }") // MongoDB validation: price must be greater than 0
public class Product {
    @Id
    private ObjectId id;
    private String name;
    private double price;
    private String category; // This could be "food", "beverage", "household", etc.
    private String description; // Optional

    // Constructors, getters and setters
}
