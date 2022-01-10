package co.com.poli.courses.controller;

import co.com.poli.courses.entities.Project;
import co.com.poli.courses.entities.ProjectTask;
import co.com.poli.courses.services.ProjectService;
import co.com.poli.courses.services.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projectTask")
public class ProjectTaskController {

    @Autowired
    private ProjectTaskService service;


    @PostMapping
    public ProjectTask create(@RequestBody ProjectTask projectTask){
        return service.create(projectTask);
    }
}
