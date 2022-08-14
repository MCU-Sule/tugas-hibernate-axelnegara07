package com.example.PT08_2072029.controller;


import com.example.PT08_2072029.dao.UserDao;
import com.example.PT08_2072029.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class SecondController {
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtPassword;
    private UserDao userDao = new UserDao();

    public void submit(ActionEvent actionEvent) {
        if (txtUserName.getText().isEmpty() || txtPassword.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Please fill the field", ButtonType.OK);
            alert.show();
        } else {
            User u = new User();
            u.setIdUser(0);
            u.setUserName(txtUserName.getText());
            u.setUserPassword(txtPassword.getText());
            userDao.addData(u);
            txtUserName.getScene().getWindow().hide();
        }
    }
}