module com.diego.torresdehanoi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.diego.torresdehanoi to javafx.fxml;
    exports com.diego.torresdehanoi.Modelo.Entidades;
    opens com.diego.torresdehanoi.Modelo.Entidades to javafx.fxml;
    exports com.diego.torresdehanoi.Model;
    opens com.diego.torresdehanoi.Model to javafx.fxml;
    exports com.diego.torresdehanoi.Application;
    opens com.diego.torresdehanoi.Application to javafx.fxml;
    exports com.diego.torresdehanoi.Controler;
    opens com.diego.torresdehanoi.Controler to javafx.fxml;
}