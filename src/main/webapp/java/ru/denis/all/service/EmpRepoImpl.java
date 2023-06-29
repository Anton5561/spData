package ru.denis.all.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.denis.all.entity.Employees;
import ru.denis.all.repository.EmployeeRepository;

import java.util.List;

@Service
@Transactional
public class EmpRepoImpl {

    @Autowired
    public EmployeeRepository employeeRepository;


    public List<Employees> getAll(){

        //return employeeRepository.findAll();
        //return employeeRepository.findEmployeesByIdAfter(4);
        return employeeRepository.tttfinwdAllActiveUsers();

    }

    public void addNewEmployee(Employees employees){
        employeeRepository.save(employees);
    }

    public Employees findbyName(String s){
        return employeeRepository.findBySurname(s);
    }
}
