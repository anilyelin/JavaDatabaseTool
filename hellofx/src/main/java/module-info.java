module org.openjfx.hellofx {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	requires javafx.base;

    opens org.openjfx.hellofx to javafx.fxml;
    exports org.openjfx.hellofx;
}