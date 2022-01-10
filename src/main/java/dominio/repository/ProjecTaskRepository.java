package dominio.repository;

import dominio.entities.ProjecTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjecTaskRepository extends JpaRepository<ProjecTask,Long> {
}
