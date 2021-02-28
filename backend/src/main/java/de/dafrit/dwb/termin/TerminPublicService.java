package de.dafrit.dwb.termin;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.dafrit.dwb.thema.ThemaRepository;

@Service
public class TerminPublicService {

	private final TerminRepository terminRepository;

	private final ThemaRepository themaRepository;

	@Autowired
	public TerminPublicService(TerminRepository terminRepository, ThemaRepository themaRepository) {
		super();
		this.terminRepository = terminRepository;
		this.themaRepository = themaRepository;
	}

	public Optional<TerminListModel> findTermineByThemaId(Long themaId) {
		if (!themaRepository.existsById(themaId)) {
			return Optional.empty();
		}

		List<TerminModel> termine = terminRepository.findByThemaId(themaId)
				.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
		
		return Optional.of(new TerminListModel(themaId, termine));
	}

	private TerminModel toModel(TerminEntity entity) {
		return new TerminModel(entity.getId(), entity.getNr(), entity.getVon(), entity.getBis(), entity.getOrt());
	}

}
