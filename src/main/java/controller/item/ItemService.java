package controller.item;

import javafx.collections.ObservableList;
import model.dto.ItemInfoDTO;

public interface ItemService {

    ObservableList<ItemInfoDTO> loadItemDetails();

    void addItemDetails(String itemCode,String description,String packSize,double unitPrice,int qtyOnHand);

    void deleteItemDetails(String ItemCode);

    void updateItemDetails(String itemCode,String description,String packSize,double unitPrice,int qtyOnHand);

}
