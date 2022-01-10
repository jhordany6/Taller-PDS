package dominio.controller;

import dominio.entities.Backlog;
import dominio.helper.ResponseBuilder;
import dominio.model.Response;
import dominio.services.BacklogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/backlog")
@RequiredArgsConstructor
public class BacklogController {

    private final BacklogService backlogService;
    private final ResponseBuilder builder;

    /*
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
*/
    @PostMapping
    public Response create(@RequestBody Backlog backlog){
    backlogService.createBacklog(backlog);
    return builder.success(backlog);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
        Backlog backlog = backlogService.findById(id);
        if(backlog==null){
            return builder.failed(backlog);
        }
        backlogService.deleteBacklog(backlog);
        return builder.success(backlog);

    }

    @GetMapping
    public Response findAll(){
    List<Backlog> backlogs = backlogService.findAll();
    if (backlogs==null){
        return builder.failed("Not foud backlog");
    }
        return builder.success("Backlog is empty");
    }


    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        Backlog backlog = backlogService.findById(id);
        if(backlog==null){
            return builder.failed("Not found backlog");
        }
        return builder.success(backlog);
    }

}
