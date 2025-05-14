import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCambio {

    private static final String API_KEY = "292db1369ce69d4e3d03f61a";

    public TasaCambio obtenerCambio(String monedaBase) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + monedaBase);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), TasaCambio.class);

        } catch (Exception e) {
            throw new RuntimeException("No se pudo obtener la tasa de cambio.");
        }
    }
}
