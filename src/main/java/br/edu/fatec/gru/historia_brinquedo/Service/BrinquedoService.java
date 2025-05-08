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

    // Criar ou editar
    public BrinquedoEntity salvar(BrinquedoEntity brinquedo) {
        return brinquedoRepository.save(brinquedo);
    }

    // Listar todos os brinquedos
    public List<BrinquedoEntity> listarTodos() {
        return brinquedoRepository.findAll();
    }

    // Buscar por ID
    public BrinquedoEntity buscarPorId(Long id) {
        return brinquedoRepository.findById(id).orElse(null);
    }

    // Deletar por ID
    public void deletar(Long id) {
        brinquedoRepository.deleteById(id);
    }

    // Buscar por categoria
    public List<BrinquedoEntity> buscarPorCategoria(String categoria) {
        return brinquedoRepository.findByCategoria(categoria);
    }
}
