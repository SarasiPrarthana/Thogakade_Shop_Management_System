package model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemInfoDTO {

    private String itemCode;

    private String description;

    private String packSize;

    private double unitPrice;

    private int qtyOnHand;
}
