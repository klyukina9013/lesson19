// хотела только узнать, можно ли как-то выводить данные в более читабельном виде ?
package reqres;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetListUsersTest {
    @Test
    @DisplayName("Вызов метода GET /ListUsers. Получение информации о пользователях на одной странице")
    public void successGetListUsers() throws IOException {
        StringBuilder result = new StringBuilder();
        URL url = new URL("https://reqres.in/api/users?per_page=12");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }
        System.out.println(result);
    }

    @Test
    @DisplayName("Проверка получаемого статус-кода в ответ на вызов метода GET /ListUsers")
    public void successGetListUsersStatusCode() throws IOException {
        URL url = new URL("https://reqres.in/api/users?per_page=12");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        System.out.println(connection.getResponseCode());
    }

}
