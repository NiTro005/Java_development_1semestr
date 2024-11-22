module org.example.visualjavadevelopment {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens org.example.visualjavadevelopment to javafx.fxml;
    exports org.example.visualjavadevelopment;
    exports org.example.visualjavadevelopment.Instructions;
    opens org.example.visualjavadevelopment.Instructions to javafx.fxml;
}