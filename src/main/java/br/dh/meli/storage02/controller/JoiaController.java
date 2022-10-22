package br.dh.meli.storage02.controller;

import br.dh.meli.storage02.dto.JoiaDTO;
import br.dh.meli.storage02.dto.JoiaResponseDTO;
import br.dh.meli.storage02.model.Joia;
import br.dh.meli.storage02.service.JoiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class JoiaController {

    @Autowired
    private JoiaService joiaService;

    @PostMapping("/joia/inserir")
    public ResponseEntity<String> inserirJoia(@RequestBody JoiaDTO joiaDTO){
        Joia joia = joiaService.inserirJoia(joiaDTO);
        return new ResponseEntity(joia.getId().toString(),HttpStatus.CREATED);
    }
    @GetMapping("/joias")
    public ResponseEntity<List<JoiaResponseDTO>> listarJoias(){
        return new ResponseEntity<>(joiaService.consultarTodos().stream().map(JoiaResponseDTO::new).collect(Collectors.toList()),HttpStatus.OK);
    }
    @DeleteMapping("/joia/excluir")
    public ResponseEntity<String> deletarJoia(@RequestParam Long id){
        joiaService.deletarJoia(id);
        return new ResponseEntity<>("joia " + id + " deletado com sucesso",HttpStatus.OK);
    }
    @PutMapping("/joia/atualizar")
    public ResponseEntity<JoiaResponseDTO> atualizarJoia(@RequestBody JoiaDTO joiaDto, @RequestParam Long id) throws Exception {
        Joia joia = null;
        try {
            joia = joiaService.atualizarJoia(joiaDto, id);
            JoiaResponseDTO response = new JoiaResponseDTO(joia);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
