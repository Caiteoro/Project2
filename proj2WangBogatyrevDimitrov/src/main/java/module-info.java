module com.example.proj2wangbogatyrevdimitrov {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proj2wangbogatyrevdimitrov to javafx.fxml;
    exports com.example.proj2wangbogatyrevdimitrov;
}