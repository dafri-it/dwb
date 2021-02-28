package de.dafrit.dwb.thema;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemaRepository extends JpaRepository<ThemaEntity, Long> {
	
	@Query("SELECT t FROM Thema t LEFT JOIN FETCH t.rubriken r LEFT JOIN FETCH t.termine te WHERE r.rubrik = ?1 ORDER BY r.prioritaet")
	List<ThemaEntity> findByRubrikId(Long rubrikId);

}
