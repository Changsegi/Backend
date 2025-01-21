package hu.me.iit.storage.repositories;

import hu.me.iit.storage.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
