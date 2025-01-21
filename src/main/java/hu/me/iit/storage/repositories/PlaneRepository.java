package hu.me.iit.storage.repositories;

import hu.me.iit.storage.entities.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneRepository extends JpaRepository<Plane, Long> {
}
