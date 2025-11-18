package controller.orderDetail;

import db.DBConnection;
import javafx.collections.ObservableList;
import model.dto.ItemInfoDTO;
import model.dto.OrderDetailInfoDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailController implements OrderDetailService{

    @Override
    public ObservableList<OrderDetailInfoDTO> loadOrderDetails() {

        ObservableList<OrderDetailInfoDTO> itemDetails = javafx.collections.FXCollections.observableArrayList();

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = ("SELECT * FROM OrderDetail" );
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                itemDetails.add(new OrderDetailInfoDTO(

                                // column name pass
                                resultSet.getString("OrderID"),
                                resultSet.getString("ItemCode"),
                                resultSet.getInt("OrderQTY"),
                                resultSet.getInt("Discount")
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemDetails;
    }

    @Override
    public void addOrderDetails(String orderID, String itemCode, int orderQTY, int discount) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String SQL = "Insert INTO OrderDetail VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setObject(1, orderID);
            preparedStatement.setObject(2, itemCode);
            preparedStatement.setObject(3, orderQTY);
            preparedStatement.setObject(4, discount);

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteOrderDetails(String OrderID) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM OrderDetail WHERE OrderID = ?");

            pstm.setObject(1, OrderID);
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateOrderDetails(String orderID, String itemCode, int orderQTY, int discount) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String SQL = "UPDATE OrderDetail SET OrderQTY = ?,Discount = ? WHERE OrderID = ? AND ItemCode = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setObject(1, itemCode);
            preparedStatement.setObject(2, orderQTY);
            preparedStatement.setObject(3, discount);
            preparedStatement.setObject(4, orderID);

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
