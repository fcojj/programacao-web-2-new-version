package tech.ada.web.programcao.aual02.v2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostLombok {

    private int userId;
    private int id;

    // Mapeia o campo title do JSON para o atributo titulo da classe(desserialização)
    @JsonProperty("title")
    private String titulo;
    private String body;

    // Atributo que não existe no JSON
    @JsonIgnore
    private boolean isActivated;

    public PostLombok(String titulo, String body) {
        this.userId = 1;
        this.titulo = titulo;
        this.body = body;
    }
}
