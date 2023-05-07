module com.ruddy {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

//    opens com.ruddy.game;
    exports com.ruddy.game;
    exports com.ruddy.view;
    opens com.ruddy.view to javafx.fxml;
}