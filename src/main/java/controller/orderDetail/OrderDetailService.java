package controller.orderDetail;

import javafx.collections.ObservableList;
import model.dto.OrderDetailInfoDTO;

public interface OrderDetailService {

    ObservableList<OrderDetailInfoDTO> loadOrderDetails();
}
