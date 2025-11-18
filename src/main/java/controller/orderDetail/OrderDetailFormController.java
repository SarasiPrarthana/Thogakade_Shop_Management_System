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

        String orderID = txtOrderID.getText();
        String itemCode = txtItemCode.getText();
        int orderQTY = Integer.parseInt(txtOrderQty.getText());
        int discount = Integer.parseInt(txtDiscount.getText());

        orderDetailService.addOrderDetails(orderID,itemCode,orderQTY,discount);
        loadOrderDetails();
        clearFields();
    }

    @FXML
    void btnClearAction(ActionEvent event) {

        txtOrderID.setText("");
        txtItemCode.setText("");
        txtOrderQty.setText("");
        txtDiscount.setText("");
    }

    @FXML
    void btnDeleteAction(ActionEvent event) {

        orderDetailService.deleteOrderDetails(txtOrderID.getText());
        clearFields();
        loadOrderDetails();
    }

    @FXML
    void btnUpdateAction(ActionEvent event) {

        String orderID = txtOrderID.getText();
        String itemCode = txtItemCode.getText();
        int orderQTY = Integer.parseInt(txtOrderQty.getText());
        int discount = Integer.parseInt(txtDiscount.getText());

        orderDetailService.updateOrderDetails(orderID,itemCode,orderQTY,discount);
        loadOrderDetails();
        clearFields();

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
