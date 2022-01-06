package dominio.services;

import dominio.entities.Backlog;
import dominio.repository.BacklogRepository;
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
    public Backlog create(Backlog backlog) { return repository.save(backlog);
    }
}
