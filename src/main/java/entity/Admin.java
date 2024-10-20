package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Admin {
    private Integer AdminId;
    private String Mobile;
    private String Name;
    private String Address;
    private String Email;
   private String Password;
}
