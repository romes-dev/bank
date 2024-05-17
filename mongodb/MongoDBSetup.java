import dev.morphia.Datastore;
import dev.morphia.Morphia;
import com.mongodb.client.MongoClients;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.MongoClient;
import java.util.Arrays;

public class MongoDBSetup {
    private Datastore datastore;

    public MongoDBSetup() {
        var mongoClient = MongoClients.create(
            MongoClientSettings.builder()
            .applyToClusterSettings(builder -> 
                builder.hosts(Arrays.asList(new ServerAddress("localhost", 27017))))
            .build());

        var morphia = new Morphia();
        morphia.mapPackage("your.package.name.models");

        datastore = morphia.createDatastore((MongoClient) mongoClient, "yourDatabaseName");
        datastore.ensureIndexes();
    }

    public Datastore getDatastore() {
        return datastore;
    }
}

