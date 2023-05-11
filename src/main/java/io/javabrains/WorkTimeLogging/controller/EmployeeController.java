package io.javabrains.WorkTimeLogging.controller;

import io.javabrains.WorkTimeLogging.model.Employee;
import io.javabrains.WorkTimeLogging.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository){
        this.repository= repository;
    }


    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/enter?id={id}")
    public void setEntryTime(@RequestBody Integer id){

        if(!repository.saveEnter(id)){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "ERROR, Consecutive Request appeared for the same id");
        }
    }


    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/exit?id={id}")
    public void setExitTime(@RequestBody Integer id){

        if(repository.saveExit(id)){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"ERROR, Exit Time Update failed" );
        }
    }


    @GetMapping("/info?id={id}")
    public Optional findById(@PathVariable Integer id){
        if(!repository.IdExists(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR, Employee Not Found");
        }
        return repository.infoById(id);
    }


    @GetMapping("/info")
    public List<Employee> findAll(){
        if(!repository.empty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR, No Employees Found");
        }
            return repository.findAll();
    }

}