package de.dafrit.dwb.rubrik;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubrikRepository extends JpaRepository<RubrikEntity, Long> {
}
