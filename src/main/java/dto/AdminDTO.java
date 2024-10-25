package dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {
        private Integer AdminId;
        private String Mobile;
        private String Name;
        private String Address;
        private String Email;
        private String Password;
}
