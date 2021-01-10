import handle.RequestHandler;

import java.net.Socket;

public class HandleTest {

    public void getText(Socket socket) {
        String text = new RequestHandler(socket).getText();
        System.out.println(text);
    }

}
