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

public class ViewController implements Initializable {

	@FXML
	private MenuItem menuItemPessoaFisica;

	@FXML
	private MenuItem menuItemPessoaJuridica;

	@FXML
	private MenuItem menuItemAbout;

	@FXML
	public void onMenuItemPessoaFisicaAction() {
		System.out.println("onMenuItemPessoaFisicaAction");
	}

	@FXML
	public void onMenuItemPessoaJuridicaAction() {
		System.out.println("onMenuItemPessoaJuridicaAction");
	}

	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/About.fxml");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	private synchronized void loadView(String absoluteName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			
		} catch (IOException e) {
			Alerts.showAlert("IOException", "Erro carregando página", e.getMessage(), AlertType.ERROR);
		}
	}

}
