package controller.customer;

import db.DBConnection;
import javafx.collections.ObservableList;
import model.dto.CustomerInfoDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerController implements CustomerService{

    @Override
    public ObservableList<CustomerInfoDTO> loadCustomerDetails() {

        ObservableList<CustomerInfoDTO> customerDetails = javafx.collections.FXCollections.observableArrayList();

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = ("SELECT * FROM Customer");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customerDetails.add(new CustomerInfoDTO(

                                resultSet.getString("CustID"),
                                resultSet.getString("CustTitle"),
                                resultSet.getString("CustName"),
                                resultSet.getString("DOB"),
                                resultSet.getDouble("salary"),
                                resultSet.getString("CustAddress"),
                                resultSet.getString("City"),
                                resultSet.getString("Province"),
                                resultSet.getString("PostalCode")
                        )
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerDetails;
    }

    public void addCustomerDetails(String customerID, String title, String name, String dob, double salary, String address, String city, String province, String postalCode) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String SQL = "Insert INTO Customer VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setObject(1, customerID);
            preparedStatement.setObject(2, title);
            preparedStatement.setObject(3, name);
            preparedStatement.setObject(4, dob);
            preparedStatement.setObject(5, salary);
            preparedStatement.setObject(6, address);
            preparedStatement.setObject(7, city);
            preparedStatement.setObject(8, province);
            preparedStatement.setObject(9, postalCode);

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
