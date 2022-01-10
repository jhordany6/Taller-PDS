package co.com.poli.courses.controller;

import co.com.poli.courses.entities.Project;
import co.com.poli.courses.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService service;


    @PostMapping
    public Project create(@RequestBody Project project){
        return service.create(project);
    }
}
