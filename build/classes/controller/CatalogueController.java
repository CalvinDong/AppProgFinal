package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import au.edu.uts.ap.javafx.*;
import java.io.IOException;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.*;

public class CatalogueController extends Controller<Catalogue>{
    @FXML private TableView<Part> catalogueTv;
    @FXML private TableColumn<Part,String> priceClm;
    @FXML private Button addToBuildBtn;
    @FXML private Button removeFromCatalogueBtn;
    @FXML private Button addToCatalogueBtn;
    @FXML private Button closeBtn;
    @FXML private TextField typeTf;
    @FXML private TextField minTf;
    @FXML private TextField maxTf;
    
    @FXML private void initialize(){
        priceClm.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asString("$%.2f"));
        catalogueTv.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldPart, newPart) -> addToBuildBtn.setDisable(newPart == null)
				);
        catalogueTv.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldPart, newPart) -> removeFromCatalogueBtn.setDisable(newPart == null)
				);
        typeTf.textProperty().addListener(
                (obj, oldText, newText) -> model.filterList(typeTf.getText(),minTf.getText(),maxTf.getText())
                );
        minTf.textProperty().addListener(
                (obj, oldText, newText) -> model.filterList(typeTf.getText(),minTf.getText(),maxTf.getText())
                );
        maxTf.textProperty().addListener(
                (obj, oldText, newText) -> model.filterList(typeTf.getText(),minTf.getText(),maxTf.getText())
                );
        catalogueTv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
    }
    
    @FXML private void handleAddBuild(ActionEvent event){
        model.addToBuild(catalogueTv.getSelectionModel().getSelectedItems());
    }
    
    @FXML private void handleAddToCatalogue(ActionEvent event) throws IOException{
        ViewLoader.showStage(getCatalogue(),"/view/addtocatalogue.fxml", "Add New Part to Catalogue", new Stage());
    }
    
    @FXML private void handleClose(ActionEvent event){
        stage.close();
    }
    
    @FXML private void handleRemoveFromCatalogue(ActionEvent event){
        model.remove(catalogueTv.getSelectionModel().getSelectedItems());
    }
    
    public final Catalogue getCatalogue() {
		return model;
	}
    

}
