package controller.customer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.CustomerInfoDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {

    CustomerService customerService = new CustomerController();

    ObservableList<CustomerInfoDTO> customerInfoDTOS = FXCollections.observableArrayList();

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colDOB;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCustID;

    @FXML
    private TextField txtDOB;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private TextField txtProvince;

    @FXML
    private TextField txtSalary;

    @FXML
    private TableView<CustomerInfoDTO> txtTbl;

    @FXML
    private TextField txtTitle;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        colID.setCellValueFactory(new PropertyValueFactory<>("title"));
        colID.setCellValueFactory(new PropertyValueFactory<>("name"));
        colID.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colID.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colID.setCellValueFactory(new PropertyValueFactory<>("address"));
        colID.setCellValueFactory(new PropertyValueFactory<>("city"));
        colID.setCellValueFactory(new PropertyValueFactory<>("province"));
        colID.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        loadCustomerDetails();

        txtTbl.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {

            if (newValue != null) {
                txtCustID.setText(newValue.getCustomerID());
                txtTitle.setText(newValue.getTitle());
                txtName.setText(newValue.getName());
                txtDOB.setText(newValue.getDob());
                txtSalary.setText(String.valueOf(newValue.getSalary()));
                txtAddress.setText(newValue.getAddress());
                txtCity.setText(newValue.getCity());
                txtProvince.setText(newValue.getProvince());
                txtPostalCode.setText(newValue.getPostalCode());

            }
        });

    }
}
