package tech.ada.web.programcao.aula01;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ViaCepCliente {
    public static void main(String[] args) {

        String cep = "60843025";
        String apiUrl = STR."https://viacep.com.br/ws/\{cep}/json/";

        try(HttpClient client = HttpClient.newHttpClient()) {

            //cria o request
            HttpRequest request = HttpRequest.newBuilder(URI.create(apiUrl))
                    .header("Accept", "application/json")
                    .GET()
                    .build();
            //envia a requisição
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // verifica http status da reposta foi 200 - OK
            if (response.statusCode() != 200) {
                System.out.println(STR."Erro na conexão: \{response.statusCode()}");
                return;
            }

            // imprime o corpo da resposta
            String responseBody = response.body();
            System.out.println(responseBody);

        } catch (Exception e) {
            System.out.println(STR."Erro na requisição: \{e.getMessage()}");
        }
    }
}