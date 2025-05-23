package br.edu.fatec.gru.historia_brinquedo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.fatec.gru.historia_brinquedo.model.BrinquedoEntity;

@Repository
public interface BrinquedoRepository extends JpaRepository<BrinquedoEntity, Long> {
	
	List<BrinquedoEntity> findByCategoriaBrinquedoIgnoreCase(String categoriaBrinquedo);

    List<BrinquedoEntity> findByNomeBrinquedoContainingIgnoreCase(String nomeBrinquedo);
    
    List<BrinquedoEntity> findByDestaqueTrue();
}
