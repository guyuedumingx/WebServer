import io.Server;
import org.junit.Test;

import java.net.Socket;


public class ServerTest {

    @Test
    public void runTest() {
        Server server = new Server(8081);
        Socket run = server.run();
        new HandleTest().getText(run);
    }
}
