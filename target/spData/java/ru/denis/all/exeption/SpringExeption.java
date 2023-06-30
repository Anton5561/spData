package ru.denis.all.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class SpringExeption {

    @ExceptionHandler()
    public ResponseEntity<String> getEr(HttpServletRequest request, Exception e){
        System.out.println(e.getMessage());


        if (e.getClass().getSimpleName().equals("MissingServletRequestParameterException") ) {
            ResponseEntity<String> stringResponseEntity = new ResponseEntity("<h1>Erroor:404</h1>", HttpStatus.NOT_FOUND);
            return stringResponseEntity;
        }
        ResponseEntity<String> stringResponseEntity = new ResponseEntity("<h1> ERROR: " + e.getMessage() +"</h1>", HttpStatus.NOT_FOUND);
        System.out.println("11111111111111");
        return stringResponseEntity;


    }

}
