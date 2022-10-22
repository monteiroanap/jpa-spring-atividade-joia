package br.dh.meli.storage02.dto;

import br.dh.meli.storage02.model.Joia;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@Getter
public class JoiaResponseDTO implements Serializable {
    private Long id;
    private String material;
    private Double peso;
    private Integer quilates;

    public JoiaResponseDTO(Joia joia){
        this.id = joia.getId();
        this.material = joia.getMaterial();
        this.peso = joia.getPeso();
        this.quilates = joia.getQuilates();
    }
}

