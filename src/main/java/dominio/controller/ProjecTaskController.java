package dominio.controller;

import dominio.entities.ProjecTask;
import dominio.services.ProjecTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ProjectTask")
public class ProjecTaskController {

    @Autowired
    private ProjecTaskService service;

    @GetMapping
    public List<ProjecTask> findAll(){
        return service.findAll();
    }
    @PostMapping
    public ProjecTask create(@RequestBody ProjecTask projectask){
        return service.create(projectask);
    }
}
