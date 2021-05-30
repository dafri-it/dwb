package de.dafrit.dwb.termin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/termin")
public class TerminPublicController {

	private final TerminPublicService terminPublicService;

	@Autowired
	public TerminPublicController(TerminPublicService terminPublicService) {
		this.terminPublicService = terminPublicService;
	}
	
	@GetMapping("/thema/{themaId}")
	public HttpEntity<TerminListModel> getTermineByThema(@PathVariable Long themaId) {
		Optional<TerminListModel> list = terminPublicService.findTermineByThemaId(themaId);
		if (list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(list.get(), HttpStatus.OK);
	}
}
