package br.edu.fatec.gru.historia_brinquedo.Service;

import br.edu.fatec.gru.historia_brinquedo.model.UsuarioEntity;
import br.edu.fatec.gru.historia_brinquedo.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<UsuarioEntity> validar(Long id){
        if(usuarioRepository.existsById(id)){
            return usuarioRepository.findByIdAndAdmTrue(id);
        }
        throw new EntityNotFoundException("Usuário não encontrado");
    }

    public UsuarioEntity criar(UsuarioEntity usuario){
        if(usuario.getId()==null){
            return usuarioRepository.save(usuario);
        }
        throw new EntityNotFoundException("Corpo do usuário não pode conter um ID");
    }

    public Optional<UsuarioEntity> ler(Long id){
        if(usuarioRepository.existsById(id)){
            return usuarioRepository.findById(id);
        }
        throw new EntityNotFoundException("Usuário não encontrado");
    }

    public List<UsuarioEntity> listarTodos(){
        List<UsuarioEntity> listaEntities = usuarioRepository.findAll();
        return listaEntities;
    }

    public UsuarioEntity editar(UsuarioEntity usuario){
        if(usuarioRepository.existsById(usuario.getId())){
            return usuarioRepository.save(usuario);
        }
        throw new EntityNotFoundException("Usuário não encontrado");
    }

    public void deletar(Long id){
        if(usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return;
        }
        throw new EntityNotFoundException("Usuário não encontrado");
    }
}