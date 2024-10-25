package dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SuplierDTO {
    private String SuplierId;
    private String Mobile;
    private String Name;
    private String Address;
    private String Email;
}
