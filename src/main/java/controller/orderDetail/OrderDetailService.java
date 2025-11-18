package controller.orderDetail;

import javafx.collections.ObservableList;
import model.dto.OrderDetailInfoDTO;

public interface OrderDetailService {

    ObservableList<OrderDetailInfoDTO> loadOrderDetails();

    void addOrderDetails(String orderID,String itemCode,int orderQTY,int discount);

    void deleteOrderDetails(String OrderID);

}
