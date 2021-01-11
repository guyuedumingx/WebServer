import handle.ClientHandler;

import java.net.Socket;

public class HandleTest {

    public void getText(Socket socket) {
        String text = new ClientHandler(socket).getText();
        System.out.println(text);
    }

}
