package tech.ada.web.programcao.aual02.v2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//ignora atributos do JSON que não existem na classe,
// Agora, mesmo que o JSON tenha campos extras, o Jackson não lançará exceção.
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {

    private int userId;
    private int id;

    // Mapeia o campo title do JSON para o atributo titulo da classe(des    serialização)
    @JsonProperty("title")
    private String titulo;
    private String body;

    // Atributo que não existe no JSON
    @JsonIgnore
    private boolean isActivated;

    // Construtor vazio necessário para a desserialização do JSON
    public Post() {
    }

    public Post(String titulo, String body) {
        this.userId = 1;
        this.titulo = titulo;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + titulo + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
