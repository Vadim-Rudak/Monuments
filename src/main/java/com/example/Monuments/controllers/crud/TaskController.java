package com.example.Monuments.controllers.crud;

import com.example.Monuments.domain.Task;
import com.example.Monuments.repos.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Controller
public class TaskController {

    @Autowired
    private TaskRepo taskRepo;

    @PostMapping("/add_task")
    public String addTask(@RequestParam(name="id_element", required=false, defaultValue=" ") int id_element,
                          @RequestParam(name="phone_number", required=false) String phone_number,
                          @RequestParam(name="all_name", required=false) String all_name,
                          @RequestParam(name="more_info", required=false) String more_info) throws IOException {

        Task task = new Task();
        task.setIdelement(id_element);
        task.setPhone_number(phone_number);
        task.setAll_name(all_name);
        task.setMore_info(more_info);

        LocalDate date  = LocalDate.now();
        String dateFormat = date.getDayOfMonth() + "." + date.getMonthValue() + "." + date.getYear();

        task.setDate_create(dateFormat);
        task.setLast_status_update(dateFormat);

        taskRepo.save(task);

        return "ok";
    }

    @PostMapping("/update_status_task")
    public ResponseEntity<?> updateStatusTask(@RequestParam(name="id", required=false, defaultValue=" ") int id,
                                              @RequestParam(name="num_status", required=false, defaultValue=" ") int num_status){
        Task task = taskRepo.getById((long) id);
        if (num_status==2){
            task.setStatus_see(true);
        }
        if (num_status==3){
            task.setStatus_done(true);
        }
        LocalDate date  = LocalDate.now();
        String dateFormat = date.getDayOfMonth() + "." + date.getMonthValue() + "." + date.getYear();
        task.setLast_status_update(dateFormat);

        taskRepo.save(task);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/update_task")
    public ResponseEntity<?> updateTask(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/delete_task")
    public ResponseEntity<?> deleteTask(@RequestParam(name="id", required=false, defaultValue=" ") int id){
        taskRepo.deleteById((long) id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
