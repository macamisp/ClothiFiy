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
        private String ID;
        private String Name;
        private String Size;
        private String Price;
        private String Stock;
}
