package pl.akolata.s13803.riak;

import com.basho.riak.client.api.RiakClient;
import com.basho.riak.client.api.commands.kv.DeleteValue;
import com.basho.riak.client.api.commands.kv.FetchValue;
import com.basho.riak.client.api.commands.kv.StoreValue;
import com.basho.riak.client.api.commands.kv.UpdateValue;
import com.basho.riak.client.core.RiakCluster;
import com.basho.riak.client.core.RiakNode;
import com.basho.riak.client.core.query.Location;
import com.basho.riak.client.core.query.Namespace;
import lombok.extern.slf4j.Slf4j;
import pl.akolata.s13803.riak.crud.PhotographicFilmUpdate;
import pl.akolata.s13803.riak.model.PhotographicFilm;

import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Slf4j
public class RiakNbd08 {
    private static final String BUCKET_TYPE = "sets";
    private static final String BUCKET_NAME = "photoFilmsNbd08";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RiakCluster cluster = setUpCluster();
        RiakClient client = setUpClient(cluster);

        PhotographicFilm film = exampleFilm();
        String key = UUID.randomUUID().toString();
        log.info("Example document created. Document [{}], key [{}]", film, key);

        Namespace filmNamespace = new Namespace(BUCKET_TYPE, BUCKET_NAME, StandardCharsets.UTF_8);
        Location filmLocation = new Location(filmNamespace, key);

        storeFilm(client, filmLocation, film);
        PhotographicFilm fetchedFilmAfterStore = fetchFilm(client, filmLocation);
        logFilm(fetchedFilmAfterStore, filmLocation);

        updateFilm(client, filmLocation, fetchedFilmAfterStore);
        PhotographicFilm fetchedFilmAfterUpdate = fetchFilm(client, filmLocation);
        logFilm(fetchedFilmAfterUpdate, filmLocation);

        deleteFilm(client, filmLocation);
        PhotographicFilm fetchedFilmAfterDelete = fetchFilm(client, filmLocation);
        logFilm(fetchedFilmAfterDelete, filmLocation);

        cluster.shutdown();
    }

    private static RiakCluster setUpCluster() {
        log.info("Setting up Riak cluster...");
        RiakNode node = new RiakNode.Builder()
                .withRemoteAddress("127.0.0.1")
                .withRemotePort(8087)
                .build();
        RiakCluster cluster = new RiakCluster.Builder(node).build();
        cluster.start();
        log.info("Riak cluster set up");
        return cluster;
    }

    private static RiakClient setUpClient(RiakCluster cluster) {
        log.info("Creating Riak client...");
        RiakClient client = new RiakClient(cluster);
        log.info("Riak client created");
        return client;
    }

    private static PhotographicFilm exampleFilm() {
        return PhotographicFilm.builder()
                .brand("Ilford")
                .model("HP5+")
                .colour(Boolean.FALSE)
                .exposuresCount(36)
                .iso(400)
                .format("36mm")
                .build();
    }

    private static void storeFilm(RiakClient client, Location location, PhotographicFilm film) throws ExecutionException, InterruptedException {
        log.info("Trying to store document under location [{}]...", location.getKeyAsString());
        StoreValue storeOperation = new StoreValue.Builder(film)
                .withLocation(location)
                .build();
        client.execute(storeOperation);
        log.info("Document stored under location [{}]", location.getKeyAsString());
    }

    private static PhotographicFilm fetchFilm(RiakClient client, Location location) throws ExecutionException, InterruptedException {
        log.info("Trying to fetch document from location [{}]...", location.getKeyAsString());
        FetchValue fetchOperation = new FetchValue.Builder(location).build();
        FetchValue.Response response = client.execute(fetchOperation);
        PhotographicFilm fetchedFilm = response.getValue(PhotographicFilm.class);
        log.info("Fetched document from location [{}]", location.getKeyAsString());
        return fetchedFilm;
    }

    private static void updateFilm(RiakClient client, Location location, PhotographicFilm film) throws ExecutionException, InterruptedException {
        log.info("Trying to update document under location [{}]...", location.getKeyAsString());
        film.setBrand("Canon");
        film.setModel("Color");
        film.setColour(Boolean.TRUE);
        film.setIso(200);
        PhotographicFilmUpdate filmUpdate = new PhotographicFilmUpdate(film);
        UpdateValue updateOperation = new UpdateValue.Builder(location)
                .withUpdate(filmUpdate)
                .build();
        UpdateValue.Response response = client.execute(updateOperation);
        log.info("Document under location [{}] updated: [{}]", location.getKeyAsString(), response.wasUpdated());
    }

    private static void deleteFilm(RiakClient client, Location location) throws ExecutionException, InterruptedException {
        log.info("Trying to delete document under location [{}]...", location.getKeyAsString());
        DeleteValue deleteOperation = new DeleteValue.Builder(location)
                .build();
        client.execute(deleteOperation);
        log.info("Document under location [{}] deleted", location.getKeyAsString());
    }

    private static void logFilm(PhotographicFilm film, Location location) {
        if (film == null) {
            log.info("Document under key [{}] does not exist", location.getKeyAsString());
        } else {
            log.info("Document under key [{}]: [{}]", location.getKeyAsString(), film);
        }
    }

}
