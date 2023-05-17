import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    final static String host = "127.0.0.1";
    final static int port = 8989;
    public static void main(String[] args) {
        try (Socket socket = new Socket(host,port); BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); PrintWriter out = new PrintWriter(socket.getOutputStream())){
            out.println("вы");
            out.flush();
            System.out.println(in.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
