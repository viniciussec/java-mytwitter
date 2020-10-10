package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import entities.PessoaFisica;
import exceptions.PEException;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CriarPerfilController implements Initializable {
	@FXML
	private TextField txtUserName;

	@FXML
	private Button btCriarPerfil;

	@FXML
	public synchronized void onBtCriarPerfilAction() {
		try {
			Main.service.criarPerfil(new PessoaFisica(txtUserName.getText()));
		} catch (PEException e) {
			Alerts.showAlert("Error", null, e.getMessage(), AlertType.ERROR);
		} finally {
			txtUserName.setText("");
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
