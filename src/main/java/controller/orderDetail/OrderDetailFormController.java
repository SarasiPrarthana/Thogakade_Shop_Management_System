package controller.orderDetail;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.OrderDetailInfoDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderDetailFormController implements Initializable {

    OrderDetailService orderDetailService = new OrderDetailController();
    ObservableList<OrderDetailInfoDTO> orderDetailDTOS = FXCollections.observableArrayList();

    @FXML
    private TableColumn<?, ?> colDiscount;

    @FXML
    private TableColumn<?, ?> colOrderID;

    @FXML
    private TableColumn<?, ?> colOrderQty;

    @FXML
    private TableColumn<?, ?> colitemCode;

    @FXML
    private TextField txtDiscount;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtOrderID;

    @FXML
    private TextField txtOrderQty;

    @FXML
    private TableView<OrderDetailInfoDTO> txtTbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colOrderID.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        colitemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colOrderQty.setCellValueFactory(new PropertyValueFactory<>("orderQTY"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("discount"));

        loadOrderDetails();

        txtTbl.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){
                txtOrderID.setText(newValue.getOrderID());
                txtItemCode.setText(newValue.getItemCode());
                txtOrderQty.setText(String.valueOf(newValue.getOrderQTY()));
                txtDiscount.setText(String.valueOf(newValue.getDiscount()));
            }
        });

    }

    @FXML
    void btnAddAction(ActionEvent event) {

    }

    @FXML
    void btnClearAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateAction(ActionEvent event) {

    }

    private void loadOrderDetails() {

        orderDetailDTOS.clear();
        txtTbl.setItems(orderDetailService.loadOrderDetails());
    }
    public void clearFields(){
        txtOrderID.clear();
        txtItemCode.clear();
        txtOrderQty.clear();
        txtDiscount.clear();
    }
}
