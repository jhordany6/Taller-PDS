package co.com.poli.courses.services;

import co.com.poli.courses.entities.Backlog;
import java.util.List;

public interface BacklogService {
    List<Backlog> findAll();
    Backlog create(Backlog backlog);

}
