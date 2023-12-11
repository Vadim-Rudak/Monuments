package com.example.Monuments.repos;

import com.example.Monuments.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task,Long> {

//    @Query("Select * from task t LEFT JOIN element e on t.idelement = e.id")
//    List<Task> FindAllWithDescriptionQuery();

}
