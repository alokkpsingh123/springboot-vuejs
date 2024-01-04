package com.example.demoredis.feignclient;


import com.example.demoredis.dto.EmployeeDTO;
import com.example.demoredis.entity.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "Employee" , url = "http://localhost:8070/employee", fallbackFactory = EmployeeFallback.class)
public interface EmployeeFiegn {

    @RequestMapping(method = RequestMethod.GET,  value = "/findAll")
    List<EmployeeDTO> getAllViaPostgres();

    @RequestMapping(method = RequestMethod.POST)
    Employee insertEployeeViaPostgres(@RequestBody EmployeeDTO employeeDTO);
}
