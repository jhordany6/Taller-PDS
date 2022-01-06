package dominio.services;

import dominio.entities.Instructor;

import java.util.List;

public interface InstructorService {

    List<Instructor> findAll();
    Instructor create(Instructor instructor);
}
