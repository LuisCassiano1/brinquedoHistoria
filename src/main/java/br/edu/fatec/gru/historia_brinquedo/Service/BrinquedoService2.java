package br.edu.fatec.gru.historia_brinquedo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatec.gru.historia_brinquedo.model.Brinquedo;
import br.edu.fatec.gru.historia_brinquedo.repository.BrinquedoRepository2;


@Service
public class BrinquedoService2 {

	@Autowired
	private BrinquedoRepository2 brinquedoRepository;
	
		public List<Brinquedo> listall() {
			return brinquedoRepository.findAll();
		}
		
		public Brinquedo getById (Integer id) {
			return brinquedoRepository.findById(id).get();
		}
		
		public Brinquedo SaveBrinquedo (Brinquedo brinquedo) {
			return brinquedoRepository.save(brinquedo);
		}
		
		public void DeleteBrinquedo (int id) {
			brinquedoRepository.deleteById(id);
		}
		
}



