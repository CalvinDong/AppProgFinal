package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import au.edu.uts.ap.javafx.*;
import java.io.IOException;
import javafx.application.Platform;
import model.*;

public class ComputerBuilderController extends Controller<ComputerBuilder>{
    @FXML private Button viewCataBtn;
    @FXML private Button viewBuildBtn;
    @FXML private Button quitBtn;
    
    @FXML private void initialize(){
        viewBuildBtn.setText("View\nBuild");
        viewCataBtn.setText("View\nCatalogue");
    }
    
    @FXML private void handleViewCata(ActionEvent event) throws IOException{
        ViewLoader.showStage(model.getCatalogue(),"/view/catalogue.fxml", "Catalogue", new Stage());
    }
        
    @FXML private void handleViewBuild(ActionEvent event) throws IOException{
        ViewLoader.showStage(model.getBuild(),"/view/build.fxml", "Current Build", new Stage());
    }
    @FXML private void handleQuit(ActionEvent event){
        stage.close();
        Platform.exit();
    }
}
    
    
