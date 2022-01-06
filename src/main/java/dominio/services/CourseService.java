package dominio.services;

import dominio.entities.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    Course create(Course course);
}
