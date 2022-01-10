package co.com.poli.courses.controller;

import co.com.poli.courses.entities.Backlog;
import co.com.poli.courses.helper.ResponseBuilder;
import co.com.poli.courses.model.Response;
import co.com.poli.courses.services.BacklogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/backlog")
@RequiredArgsConstructor
public class BacklogController {

   // @Autowired
    private final BacklogService service;
    private final ResponseBuilder builder;

    @GetMapping
    public List<Backlog> findAll(){
        return service.findAll();
    }

    /*
      @PostMapping
    public Backlog create(@RequestBody Backlog backlog){
        return service.create(backlog);
    }
     */
    @PostMapping
    public Response create(@Valid @RequestBody Backlog backlog, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        service.create(backlog);
        return builder.success(backlog);

    }

    private  List<Map<String,String>> formatMessage(BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String,String> error = new HashMap<>();
                    error.put(err.getField(),err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());
        return errors;
    }
}
