/* лампочка-подсказка предлагала заменить patch на пут и тело ответа совпало с тем, как было в Postman,
        это так работает? */

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
public class PatchNewDataTest {
    @Test
    @DisplayName("Вызов метода PATCH /newData. Добавление значения job пользователю")
    public void successPatchNewData() throws IOException, URISyntaxException, InterruptedException {
        byte[] out = "{\"op\":\"add\", \"path\":\"/job\", \"value\":\"zion resident\"}".getBytes(StandardCharsets.UTF_8);

        HttpRequest request = HttpRequest.newBuilder()
                .setHeader("Content-Type", "application/json; charset=utf-8")
                .uri(new URI("https://reqres.in/api/users/1"))
                .PUT(HttpRequest.BodyPublishers.ofByteArray(out))
                .build();

        HttpResponse response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body()
        );
    }
}
