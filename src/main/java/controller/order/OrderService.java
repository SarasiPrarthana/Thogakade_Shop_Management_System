package controller.order;

import javafx.collections.ObservableList;
import model.dto.ItemInfoDTO;
import model.dto.OrderInfoDTO;

public interface OrderService {

    ObservableList<OrderInfoDTO> loadOrderDetails();

    void addOrderDetails(String orderID,String date,String customerID);

//    void deleteItemDetails(String ItemCode);

}
