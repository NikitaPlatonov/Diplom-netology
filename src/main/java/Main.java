import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        BooleanSearchEngine engine = new BooleanSearchEngine(new File("pdfs"));
        try (ServerSocket serverSocket = new ServerSocket(8989)) {
            System.out.println("Сервер запущен");
            while (true) {
                try (Socket socket = serverSocket.accept(); BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); PrintWriter out = new PrintWriter(socket.getOutputStream())) {
                    System.out.println("Подключился клиент с таким портом " + socket.getPort());
                    String expectedWord = in.readLine();
                    if(engine.search(expectedWord).equals(Collections.emptyList())){
                        out.println("Совпадений нет");
                    } else {
                        out.println(engine.search(expectedWord));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}