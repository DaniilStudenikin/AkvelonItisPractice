package ru.itis.akvelonitispractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.akvelonitispractice.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
