package model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetailInfoDTO {

    private String orderID;

    private String itemCode;

    private int orderQTY;

    private int discount;

}
