package rest.webservice.employeewebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.webservice.employeewebservice.dao.EmpDAOService;

@RestController
public class VersioningEmpController {

        @Autowired
        public EmpDAOService empService;

        //URI Versioning
        @GetMapping(path = "/users/v1")
        public String getEmpV1(){
          return "Vanathi Nallsivam";
        }

        @GetMapping(path = "/users/v2")
        public String getEmpV2(){
            return "{fName: Vanathi, lName: Nallsivam}";
        }

        //Request Param versioning
        @GetMapping(path = "/users/param", params = "version=1")
        public String getEmpParamV1(){
            return "Vanathi Nallsivam";
        }

        @GetMapping(path = "/users/param", params="version=2")
        public String getEmpParamV2(){
            return "{fName: Vanathi, lName: Nallsivam}";
        }

    //Request Header versioning
    @GetMapping(path = "/users/header", headers = "API-VERSION=1")
    public String getEmpHeaderV1(){
        return "Vanathi Nallsivam";
    }

    //Key: API-VERSION value=2
    @GetMapping(path = "/users/header", headers="API-VERSION=2")
    public String getEmpHeaderV2(){
        return "{fName: Vanathi, lName: Nallsivam}";
    }

    //Request Header Accept versioning
    //Accept
    @GetMapping(path = "/users/produces", produces = "application/vnd.example.version1+json")
    public String getEmpProducerV1(){
        return "Vanathi Nallsivam";
    }

    @GetMapping(path = "/users/produces", produces = "application/vnd.example.version2+json")
    public String getEmpProducerV2(){
        return "{fName: Vanathi, lName: Nallsivam}";
    }

}
