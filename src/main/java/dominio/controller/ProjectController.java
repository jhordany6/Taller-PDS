package dominio.controller;

import dominio.entities.Project;
import dominio.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Project")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @GetMapping
    public List<Project> findAll(){
        return service.findAll();
    }
    @PostMapping
    public Project create(@RequestBody Project project){
        return service.create(project);
    }
}
