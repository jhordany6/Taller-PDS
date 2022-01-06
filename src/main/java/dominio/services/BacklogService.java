package dominio.services;

import dominio.entities.Backlog;

import java.util.List;

public interface BacklogService {
    List<Backlog> findAll();
    Backlog create(Backlog backlog);
}
