package co.com.poli.courses.controller;

import co.com.poli.courses.entities.Backlog;
import co.com.poli.courses.services.BacklogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/backlog")
public class BacklogController {

    @Autowired
    private BacklogService service;

    @GetMapping
    public List<Backlog> findAll(){
        return service.findAll();
    }
    @PostMapping
    public Backlog create(@RequestBody Backlog backlog){
        return service.create(backlog);
    }
}
