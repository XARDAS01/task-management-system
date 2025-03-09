package org.example.repository;

import org.example.model.Employee;
import org.example.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    @Query("select employee.userInfo from Employee employee where employee.userInfo.username = :username")
    Optional<UserInfo> findUserByUsername(String username);

    @Query("select employee from Employee employee where employee.userInfo.username = :username")
    Optional<Employee> findEmployeeByUsername(String username);
}
