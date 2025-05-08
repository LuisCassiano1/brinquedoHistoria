package br.edu.fatec.gru.historia_brinquedo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatec.gru.historia_brinquedo.model.BrinquedoEntity;

public interface BrinquedoRepository extends JpaRepository <BrinquedoEntity, Integer> {

}
