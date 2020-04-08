package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable{
	
	@FXML
	private MenuItem menuItemSeller;
	@FXML
	private MenuItem menuItemDepartment;
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("onMenuItemSellerAction");
	}

	@FXML
	public void onMenuItemDepartmentAction() {
		System.out.println("onMenuItemSellerAction");
	}

	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/AboutView.fxml");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
	
	private synchronized void loadView(String absoluteName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			
			Scene mainScene = Main.getMainScene(); //referencia a cena principal
			
			VBox mainVBox = (VBox)((ScrollPane)mainScene.getRoot()).getContent(); //caputra o vbox acessando o scroll pane e logo em seguida o conteudo
			
			Node mainMenu = mainVBox.getChildren().get(0); //armazena o primeiro elemento filho
			
			mainVBox.getChildren().clear(); //limpa todos os filhos
			
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
		} catch(IOException e) {
			Alerts.showAlert("IO exceptio", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}

}
