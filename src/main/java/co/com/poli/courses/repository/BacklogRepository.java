package co.com.poli.courses.repository;

import co.com.poli.courses.entities.Backlog;
import co.com.poli.courses.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogRepository extends JpaRepository<Backlog,Long> {
}
