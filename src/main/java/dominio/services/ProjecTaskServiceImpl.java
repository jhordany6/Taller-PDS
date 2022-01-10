package dominio.services;

import dominio.entities.ProjecTask;
import dominio.repository.ProjecTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjecTaskServiceImpl implements ProjecTaskService{

    @Autowired
    private ProjecTaskRepository repository;

    @Override
    public List<ProjecTask> findAll() {
        return repository.findAll();
    }

    @Override
    public ProjecTask create(ProjecTask projectask) {return repository.save(projectask);
    }
}
