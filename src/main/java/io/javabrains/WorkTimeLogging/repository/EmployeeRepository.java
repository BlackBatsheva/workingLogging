
package io.javabrains.WorkTimeLogging.repository;

import io.javabrains.WorkTimeLogging.model.Employee;
import io.javabrains.WorkTimeLogging.model.TimeRecord;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepository<content> {

    private final List<Employee> employeeList = new ArrayList<>();
    public EmployeeRepository(){

    }

    @PostConstruct
    public boolean saveEnter(Integer id) {

        List<TimeRecord> timeRecords;
        Employee employee;
        TimeRecord time = new TimeRecord(
                LocalDateTime.now(),
                null
        );

        if (!IdExists(id)) {
            employee = new Employee(
                    id,
                    timeRecords = new ArrayList<>()
            );
            timeRecords.add(time);
            employeeList.add(employee);
        }
        else {
            employee = employeeList.stream().filter(e -> e.employee_id().equals(id)).findFirst().orElse(null);
            timeRecords= employee.employeeRecords();
            TimeRecord lastRecord=timeRecords.get(timeRecords.size() - 1);
            LocalDateTime lastExit = lastRecord.exitTime();
            if(lastExit==null||lastExit==LocalDateTime.now())
                return false;
            employee.employeeRecords().add(time);
        }
        return false;
    }


    public boolean saveExit(Integer id) {

        TimeRecord time;
        Employee employee= employeeList.stream().filter(e->e.employee_id().equals(id)).findFirst().orElse(null);
        if(employee==null)
            return false;
        List<TimeRecord> timeRecords= employee.employeeRecords();
        TimeRecord lastRecord=timeRecords.get(timeRecords.size() - 1);
        LocalDateTime lastEnter = lastRecord.enterTime();
        if(lastRecord.exitTime()!=null||lastEnter==LocalDateTime.now())
            return false;
        else {
            time = new TimeRecord(
                    lastEnter,
                    LocalDateTime.now()
            );
        }
        timeRecords.set(timeRecords.size() - 1,time);
        return true;
    }

    public boolean IdExists(Integer id) {

        return employeeList.stream().filter(c->c.employee_id().equals(id)).count()==1;
    }

    public Optional<Employee> infoById(Integer id) {
            return employeeList.stream().filter(c->c.employee_id().equals(id)).findFirst();
    }

    public boolean empty() {
        return employeeList.isEmpty();
    }

    public List<Employee> findAll() {
        return employeeList;
    }
}
