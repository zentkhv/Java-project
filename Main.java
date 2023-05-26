import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> fruit_list = new ArrayList<>();
        fruit_list.add("Яблоко");
        fruit_list.add("Банан");
        fruit_list.add("Апельсин");
        fruit_list.add("Груша");

        Random random = new Random();

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        // Создание обработчика запросов
        server.createContext("/", new MyHandler(fruit_list, random));

        // Запуск сервера
        server.start();

        System.out.println("HTTP-сервер запущен на порту 8000");
    }

    // Обработчик запросов
    static class MyHandler implements com.sun.net.httpserver.HttpHandler {
        private ArrayList<String> fruitList;
        private Random random;

        public MyHandler(ArrayList<String> fruitList, Random random) {
            this.fruitList = fruitList;
            this.random = random;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            exchange.getResponseHeaders().set("Content-Type", "text/plain; charset=UTF-8");

            // Получение случайного фрукта
            String randomFruit = fruitList.get(random.nextInt(fruitList.size()));

            // Отправка ответа клиенту
            exchange.sendResponseHeaders(200, randomFruit.getBytes().length);
            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(randomFruit.getBytes());
            outputStream.close();
        }
    }
}
