package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    private Integer EmployeeId;
    private String Mobile;
    private String Name;
    private String Address;
    private String Email;
}
