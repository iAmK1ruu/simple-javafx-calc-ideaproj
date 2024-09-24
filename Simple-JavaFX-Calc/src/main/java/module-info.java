module com.kiruu.simplejavafxcalc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.kiruu.simplejavafxcalc to javafx.fxml;
    exports com.kiruu.simplejavafxcalc;
}