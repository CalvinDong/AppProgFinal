package controller;

import au.edu.uts.ap.javafx.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import model.*;

public class CheckBuildController extends Controller<Build>{
    @FXML private Text fieldTxt;
    /*<Text fx:id="ramTxt" text="The build is missing RAM"/>
    <Text fx:id="cpuTxt" text="The build is missing a CPU"/>
    <Text fx:id="storageTxt" text="The build is missing storage"/>
    <Text fx:id="caseTxt" text="The build is missing a case"/>*/
    
    @FXML private void initialize(){
        String originalString =("");
        fieldTxt.setText(originalString);
        boolean validBuild = true;
        
        if (!model.hasPartOfType("CPU")){
            originalString = originalString + "The build is missing a CPU.\n";
            fieldTxt.setText(originalString);
            validBuild = false;
        }        
        if (!model.hasPartOfType("MOTHERBOARD")){
            originalString = originalString + ("The build is missing a motherboard.\n");
            fieldTxt.setText(originalString);
            validBuild = false;
        }
        if (!model.hasPartOfType("MEMORY")){
            originalString = originalString + "The build is missing RAM.\n";
            fieldTxt.setText(originalString);
            validBuild = false;
        }
        if (!model.hasPartOfType("CASE")){
            originalString = originalString + "The build is missing a case.\n";
            fieldTxt.setText(originalString);
            validBuild = false;
        }
        if (!model.hasPartOfType("STORAGE")){
            originalString = originalString + "The build is missing storage.";
            fieldTxt.setText(originalString);
            validBuild = false;
        }
        if (validBuild){
            fieldTxt.setText("The build is functional.");
        }
    }
    
    @FXML private void handleOkay(ActionEvent event){
        stage.close();
    }
    
    
    private Build getBuild(){
        return model;
    }
}
