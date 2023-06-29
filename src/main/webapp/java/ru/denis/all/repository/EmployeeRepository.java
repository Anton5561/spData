package ru.denis.all.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.denis.all.entity.Employees;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer> {
    Employees findBySurname(String s);

    //@Transactional
    @Query("select p from Employees p where p.id> 4")
    List<Employees> tttfinwdAllActiveUsers();
    List<Employees> findEmployeesByIdAfter(Integer id);
}
