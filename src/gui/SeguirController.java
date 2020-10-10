package gui;

import application.Main;
import exceptions.PDException;
import exceptions.PIException;
import exceptions.SIException;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SeguirController {
	@FXML
	private TextField txtSeguidor;
	
	@FXML
	private TextField txtSeguido;

	@FXML
	private Button btSeguir;

	@FXML
	public synchronized void onSeguirAction() {
		try {
			Main.service.seguir(txtSeguidor.getText(), txtSeguido.getText());
		} catch (PDException | SIException | PIException e) {
			Alerts.showAlert("Error", null, e.getMessage(), AlertType.ERROR);
		} finally {
			txtSeguidor.setText("");
			txtSeguido.setText("");
		}
	}
}
