package br.edu.fatec.gru.historia_brinquedo.Service;

import br.edu.fatec.gru.historia_brinquedo.model.BrinquedoEntity;
import br.edu.fatec.gru.historia_brinquedo.repository.BrinquedoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrinquedoService {

    @Autowired
    private BrinquedoRepository brinquedoRepository;

    public BrinquedoEntity save(BrinquedoEntity brinquedo) {
        return brinquedoRepository.save(brinquedo);
    }

    public List<BrinquedoEntity> listAll() {
        return brinquedoRepository.findAll();
    }

    public BrinquedoEntity getById(Long id) {
        return brinquedoRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        brinquedoRepository.deleteById(id);
    }

    public List<BrinquedoEntity> getByCategoria(String categoria) {
        return brinquedoRepository.findByCategoria(categoria);
    }

    public List<BrinquedoEntity> getByNome(String nome) {
        return brinquedoRepository.findByNomeContainingIgnoreCase(nome);
    }
}