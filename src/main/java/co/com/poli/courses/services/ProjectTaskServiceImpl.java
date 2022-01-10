package co.com.poli.courses.services;

import co.com.poli.courses.entities.Project;
import co.com.poli.courses.entities.ProjectTask;
import co.com.poli.courses.repository.ProjectRepository;
import co.com.poli.courses.repository.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskServiceImpl implements ProjectTaskService{

    @Autowired
    private ProjectTaskRepository repository;

    @Override
    public ProjectTask create(ProjectTask projectTask) {
        return repository.save(projectTask);
    }
}
