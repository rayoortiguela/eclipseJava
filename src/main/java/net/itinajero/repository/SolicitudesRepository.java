package net.itinajero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.itinajero.model.Solicitud;

public interface SolicitudesRepository extends JpaRepository<Solicitud, Integer> {

}
