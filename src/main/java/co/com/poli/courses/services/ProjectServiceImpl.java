package co.com.poli.courses.services;

import co.com.poli.courses.entities.Instructor;
import co.com.poli.courses.entities.Project;
import co.com.poli.courses.repository.InstructorRepository;
import co.com.poli.courses.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository repository;

    @Override
    public Project create(Project project) {
        return repository.save(project);
    }
}
