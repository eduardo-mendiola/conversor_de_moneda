import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/c95d49773b7cb1e193dfe324/pair/ARS/USD/1000"))
                .build();

        System.out.println("Enviando solicitud HTTP...");

        // Seguir redirecciones automáticamente
        HttpClient.Redirect followRedirect = HttpClient.Redirect.ALWAYS;
        HttpClient clientWithRedirect = HttpClient.newBuilder()
                .followRedirects(followRedirect)
                .build();

        HttpResponse<String> response = clientWithRedirect.send(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();
        String responseBody = response.body();

        System.out.println("Código de estado de la respuesta: " + statusCode);
        System.out.println("Cuerpo de la respuesta: " + responseBody);
    }
}
