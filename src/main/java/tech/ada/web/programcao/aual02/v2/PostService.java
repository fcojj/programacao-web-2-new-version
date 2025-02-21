package tech.ada.web.programcao.aual02.v2;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PostService {

    private final static String GET_POST_BY_ID_URL = "https://jsonplaceholder.typicode.com/posts/%s";
    private final static String CREATE_POST_URL = "https://jsonplaceholder.typicode.com/posts";

    public String getPost(String id) {
        var apiUrl = String.format(GET_POST_BY_ID_URL, id);

        //HttpClient é uma classe que faz requisições HTTP inserida no Java 11
        try(var client = HttpClient.newHttpClient()){
            var request = HttpRequest.newBuilder(URI.create(apiUrl))
                    .header("Accept", "application/json")
                    .GET()
                    .build();

            //envia a requisição e converte a body resposta para String
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());


            return response.body();
        } catch (Exception e) {
            throw new RuntimeException("Erro na requisicao: " + e.getMessage());
        }
    }

    public Post createPost(Post post) {
        try(var client = HttpClient.newHttpClient()){
            //String requestBody = String.format("{\"title\":\"%s\",\"body\":\"%s\",\"userId\":%d}",
            //        post.getTitulo(), post.getBody(), post.getUserId());

            ObjectMapper objectMapper = new ObjectMapper();
            //converte o objeto post para JSON -> Serialização
            var postAsJson = objectMapper.writeValueAsString(post);

            //HttpClient é uma classe que faz requisições HTTP inserida no Java 11
            var request = HttpRequest.newBuilder(URI.create(CREATE_POST_URL))
                    .headers("Content-type", "application/json; charset=UTF-8")
                    .POST(HttpRequest.BodyPublishers.ofString(postAsJson))
                    .build();

            //envia a requisição e converte a body resposta para String
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //converte o JSON da resposta para objeto Post -> Desserialização
            return  objectMapper.readValue(response.body(), Post.class);

        } catch (Exception e) {
            throw new RuntimeException("Erro aconteceu: " + e.getMessage());
        }
    }
}
