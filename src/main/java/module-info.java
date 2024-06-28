module com.example.udemytowordjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.apache.poi.ooxml;
    requires org.jsoup;
    requires org.seleniumhq.selenium.api;
    requires org.seleniumhq.selenium.chrome_driver;

    opens com.example.udemytowordjavafx to javafx.fxml;
    exports com.example.udemytowordjavafx;
    exports com.example.udemytowordjavafx.notused;
    opens com.example.udemytowordjavafx.notused to javafx.fxml;
}