package br.dh.meli.storage02.service;

import br.dh.meli.storage02.dto.JoiaDTO;
import br.dh.meli.storage02.model.Joia;
import br.dh.meli.storage02.repository.IJoiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JoiaService {

    @Autowired
    private IJoiaRepository joiaRepository;

    public Joia inserirJoia(JoiaDTO joiaDTO) {
        Joia joia = new Joia();
        joia.setMaterial(joiaDTO.getMaterial());
        joia.setPeso(joiaDTO.getPeso());
        joia.setQuilates(joiaDTO.getQuilates());
        joia = joiaRepository.save(joia);
        return joia;
    }
    public List<Joia> consultarTodos() {
        List<Joia> joias = new ArrayList<>();
        joiaRepository.findAll().forEach(joias::add);
        return joias;
    }
    public void deletarJoia(Long id) {
        joiaRepository.deleteById(id);
    }
    public Joia atualizarJoia(JoiaDTO joiaDto, Long id) throws Exception{
        Optional<Joia> joiaOptional = consultarPorId(id);
        if(joiaOptional.isPresent()){
            Joia joia = joiaOptional.get();
            joia.setMaterial(joiaDto.getMaterial());
            joia.setPeso(joiaDto.getPeso());
            joia.setQuilates(joiaDto.getQuilates());
            return joiaRepository.save(joia);
        }
        throw new Exception("esse id nao existe");
    }
    public Optional<Joia> consultarPorId(Long id){
        return joiaRepository.findById(id);
    }
}
