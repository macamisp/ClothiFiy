package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity (name = "customer")
public class Customer {
    @Id
    private String id;
    private String name;
    private String address;
    private String mobile;
    private String email;
}
