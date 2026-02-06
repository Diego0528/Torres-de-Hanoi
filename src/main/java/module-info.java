module com.diego.torresdehanoi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.diego.torresdehanoi to javafx.fxml;
    exports com.diego.torresdehanoi;
}