package dominio.services;

import dominio.entities.Backlog;

import java.util.List;

public interface BacklogService {

    void createBacklog(Backlog backlog);
    void deleteBacklog(Backlog backlog);
    Backlog findById(Long id);
    //Backlog findByNumberBacklog(String numberBacklog);
    List<Backlog> findAll();

}
