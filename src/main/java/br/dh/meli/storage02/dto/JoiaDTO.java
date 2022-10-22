package br.dh.meli.storage02.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Getter
public class JoiaDTO implements Serializable {
    private String material;
    private Double peso;
    private Integer quilates;

}
