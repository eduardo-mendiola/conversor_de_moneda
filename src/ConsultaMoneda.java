import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public Moneda buscaValorMoneda(String tipoMonedaBase, String tipoMonedaDestino, Double monto){
        //https://v6.exchangerate-api.com/v6/c95d49773b7cb1e193dfe324/pair/ARS/USD/1000
        URI direccion =
                URI.create("https://v6.exchangerate-api.com/v6/c95d49773b7cb1e193dfe324/pair"
                                +"/"+tipoMonedaBase+"/"+tipoMonedaDestino+"/"+monto);
        //System.out.println(direccion);

        // Crear un cliente HTTP que siga redirecciones automáticamente
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontró el tipo de moneda.");
        }
    }
}
