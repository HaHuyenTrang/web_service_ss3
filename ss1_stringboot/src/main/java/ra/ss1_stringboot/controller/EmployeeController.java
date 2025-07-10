package ra.ss1_stringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.ss1_stringboot.entity.Employee;
import ra.ss1_stringboot.repository.EmployeeRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Dữ liệu mẫu (dùng cho tìm theo số điện thoại)
    private List<Employee> getSampleEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "CCC", "a@gmail.com", "0123456789", 7400.0, LocalDateTime.now()));
        employees.add(new Employee(2, "AAAA", "b@gmail.com", "8765432789", 9800.0, LocalDateTime.now()));
        employees.add(new Employee(3, "RRRRR", "c@gmail.com", "12345678", 7200.0, LocalDateTime.now()));
        employees.add(new Employee(4, "DDDDDD", "d@gmail.com", "87654321", 3450.0, LocalDateTime.now()));
        employees.add(new Employee(5, "EEEEEEE", "e@gmail.com", "987645678", 4560.0, LocalDateTime.now()));
        return employees;
    }

    // Hiển thị form tìm theo số điện thoại (và danh sách mẫu ban đầu)
    @GetMapping("/find")
    public String findEmployeeForm(Model model) {
        model.addAttribute("list", getSampleEmployees());
        return "find-employee";
    }

    // Xử lý tìm theo số điện thoại (dùng dữ liệu mẫu)
    @PostMapping("/find")
    public String findEmployeeByPhone(@RequestParam("phone") String phone, Model model) {
        List<Employee> result = getSampleEmployees().stream()
                .filter(e -> e.getPhoneNumber().contains(phone))
                .collect(Collectors.toList());
        model.addAttribute("list", result);
        return "find-employee";
    }

    // Hiển thị form tìm theo lương
    @GetMapping("/salary")
    public String findBySalaryForm() {
        return "find-employee";
    }

    // Xử lý tìm theo mức lương (dùng dữ liệu trong database thông qua @Query)
    @PostMapping("/salary")
    public String findBySalary(@RequestParam("salary") double salary, Model model) {
        List<Employee> employees = employeeRepository.findEmployeeBySalary(salary);
        model.addAttribute("list", employees);
        return "find-employee";
    }

}
