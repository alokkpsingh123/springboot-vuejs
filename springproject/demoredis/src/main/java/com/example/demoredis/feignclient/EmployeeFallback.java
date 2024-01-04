package com.example.demoredis.feignclient;

import com.example.demoredis.dto.EmployeeDTO;
import com.example.demoredis.entity.Employee;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeFallback implements FallbackFactory<EmployeeFiegn> {
    @Override
    public EmployeeFiegn create(Throwable throwable) {
        return new EmployeeFiegn() {
            @Override
            public List<EmployeeDTO> getAllViaPostgres() {
                return null;
            }

            @Override
            public Employee insertEployeeViaPostgres(EmployeeDTO employeeDTO) {
                return null;
            }

        } ;
    }
}
