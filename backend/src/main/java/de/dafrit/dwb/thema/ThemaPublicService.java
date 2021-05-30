package de.dafrit.dwb.thema;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import de.dafrit.dwb.rubrik.RubrikRepository;
import de.dafrit.dwb.termin.TerminEntity;
import de.dafrit.dwb.termin.TerminRepository;

@Service
public class ThemaPublicService {

	private final ThemaRepository themaRepository;

	private final RubrikRepository rubrikRepository;
	
	private final TerminRepository terminRepository;

	@Autowired
	public ThemaPublicService(ThemaRepository themaRepository, RubrikRepository rubrikRepository, TerminRepository terminRepository) {
		super();
		this.themaRepository = themaRepository;
		this.rubrikRepository = rubrikRepository;
		this.terminRepository = terminRepository;
	}

	@Cacheable("themen_overview")
	public ThemaOverviewModel findAll() {
		List<ThemaEntity> themen = themaRepository.findAllMinimized();

		List<ThemaOverviewEntryModel> entries = themen.stream()
				.map(thema -> new ThemaOverviewEntryModel(thema))
				.collect(Collectors.toList());

		return new ThemaOverviewModel(entries);
	}

	@Cacheable("themen")
	public Optional<ThemaListModel> getByRubrikId(Long rubrikId) {
		boolean existsById = rubrikRepository.existsById(rubrikId);
		if (!existsById) {
			return Optional.empty();
		}

		List<ThemaEntity> themen = themaRepository.findByRubrikId(rubrikId);
		List<TerminEntity> allTermine = terminRepository.findAllWithThemaRef();
		
		List<ThemaListEntryModel> entries = themen.stream()
				.map(thema -> createListModel(thema, findTermineByThemaId(thema.getId(), allTermine)))
				.collect(Collectors.toList());

		return Optional.of(new ThemaListModel(rubrikId, entries));
	}

	private ThemaListEntryModel createListModel(ThemaEntity entity, List<TerminEntity> termine) {
		return new ThemaListEntryModel(entity, termine);
	}
	
	private List<TerminEntity> findTermineByThemaId(Long themaId, List<TerminEntity> allTermine) {
		return allTermine.stream().filter(t -> t.hasThemaId(themaId)).collect(Collectors.toList());
	}

	public Optional<ThemaDetailsModel> getDetails(Long themaId) {
		Optional<ThemaEntity> details = themaRepository.findById(themaId);
		return details.map(thema -> new ThemaDetailsModel(thema, terminRepository.findByThemaId(thema.getId())));
	}
}
