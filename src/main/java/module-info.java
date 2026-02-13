module com.diego.torresdehanoi {
    requires javafx.controls;
    requires javafx.fxml;


    exports com.diego.torresdehanoi.Application;
    exports com.diego.torresdehanoi.Controller;
    exports com.diego.torresdehanoi.Model;
    exports com.diego.torresdehanoi.utils;
    opens com.diego.torresdehanoi.Application to javafx.fxml;
    opens com.diego.torresdehanoi.Controller to javafx.fxml;
    opens com.diego.torresdehanoi.Model to javafx.fxml;
    opens com.diego.torresdehanoi.utils to javafx.fxml;
}