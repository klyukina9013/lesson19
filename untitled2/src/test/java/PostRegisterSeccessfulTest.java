// пыталась сделать аналогично, не получилось( Body: {"error":"Missing email or username"}
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class PostRegisterSeccessfulTest {

    @Test
    @DisplayName("Вызов метода POST /registerUser. Регистрация нового пользователя")
    public void successPostRegisterUser() throws IOException, URISyntaxException, InterruptedException {
        byte[] out = "{\"email\":\"eve.holt@reqres.in\",\"password\":\"pistol\"}".getBytes(StandardCharsets.UTF_8);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://reqres.in/api/register"))
                .POST(HttpRequest.BodyPublishers.ofByteArray(out))
                .build();

        HttpResponse response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
