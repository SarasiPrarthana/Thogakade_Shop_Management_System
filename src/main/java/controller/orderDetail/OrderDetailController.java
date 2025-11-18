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
}
