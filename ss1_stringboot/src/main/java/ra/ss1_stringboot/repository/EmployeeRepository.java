package ra.ss1_stringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ra.ss1_stringboot.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByPhoneNumber(String phoneNumber);
    @Query("SELECT e FROM Employee e WHERE e.salary > :salary")
    List<Employee> findEmployeeBySalary(@Param("salary") double salary);
}
