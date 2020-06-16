package rest.webservice.employeewebservice.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rest.webservice.employeewebservice.bean.Employee;
import rest.webservice.employeewebservice.dao.EmpDAOService;
import rest.webservice.employeewebservice.exception.UserNotFoundException;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class EmpController {

    @Autowired
    public EmpDAOService empService;

    @Autowired
    private MessageSource messageSource; //variable name should be messageSource

    @GetMapping(path = "/employees")
    public MappingJacksonValue getAllEmp(){

        List<Employee> l = empService.getAllUser();

        //Dynamic filtering
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("age");

        FilterProvider filters = new SimpleFilterProvider().addFilter("dynamicFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(l);
        mapping.setFilters(filters);

       return mapping;
    }

    @GetMapping(path = "/employees/{id}")
    public Employee getEmpById(@PathVariable int id){
        Employee emp = empService.getEmp(id);
        if(null == emp){
            throw new UserNotFoundException("ID - "+ id);
        }
        return empService.getEmp(id);
    }

    @PostMapping(path = "/employees")
    public ResponseEntity<Employee> saveEmp(@Valid @RequestBody Employee emp){
        empService.saveEmp(emp);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(emp.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/employees/{id}")
    public Employee deleteEmployee(@PathVariable int id){
        Employee emp = empService.deleteEmp(id);
        if(null == emp){
            throw new UserNotFoundException("ID - "+ id);
        }
        return emp;
    }

    @GetMapping(path="/i18")
    public String getInternationalized(){
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }

}
