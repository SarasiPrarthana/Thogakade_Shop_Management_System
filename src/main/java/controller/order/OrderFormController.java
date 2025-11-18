package controller.order;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.OrderInfoDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderFormController implements Initializable {

    OrderService orderService = new OrderController();
    ObservableList<OrderInfoDTO> orderInfoDTOS = FXCollections.observableArrayList();

    @FXML
    private TableColumn<?, ?> colCustID;

    @FXML
    private TableColumn<?, ?> colOrderDate;

    @FXML
    private TableColumn<?, ?> colOrderID;

    @FXML
    private TextField txtCustID;

    @FXML
    private TextField txtOrderDate;

    @FXML
    private TextField txtOrderID;

    @FXML
    private TableView<OrderInfoDTO> txtTbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colOrderID.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        colOrderDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colCustID.setCellValueFactory(new PropertyValueFactory<>("customerID"));

        loadOrderDetails();

        txtTbl.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){
                txtOrderID.setText(newValue.getOrderID());
                txtOrderDate.setText(newValue.getDate());
                txtCustID.setText(newValue.getCustomerID());
            }
        });
    }

    @FXML
    void btnAddAction(ActionEvent event) {

        String orderID = txtOrderID.getText();
        String date = txtOrderDate.getText();
        String customerID = txtCustID.getText();

        orderService.addOrderDetails(orderID,date,customerID);
        loadOrderDetails();
        clearFields();

    }

    @FXML
    void btnClearAction(ActionEvent event) {

        txtOrderID.setText("");
        txtOrderDate.setText("");
        txtCustID.setText("");

    }

    @FXML
    void btnDeleteAction(ActionEvent event) {

        orderService.deleteOrderDetails(txtOrderID.getText());
        clearFields();
        loadOrderDetails();
    }

    @FXML
    void btnUpdateAction(ActionEvent event) {

        String orderID = txtOrderID.getText();
        String date = txtOrderDate.getText();
        String customerID = txtCustID.getText();

        orderService.updateOrderDetails(orderID,date,customerID);
        loadOrderDetails();
        clearFields();

    }

    private void loadOrderDetails() {

        orderInfoDTOS.clear();
        txtTbl.setItems(orderService.loadOrderDetails());
    }
    public void clearFields(){
        txtOrderID.clear();
        txtOrderDate.clear();
        txtCustID.clear();
    }
}
