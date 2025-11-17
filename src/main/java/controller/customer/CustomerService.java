package controller.customer;

import javafx.collections.ObservableList;
import model.dto.CustomerInfoDTO;

public interface CustomerService {

//    void addCustomerDetails(String customerID,String title,String name,String dob,double salary,String address,String city,String province,String postalCode);

    ObservableList<CustomerInfoDTO> loadCustomerDetails();
}
