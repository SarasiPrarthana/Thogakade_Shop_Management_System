package controller.order;

import db.DBConnection;
import javafx.collections.ObservableList;
import model.dto.ItemInfoDTO;
import model.dto.OrderInfoDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderController implements OrderService{

    @Override
    public ObservableList<OrderInfoDTO> loadOrderDetails() {
        ObservableList<OrderInfoDTO> orderDetails = javafx.collections.FXCollections.observableArrayList();

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = ("SELECT * FROM Orders" );
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                orderDetails.add(new OrderInfoDTO(

                                resultSet.getString("OrderID"),
                                resultSet.getString("OrderDate"),
                                resultSet.getString("CustID")
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderDetails;
    }

    @Override
    public void addOrderDetails(String orderID, String date, String customerID) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String SQL = "Insert INTO Orders VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setObject(1, orderID);
            preparedStatement.setObject(2, date);
            preparedStatement.setObject(3, customerID);

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteOrderDetails(String OrderID) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM Orders WHERE OrderID = ?");

            pstm.setObject(1, OrderID);
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateOrderDetails(String orderID, String date, String customerID) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String SQL = "UPDATE Orders SET CustID = ?, OrderDate = ? WHERE OrderID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setObject(1, customerID);
            preparedStatement.setObject(2, date);
            preparedStatement.setObject(3, orderID);

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
