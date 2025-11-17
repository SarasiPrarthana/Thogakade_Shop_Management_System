package controller.item;

import javafx.collections.ObservableList;
import model.dto.ItemInfoDTO;

public interface ItemService {

    ObservableList<ItemInfoDTO> loadItemDetails();
}
