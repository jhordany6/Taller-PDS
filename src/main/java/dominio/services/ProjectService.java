package dominio.services;

import dominio.entities.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findAll();
    Project create(Project project);
}
