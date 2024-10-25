package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {
        private Integer ItemID;
        private String Name;
        private String Size;
        private  Integer Price;
        private String Stock;
}
