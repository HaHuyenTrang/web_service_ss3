package ra.ss1_stringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.ss1_stringboot.model.Student;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @GetMapping
    public String student(Model model) {
        List<Student> std = new ArrayList<>();
        Student std1 = new Student(1,"Chang", 20, "chang@gmail.com", 9);
        Student std2 = new Student(2,"Châu", 12, "chau@gmail.com", 8);
        Student std3 = new Student(3,"Quỳn", 20, "quyn@gmail.com", 10);
        Student std4 = new Student(4,"LAnh", 21, "lanh@gmail.com", 7);
        Student std5 = new Student(5,"Phanh", 19, "phanh@gmail.com", 9);

        std.add(std1);
        std.add(std2);
        std.add(std3);
        std.add(std4);
        std.add(std5);
        model.addAttribute("list", std);
        return "student";
    }
}
