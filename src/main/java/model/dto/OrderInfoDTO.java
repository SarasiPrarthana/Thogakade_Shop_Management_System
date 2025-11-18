package model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderInfoDTO {

    private String orderID;

    private String date;

    private String customerID;
}
