package reqres;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
public class PutColorTest {
    @Test
    @DisplayName("Вызов метода PUT /changeColor. Изменение значения color у пользователя")
    public void successPutColor() throws IOException, URISyntaxException, InterruptedException {
        byte[] out = "{\"color\":\"#C74375\"}".getBytes(StandardCharsets.UTF_8);

        HttpRequest request = HttpRequest.newBuilder()
                .setHeader("Content-Type", "application/json; charset=utf-8")
                .uri(new URI("https://reqres.in/api/users/3"))
                .PUT(HttpRequest.BodyPublishers.ofByteArray(out))
                .build();

        HttpResponse response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body()
        );
    }
}
