package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import au.edu.uts.ap.javafx.*;

public class ErrorController extends Controller<Exception>{
    @FXML private Button OkayBtn;

    @FXML private void initialize(){
        
    }
    
    @FXML private void handleOkay(ActionEvent event){
        stage.close();
    }
    
    public Exception getE(){
        return model;
    }
}
