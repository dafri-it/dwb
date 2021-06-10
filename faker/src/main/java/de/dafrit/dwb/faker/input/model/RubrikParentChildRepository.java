package de.dafrit.dwb.faker.input.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubrikParentChildRepository extends JpaRepository<RubrikParentChildEntity, RubrikParentChildId> {
	
}