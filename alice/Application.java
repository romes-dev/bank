import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ogm-mongodb");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Person person = new Person();
        person.setName("Alice");
        person.setAge(30);
        em.persist(person);

        em.getTransaction().commit();

        Person foundPerson = em.find(Person.class, person.getId());
        System.out.println("Found: " + foundPerson.getName());

        em.close();
        emf.close();
    }
}
