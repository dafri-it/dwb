package de.dafrit.dwb.rubrik;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/rubrik")
public class RubrikPublicController {

    private final RubrikPublicService rubrikPublicService;

    @Autowired
    public RubrikPublicController(RubrikPublicService rubrikPublicService) {
        this.rubrikPublicService = rubrikPublicService;
    }

    @GetMapping
    public List<RubrikEntity> getAll() {
        return rubrikPublicService.findAll();
    }
    
    @GetMapping("tree")
    public RubrikTreeModel getTree() {
    	return rubrikPublicService.getTree();
    }
}
