package de.dafrit.dwb.rubrik;

import java.util.List;
import java.util.stream.Collectors;

public class RubrikTree {

	private final List<RubrikEntity> rubriken;
	
	private final List<RubrikParentChildEntity> parentChilds;
	
	private RubrikModel root = RubrikModel.createRoot();
	
	public RubrikTree(List<RubrikEntity> rubriken, List<RubrikParentChildEntity> parentChilds) {
		super();
		this.rubriken = rubriken;
		this.parentChilds = parentChilds;
	}
	
	public List<RubrikModel> createTree() {
		List<RubrikModel> hauptrubriken = createHauptrubriken();
		
		hauptrubriken.forEach(this::createChilds);
		
		return hauptrubriken;
	}
	
	private List<RubrikModel> createHauptrubriken() {
		return rubriken.stream()
				.filter(this::isHauptrubrik)
				.sorted((a,b) -> a.getNr().compareTo(b.getNr()))
				.map(entity -> create(entity, root))
				.collect(Collectors.toList());
	}
	
	private void createChilds(RubrikModel parent) {
		List<RubrikModel> list = parentChilds.stream()
				.filter(pc -> pc.getParent() == parent.getId())
				.sorted((a,b) -> Integer.compare(a.getPrioritaet(), b.getPrioritaet()))
				.map(pc -> createChild(pc.getChild(), parent))
				.collect(Collectors.toList());
		
		if (!list.isEmpty()) {
			list.forEach(this::createChilds);
		}
	}
	
	private boolean isHauptrubrik(RubrikEntity rubrik) {
		return parentChilds.stream()
				.noneMatch(pc -> pc.getChild() == rubrik.getId());
	}
	
	private RubrikEntity findRubrikById(long id) {
		return rubriken.stream()
				.filter(r -> r.getId() == id)
				.findFirst()
				.orElseThrow();
	}
	
	private RubrikModel create(RubrikEntity entity, RubrikModel parent) {
		return new RubrikModel(entity.getId(), entity.getNr(), entity.getName(), entity.getSlug(), entity.getDescription(), parent);
	}

	private RubrikModel createChild(Long id, RubrikModel parent) {
		RubrikEntity entity = findRubrikById(id);
		return create(entity, parent);
	}
}