package com.imet_bot.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("from Employee p where p.contingent = 'бакалавриат'")
    List<Employee> employeeByContingentBachelor();

    @Query("from Employee p where p.contingent = 'магистратура'")
    List<Employee> employeeByContingentMaster();
}
