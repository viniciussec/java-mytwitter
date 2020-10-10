package gui;

import application.Main;
import exceptions.PDException;
import exceptions.PIException;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NumeroSeguidoresController {
	@FXML
	private TextField txtUserName;

	@FXML
	private Button btNumeroSeguidores;
	
	@FXML
	private Label numeroSeguidores;

	@FXML
	public synchronized void onBtNumeroSeguidoresAction() {
		try {
			numeroSeguidores.setText(Integer.toString(Main.service.numeroSeguidores(txtUserName.getText())));
		} catch (PDException | PIException e) {
			Alerts.showAlert("Error", null, e.getMessage(), AlertType.ERROR);
		} finally {
			txtUserName.setText("");
		}
	}
}
