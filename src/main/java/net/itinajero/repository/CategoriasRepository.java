package net.itinajero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.itinajero.model.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {
	
}
