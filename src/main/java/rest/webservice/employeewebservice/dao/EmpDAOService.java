package rest.webservice.employeewebservice.dao;

import org.springframework.stereotype.Component;
import rest.webservice.employeewebservice.bean.Employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EmpDAOService {
    public static List<Employee> empList = new ArrayList<>();

    public static int userID = 2;

    public List<Employee> getAllUser(){
        Employee e1 = new Employee("vanathi", "32", 1);
        Employee e2 = new Employee( "karthik", "32", 2);
        empList.add(e1);
        empList.add(e2);
        return empList;
    }

    public Employee getEmp(int id){
        Employee employee = null;
        for(Employee e : empList){
            if(e.getId() == id){
                return employee = e;
            }
        }
        return employee;
    }

    public Employee deleteEmp(int id){
        Iterator<Employee> iterable = empList.iterator();
        while(null != iterable && iterable.hasNext()){
            Employee emp = iterable.next();
            if(emp != null && id == emp.getId()){
                iterable.remove();
                return emp;
            }
        }
        return null;



    }

    public Employee saveEmp(Employee emp){
        emp.setId(++userID);
        empList.add(emp);
        return emp;
    }
}
