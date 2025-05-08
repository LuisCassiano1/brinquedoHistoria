package br.edu.fatec.gru.historia_brinquedo.repository;

import br.edu.fatec.gru.historia_brinquedo.model.BrinquedoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrinquedoRepository extends JpaRepository<BrinquedoEntity, Long> {

    // Consultar brinquedos pela categoria (campo "categoria")
    List<BrinquedoEntity> findByCategoria(String categoria);
}
