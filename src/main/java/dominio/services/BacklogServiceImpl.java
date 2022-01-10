package dominio.services;

import dominio.entities.Backlog;
import dominio.repository.BacklogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BacklogServiceImpl implements BacklogService{

    private final BacklogRepository backlogRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createBacklog(Backlog backlog) {
        backlogRepository.save(backlog);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBacklog(Backlog backlog) {
        backlogRepository.delete(backlog);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Backlog> findAll() {
        return backlogRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Backlog findById(Long id) {
        return backlogRepository.findById(id).orElse(null);
    }


}

