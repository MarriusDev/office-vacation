module com.example.PaycheckCalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.VacationOffice to javafx.fxml;
    exports com.example.VacationOffice;
}