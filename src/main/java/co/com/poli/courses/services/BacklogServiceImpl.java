package co.com.poli.courses.services;

import co.com.poli.courses.entities.Backlog;
import co.com.poli.courses.repository.BacklogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BacklogServiceImpl implements BacklogService{

    @Autowired
    private BacklogRepository repository;

    @Override
    public List<Backlog> findAll() {
        return repository.findAll();
    }

    @Override
    public void create(Backlog backlog) {
         repository.save(backlog);
    }


}
