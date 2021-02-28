package de.dafri.dwb.rubrik;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.dafrit.dwb.rubrik.RubrikEntity;
import de.dafrit.dwb.rubrik.RubrikModel;
import de.dafrit.dwb.rubrik.RubrikParentChildEntity;
import de.dafrit.dwb.rubrik.RubrikTree;

class RubrikTreeShould {

	List<RubrikEntity> rubriken = List.of(
			new RubrikEntity(1L, "0", "Aktuelles"), 
			new RubrikEntity(2L, "002", "Recht"),
			new RubrikEntity(3L, "003", "Personalpraxis"), 
			new RubrikEntity(22L, "210", "Arbeitsrecht"),
			new RubrikEntity(24L, "240", "Beamtenrecht"), 
			new RubrikEntity(31L, "310", "Eingruppierung"),
			new RubrikEntity(32L, "260", "Datenschutz"));

	List<RubrikParentChildEntity> parentChilds = List.of(
			new RubrikParentChildEntity(2, 22, 0),
			new RubrikParentChildEntity(2, 24, 1), 
			new RubrikParentChildEntity(3, 31, 0),
			new RubrikParentChildEntity(3, 32, 1));

	@Test
	void haveDreiHauptrubriken() {
		List<RubrikModel> tree = new RubrikTree(rubriken, parentChilds).createTree();
		assertEquals(3, tree.size());

		assertEquals(1, tree.get(0).getId());
		assertEquals(2, tree.get(1).getId());
		assertEquals(3, tree.get(2).getId());
	}

	@Test
	void haveRechtChilds() {
		List<RubrikModel> tree = new RubrikTree(rubriken, parentChilds).createTree();

		RubrikModel recht = tree.get(1);
		assertEquals("Recht", recht.getName());
		
		assertFalse(recht.getChilds().isEmpty());
	}

}
