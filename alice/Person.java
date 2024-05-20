import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Person {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private int age;

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
