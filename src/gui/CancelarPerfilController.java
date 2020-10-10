package gui;

import application.Main;
import exceptions.PDException;
import exceptions.PIException;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CancelarPerfilController {
	@FXML
	TextField txtUserName;
	
	@FXML
	Button btCancelarUsuario;
	
	@FXML
	public void onBtCancelarUsuarioAction(){
		try {
			Main.service.cancelarPerfil(txtUserName.getText());
		} catch (PIException | PDException e) {
			Alerts.showAlert("Error", null, e.getMessage(), AlertType.ERROR);
		} finally {
			txtUserName.setText("");
		}
	}
}
