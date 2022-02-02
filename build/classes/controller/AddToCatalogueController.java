package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import au.edu.uts.ap.javafx.*;
import java.io.IOException;
import javafx.scene.control.TextField;
import model.*;

public class AddToCatalogueController extends Controller<Catalogue>{
    @FXML private TextField typeTf;
    @FXML private TextField nameTf;
    @FXML private TextField priceTf;
    @FXML private Button addBtn;
    
    @FXML private void initialize(){
     
    }
    
    @FXML private void handleAddToCatalogue() throws IOException{
        try{
            model.addPart(nameTf.getText(),typeTf.getText(),Double.parseDouble(priceTf.getText()));
            stage.close();
        }
        catch (Exception e){
            ViewLoader.showStage(e,"/view/error.fxml", "Incorrect Input", new Stage());
        }
    }
    
    public Catalogue getCatalogue(){
        return model;
    }

}
