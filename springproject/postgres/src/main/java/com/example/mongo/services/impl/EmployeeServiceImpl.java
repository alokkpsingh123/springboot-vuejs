package com.example.mongo.services.impl;

import com.example.mongo.dto.EmployeeDto;
import com.example.mongo.entity.BankAccount;
import com.example.mongo.entity.Company;
import com.example.mongo.entity.Employee;
import com.example.mongo.repository.EmployeeRepository;
import com.example.mongo.services.BankAccountService;
import com.example.mongo.services.ComanyService;
import com.example.mongo.services.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;


@Service
public class EmployeeServiceImpl  implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private ComanyService comanyService;



    @Transactional
    @Override
    public Employee save(EmployeeDto employeeDto) {
        Optional<BankAccount> bankAccount = bankAccountService.findOne(employeeDto.getBankAccountId());
        Optional<Company> company = comanyService.findOne(employeeDto.getCompanyId());
        if (!company.isPresent() || !bankAccount.isPresent()) {
            return null;
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employee.setBankAccount(bankAccount.get());
        employee.setCompany(company.get());
        Employee response = employeeRepository.save(employee);
//        if (employee != null) {
//            throw new RuntimeException();
//        }
        return response;
    }

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findOne(String employeeId) {
        return employeeRepository.findById(employeeId);
    }

//    @Override
//    public Optional<Employee> updateFirstNameByEmpId(String fname, String employeeId) {
//        return employeeRepository.updateByEmpId(fname,employeeId);
//    }


//    @Override
//    public Employee addEmployee(Employee employee) {
//        return employeeRepository.save(employee);
//
//    }
//
//    @Override
//    public Iterable<Employee> getAll() {
//        Iterable<Employee> employeeList = employeeRepository.findAll();
//        return employeeList;
//    }
//
//    @Override
//    public boolean clearAll() {
//        employeeRepository.deleteAll();
//        return true;
//    }
//
//    @Override
//    public Employee get(String employeeId) {
//
//        Optional<Employee> employeeOptional= employeeRepository.findById(employeeId);
//        return employeeOptional.isPresent() ? employeeOptional.get() : null;
//    }
//
//    @Override
//    public boolean deleteById(String employeeId) {
//        employeeRepository.deleteById(employeeId);
//        return true;
//    }
//
//    @Override
//    public boolean isEmployeeExist(String employeeId) {
//        return employeeRepository.existsById(employeeId);
//    }

//    @Override
//    public List<Employee> fetchByFnameAndLname(String firstName, String lastName) {
//        return employeeRepository.findByFirstNameAndLastName(firstName, lastName);
//    }
//
//    @Override
//    public List<Employee> fetchEmployeesByFistName(String name) {
//        return employeeRepository.fetchEmployeesByFistName(name);
//    }
//
//    @Override
//    public List<Employee> fetchEmployeesByFirstNameSortByDob(String name) {
//        return employeeRepository.fetchEmployeesByFirstNameSortByDob(name);
//    }
//
//    @Override
//    public List<Employee> findAllUsingTemplate(String firstName) {
//        return employeeCustomRepository.findAllUsingTemplate(firstName);
//    }
//
//    @Override
//    public List<Employee> isActive() {
//        return employeeCustomRepository.isActive();
//    }
//
//    @Override
//    public Employee findOneEmployee(String lastName) {
//        return employeeCustomRepository.findOneEmployee(lastName);
//    }
//
//    @Override
//    public List<Employee> displayOnlyFirsName() {
//        return employeeCustomRepository.displayOnlyFirsName();
//    }
//
//    @Override
//    public UpdateResult updateDepartmentById(String employeeId) {
//        return employeeCustomRepository.updateDepartmentById(employeeId);
//    }


}
