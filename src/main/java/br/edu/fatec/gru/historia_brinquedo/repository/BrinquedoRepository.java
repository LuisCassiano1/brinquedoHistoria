package br.edu.fatec.gru.historia_brinquedo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fatec.gru.historia_brinquedo.model.BrinquedoEntity;

@Repository
public interface BrinquedoRepository extends JpaRepository<BrinquedoEntity, Long> {

    List<BrinquedoEntity> findByCategoriaBrinquedo(String categoriaBrinquedo);

    List<BrinquedoEntity> findByNomeBrinquedoContainingIgnoreCase(String nomeBrinquedo);
}
