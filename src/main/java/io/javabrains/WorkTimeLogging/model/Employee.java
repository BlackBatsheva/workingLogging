package io.javabrains.WorkTimeLogging.model;

import java.util.List;

public record Employee(
        Integer employee_id,
        List<TimeRecord> employeeRecords
    )


    {

    }