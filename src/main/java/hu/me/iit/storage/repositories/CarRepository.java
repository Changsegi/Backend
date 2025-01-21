package hu.me.iit.storage.repositories;

import hu.me.iit.storage.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
