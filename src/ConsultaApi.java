import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.jshell.spi.SPIResolutionException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;

public class ConsultaApi {
    HttpClient client = HttpClient.newHttpClient();
    String direccion= "https://v6.exchangerate-api.com/v6/90bb2fbe5709010da8d02d80/pair/";


    public void realizarConsulta(String moneda1 ,String moneda2,double cantidad){
        String urlConDatos = direccion + moneda1 + "/" + moneda2 +"/"+ cantidad;

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(urlConDatos))
            .build();

        try {
           HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
           if (response.statusCode() == 200){
               JsonObject respuestaJson = JsonParser.parseString(response.body()).getAsJsonObject();
               String monedaInicial = respuestaJson.get("base_code").getAsString();
               String monedaObjerivo = respuestaJson.get("target_code").getAsString();
               double valorConvertido = respuestaJson.get("conversion_result").getAsDouble();
               DecimalFormat decimalFormat = new DecimalFormat("###,##0.00");
               System.out.println("El valor de "+ cantidad +" ["+ monedaInicial + "] en ["+ monedaObjerivo + "] es de : "+ decimalFormat.format(valorConvertido) );
           }else {
               throw new ApiException("Error respuesta de la Api" + response.statusCode());
           }
        } catch (IOException | InterruptedException e) {
            throw new ApiException("Error con la Api" + e.getMessage());
        }
    }
}
