package gui;

import java.util.ArrayList;

import application.Main;
import entities.Perfil;
import exceptions.PDException;
import exceptions.PIException;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SeguidoresController {
	
	@FXML
	private TextField txtUserName;

	@FXML
	private Button btTweets;
	
	@FXML
	private Label labelSeguidores;
	
	@FXML
	private Label labelPerfis;

	@FXML
	public void onBtTweetsAction() {
		try {
			labelSeguidores.setText("Seguidores:");
			ArrayList<Perfil> seguidores = Main.service.seguidores(txtUserName.getText());
			labelPerfis.setText(seguidores.toString().substring(1,seguidores.toString().length()-1));
			
		} catch (PDException | PIException e) {
			Alerts.showAlert("Error", null, e.getMessage(), AlertType.ERROR);
		} finally {
			txtUserName.setText("");
		}
	}
}
