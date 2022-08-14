module com.example.uts_2072029_axelshirasapatanegara {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jasperreports;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;


    opens com.example.PT08_2072029 to javafx.fxml;
    exports com.example.PT08_2072029;
    exports com.example.PT08_2072029.controller;
    opens com.example.PT08_2072029.controller to javafx.fxml;
    exports com.example.PT08_2072029.model;
    opens com.example.PT08_2072029.model;
    exports com.example.PT08_2072029.dao;
    opens com.example.PT08_2072029.dao to javafx.fxml;
    exports com.example.PT08_2072029.util;
    opens com.example.PT08_2072029.util to javafx.fxml;
}