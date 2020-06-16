package rest.webservice.employeewebservice.bean;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@ApiModel(value = "Info about Employee")
// Static filtering :: @JsonIgnoreProperties(value = "age")
//Dynamic filtering
@JsonFilter("dynamicFilter")
@Entity
public class Employee {

    @ApiModelProperty(value = "Name length should be greater than 2")
    private @NotNull @Size(min = 2, message = "Name length should be more than 2 character") String name;
    private @NotNull String age;
    @Id
    @GeneratedValue
    private int id;

}
