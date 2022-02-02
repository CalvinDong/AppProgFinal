package controller;

import au.edu.uts.ap.javafx.*;
import java.text.DecimalFormat;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;


public class BuildController extends Controller<Build>{
    @FXML private TableView<Part> buildTv;
    @FXML private TableColumn<Part,String> priceClm;
    @FXML private Button checkBuildBtn;
    @FXML private Button removeFromBuildBtn;
    @FXML private Button closeBtn;
    @FXML private Text costTxt; 
    
    @FXML private void initialize(){
        priceClm.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asString("$%.2f"));
        buildTv.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldPart, newPart) -> removeFromBuildBtn.setDisable(newPart == null)
				);
        costTxt.setText("$" +formatted(model.totalPrice()));
        model.getParts().addListener(new ListChangeListener<Part>() {
			@Override
			public void onChanged(javafx.collections.ListChangeListener.Change<? extends Part> c) {
				costTxt.setText("$" +formatted(model.totalPrice()));
			}

		});
        buildTv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //buildTv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
     
    
    @FXML private void handleRemoveFromBuild(ActionEvent event){
        model.remove(buildTv.getSelectionModel().getSelectedItems());
    }
    
    @FXML private void handleClose(ActionEvent event){
        stage.close();
    }
    
    @FXML private void handleCheckBuild(ActionEvent event){
        try{
            ViewLoader.showStage(getBuild(),"/view/buildcheck.fxml", "Build Validity Status", new Stage());
        }
        catch (Exception e){
            System.out.println("lmaomao");
        }
    }
    
    
    private void costUpdate(){
        costTxt.setText("" + model.totalPrice());
    }
    
    public Build getBuild() {
		return model;
	}
    
    private String formatted(double money) {
        return new DecimalFormat("###,##0.00").format(money);
    }
}
