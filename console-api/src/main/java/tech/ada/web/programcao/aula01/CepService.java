package tech.ada.web.programcao.aula01;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CepService {
    private final static String GET_CEP_URL = "https://viacep.com.br/ws/%s/json/";

    public String getCepData(String cep) {
        var apiUrl = String.format(GET_CEP_URL,cep);

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
                throw new RuntimeException(STR."Erro na conexão: \{response.statusCode()}");
            }

            return response.body();
        } catch (Exception e) {
            throw new RuntimeException(STR."Erro na requisicao: \{e.getMessage()}");
        }
    }
}

