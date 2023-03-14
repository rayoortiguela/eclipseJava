package net.itinajero.service.db;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import net.itinajero.model.Categoria;
import net.itinajero.repository.CategoriasRepository;
import net.itinajero.service.ICategoriasService;

@Service
/**
 * 	Hay 2 clases que implementan la interfaz ICategoriasService:
 *		- CategoriasServiceImpl -> Guardamos las Categorias en una LinkedList
 *		- CategoriasServiceJpa  -> Guardamos las Categorias en bd
 *	Spring no puede decidir cual Inyectar. Nosotros tenemos que decidir.
 *	Por lo tanto, con la anotación @Primary le decimos que esta es la implementación por Defecto.
 *
 */
@Primary
public class CategoriasServiceJpa implements ICategoriasService{

	@Autowired
	private CategoriasRepository categoriasRepo;
	
	@Override
	public void guardar(Categoria categoria) {
		categoriasRepo.save(categoria);
	}

	@Override
	public void eliminar(Integer idCategoria) {
		categoriasRepo.deleteById(idCategoria);
	}

	@Override
	public List<Categoria> buscarTodas() {		
		return categoriasRepo.findAll();
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		Optional<Categoria> optional = categoriasRepo.findById(idCategoria);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Page<Categoria> buscarTodas(Pageable page) {
		return categoriasRepo.findAll(page);	
	}

}
