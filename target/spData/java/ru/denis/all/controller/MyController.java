package ru.denis.all.controller;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.denis.all.entity.Employees;
import ru.denis.all.service.EmpRepoImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    EmpRepoImpl empRepo ;

    @RequestMapping(value = "/test", method = {RequestMethod.GET,RequestMethod.POST})
    public String getTest(){
        return "TEST TEST TEST";
    }
//    @GetMapping("/login")
//    public String getLog(){
//        System.out.println("LOOOOOOGIN");
//
//        return "/login";
//    }

    @GetMapping("/all")
    public List<Employees> getAllEmp(HttpServletResponse httpServletResponse, HttpServletRequest request, Principal principal ) {

        System.out.println(principal.getName());

        Cookie cookie = new Cookie("denis", "puchkov");
        cookie.setMaxAge(24*60*60);
        httpServletResponse.addCookie(cookie);
        httpServletResponse.addHeader("stiven", "king");
        System.out.println("88888888888888888888888888888888");

        HttpSession session = request.getSession();
        Integer count  = (Integer) session.getAttribute("count");
if (count == null){
    session.setAttribute("count", 1);
    count = 1;
}
else
    session.setAttribute("count", count + 1);

        System.out.println("COUNT " + count);





        return empRepo.getAll();

    }

    @GetMapping("/find")
    public Employees getAllEmp(@RequestParam("name") String t ) {
        return empRepo.findbyName(t);
    }


    @GetMapping("/create")
    public String set() {
        Employees employees = new Employees();
        //employees.setId(3);
        employees.setName("Rip");
        employees.setSurname("Torn");
        employees.setSalary(55000);
        employees.setDepartment("Actor");
        empRepo.addNewEmployee(employees);
        return "Added succesfilly";

    }

    @GetMapping("/error")
    public String getEr() {
        return "ERROR Authorization";
    }

}
