package dominio.services;

import dominio.entities.ProjecTask;
import java.util.List;

public interface ProjecTaskService {

    List<ProjecTask> findAll();
    ProjecTask create(ProjecTask projectask);
}
