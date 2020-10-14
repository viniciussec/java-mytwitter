package gui;

import application.Main;
import entities.PessoaJuridica;
import exceptions.PEException;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CriarPessoaJuridicaController {
	@FXML
	private TextField txtUserName;
	
	@FXML
	private TextField txtCNPJ;

	@FXML
	private Button btCriarPerfil;

	@FXML
	public synchronized void onBtCriarPerfilAction() {
		try {
			PessoaJuridica perfil = new PessoaJuridica(txtUserName.getText());
			
			if(txtCNPJ.getText().equals("")) {
			} else {
				perfil.setCnpj(Long.parseLong(txtCNPJ.getText()));
			}
			
			Main.service.criarPerfil(perfil);
			Alerts.showAlert("Info", null, "Perfil criado com sucesso", AlertType.INFORMATION);
		} catch (PEException e) {
			Alerts.showAlert("Error", null, e.getMessage(), AlertType.ERROR);
		} finally {
			txtUserName.setText("");
			txtCNPJ.setText("");
		}
	}
}
