package de.dafrit.dwb.termin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminRepository extends JpaRepository<TerminEntity, Long> {

	@Query("SELECT t FROM Termin t LEFT JOIN FETCH t.themen th WHERE th.thema = ?1")
	List<TerminEntity> findByThemaId(Long themaId);

	@Query("SELECT t FROM Termin t LEFT JOIN FETCH t.themen th")
	List<TerminEntity> findAllWithThemaRef();
}
