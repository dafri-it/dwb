package de.dafrit.dwb.thema;

import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/thema")
public class ThemaPublicController {

	private final ThemaPublicService themaPublicService;

	public ThemaPublicController(ThemaPublicService themaPublicService) {
		this.themaPublicService = themaPublicService;
	}

	@GetMapping
	public ThemaOverviewModel getAll() {
		return themaPublicService.findAll();
	}
	
	@GetMapping("/rubrik/{rubrikId}")
	public HttpEntity<ThemaListModel> getByRubrikId(@PathVariable Long rubrikId) {
		Optional<ThemaListModel> rubrikThemen = themaPublicService.getByRubrikId(rubrikId);
		
		if (rubrikThemen.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(rubrikThemen.get(), HttpStatus.OK);
	}
	
	@GetMapping("/{themaId}")
	public HttpEntity<ThemaDetailsModel> getDetails(@PathVariable Long themaId) {
		Optional<ThemaDetailsModel> details = themaPublicService.getDetails(themaId);
		
		if (details.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(details.get(), HttpStatus.OK);
	}
}
