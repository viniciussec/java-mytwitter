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

public class SeguidosController {
	
	@FXML
	private TextField txtUserName;

	@FXML
	private Button btSeguidos;
	
	@FXML
	private Label labelSeguidos;
	
	@FXML
	private Label labelPerfis;

	@FXML
	public void onBtSeguidosAction() {
		try {
			labelSeguidos.setText("Seguidos:");
			ArrayList<Perfil> seguidos = Main.service.seguidos(txtUserName.getText());
			labelPerfis.setText(seguidos.toString().substring(1,seguidos.toString().length()-1));
			
		} catch (PDException | PIException e) {
			Alerts.showAlert("Error", null, e.getMessage(), AlertType.ERROR);
		} finally {
			txtUserName.setText("");
		}
	}
}
