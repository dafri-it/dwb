package de.dafrit.dwb.rubrik;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RubrikPublicService {

	private final RubrikRepository rubrikRepository;

	private final RubrikParentChildRepository parentChildRepository;

	@Autowired
	public RubrikPublicService(
			RubrikRepository rubrikRepository, 
			RubrikParentChildRepository parentChildRepository) {
		this.rubrikRepository = rubrikRepository;
		this.parentChildRepository = parentChildRepository;
	}

	public List<RubrikEntity> findAll() {
		return rubrikRepository.findAll();
	}

	@Cacheable("rubriken")
	public RubrikTreeModel getTree() {
		List<RubrikEntity> rubriken = rubrikRepository.findAll();
		List<RubrikParentChildEntity> parentChilds = parentChildRepository.findAll();
		RubrikTree tree = new RubrikTree(rubriken, parentChilds);
		return new RubrikTreeModel(tree.createTree());
	}
}
