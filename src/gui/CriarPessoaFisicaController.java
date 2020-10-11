package gui;

import application.Main;
import entities.PessoaFisica;
import exceptions.PEException;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CriarPessoaFisicaController {
	@FXML
	private TextField txtUserName;
	
	@FXML
	private TextField txtCPF;

	@FXML
	private Button btCriarPerfil;

	@FXML
	public synchronized void onBtCriarPerfilAction() {
		try {
			PessoaFisica perfil = new PessoaFisica(txtUserName.getText());
			
			if(txtCPF.getText().equals("")) {
			} else {
				perfil.setCpf(Long.parseLong(txtCPF.getText()));
			}
			
			Main.service.criarPerfil(perfil);
			Alerts.showAlert("Info", null, "Perfil criado com sucesso", AlertType.INFORMATION);
		} catch (PEException e) {
			Alerts.showAlert("Error", null, e.getMessage(), AlertType.ERROR);
		} finally {
			txtUserName.setText("");
		}
	}
}
