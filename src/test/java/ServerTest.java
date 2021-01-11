import io.Server;
import org.junit.Test;


public class ServerTest {

    @Test
    public void runTest() {
        Server server = new Server(8081);
        server.run();
    }
}
