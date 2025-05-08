package br.edu.fatec.gru.historia_brinquedo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatec.gru.historia_brinquedo.model.BrinquedoEntity;
import br.edu.fatec.gru.historia_brinquedo.repository.BrinquedoRepository;
import br.edu.fatec.gru.historia_brinquedo.repository.BrinquedoRepository;
import jakarta.persistence.EntityNotFoundException;


@Service
public class BrinquedoService {
    @Autowired
    private BrinquedoRepository brinquedoRepository;

    public BrinquedoEntity criar(BrinquedoEntity brinquedo){
        if(brinquedo.getId()==null){
            return brinquedoRepository.save(brinquedo);
        }
        throw new EntityNotFoundException("Corpo do brinquedo não pode conter um ID");
    }

    public Optional<BrinquedoEntity> ler (Long id){
        if(brinquedoRepository.existsById(id)){
            return brinquedoRepository.findById(id);
        }
        throw new EntityNotFoundException("Brinquedo não encontrado");
    }

    public List<BrinquedoEntity> listarTodos(){
        List<BrinquedoEntity> listaEntities = brinquedoRepository.findAll();
        return listaEntities;
    }

    public BrinquedoEntity editar(BrinquedoEntity brinquedo){
        if(brinquedoRepository.existsById(brinquedo.getId())){
            return brinquedoRepository.save(brinquedo);
        }
        throw new EntityNotFoundException("Brinquedo não encontrado");
    }

    public void deletar(Long id){
        if(brinquedoRepository.existsById(id)){
            brinquedoRepository.deleteById(id);
            return;
        }

        throw new EntityNotFoundException("Brinquedo não encontrado");
    }

}
