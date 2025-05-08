package br.edu.fatec.gru.historia_brinquedo.repository;

import br.edu.fatec.gru.historia_brinquedo.model.BrinquedoEntity;
import br.edu.fatec.gru.historia_brinquedo.model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    public Optional<UsuarioEntity> findByIdAndAdmTrue(Long id);
}
