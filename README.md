# Work-Time-Logging-Task


<b>Introduction:</b><br/>
Implement a work logging web back end. This assignment deals with simple enter/exit hours to work everyday.

<br/>
 <b>Project's technologies:<br/></b>
•	Java 17 <br/>
•	Maven 3.0.6 <br/>
•	Spring Boot, Spring web <br/>
•	Maven<br/>

<br/>
<b>To run the application: :</b><br/>
  Run LoggingApplication <br/>
 <br/>
<b>Employee controller implements api :</b>

1.	setEntryTime
      <br/><b> Post:</b> http://localhost:8080/api/content/enter?id=
      <br/><b> Body:</b> {id} 
      <br/><b>  Response :</b>
 ```{  "approved": 200,
       "errors": 500, ERROR, Consecutive Request appeared for the same id}
``````
2. setExitTime
      <br/><b> Post:</b> http://localhost:8080/api/content/exit?id=
      <br/><b> Body:</b> {id}
      <br/><b>  Response :</b>
 ```{  "approved": 200,
       "errors": 500, ERROR, Exit Time Update failed}
``````
3. findById
      <br/> <b> Get:</b> http://localhost:8080/api/content/info?id=
      <br/><b> Response: (using masked data service) </b>
  ```
    {
        ‘employee_id’: 1,
        ‘dates’: [
            [’01-01-2023-09:00’, ‘01-01-2023-10:00’],
            [’01-02-2023-10:30’, ‘01-02-2023-21:00’],
            [’02-02-2023-08:01’, ‘02-02-2023-18:46’],
            [’03-03-2023-09:00’] # Only enter time was received
        ]
    }
```
3. findAll
   <br/> <b> Get:</b> http://localhost:8080/api/content/info
   <br/><b> Response: (using masked data service) </b>
  ```
    {
        {
            ‘employee_id’: 1,
            ‘dates’: [
                [’01-01-2023-09:00’, ‘01-01-2023-10:00’],
                [’01-02-2023-10:30’, ‘01-02-2023-21:00’],
                [’02-02-2023-08:01’, ‘02-02-2023-18:46’],
                [’03-03-2023-09:00’] # Only enter time was received
            ]
        },
        {
            ‘employee_id’: 2,
            ‘dates’: [
                [’01-05-2023-09:00’, ‘01-05-2023-10:00’],
                [’02-05-2023-10:30’, ‘02-05-2023-21:00’],
            ]
        }
    }               
```



