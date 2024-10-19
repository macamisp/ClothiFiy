package entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    private String customerName;
    private String orderId;
    private String date;
    private String time;
    private String subTotal;
    private double totalDiscount;
    private double total;

}
