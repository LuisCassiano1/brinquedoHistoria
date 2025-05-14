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
    
    public List<BrinquedoEntity> findByDestaqueTrue() {
        return brinquedoRepository.findByDestaqueTrue();
    }

    public List<BrinquedoEntity> listAll() {
        return brinquedoRepository.findAll();
    }

    public BrinquedoEntity getById(Long idBrinquedo) {
        return brinquedoRepository.findById(idBrinquedo).orElse(null);
    }

    public void delete(Long idBrinquedo) {
        brinquedoRepository.deleteById(idBrinquedo);
    }
    

    public List<String> listarCategorias() {
        return List.of("Pelúcias", "Quebra-cabeças", "Carrinhos");
    }

    public List<BrinquedoEntity> findByCategoriaBrinquedoIgnoreCase(String categoriaBrinquedo) {
        return brinquedoRepository.findByCategoriaBrinquedoIgnoreCase(categoriaBrinquedo);
    }
}