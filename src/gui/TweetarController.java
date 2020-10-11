package gui;

import application.Main;
import exceptions.MFPException;
import exceptions.PIException;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TweetarController {
	@FXML
	private TextField txtUserName;
	
	@FXML
	private TextArea txtMensagem;

	@FXML
	private Button btTweetar;

	@FXML
	public synchronized void onTweetarAction() {
		try {
			Main.service.tweetar(txtUserName.getText(), txtMensagem.getText());
			Alerts.showAlert("Info", null, "Tweetado com sucesso", AlertType.INFORMATION);
		} catch (PIException | MFPException e) {
			Alerts.showAlert("Error", null, e.getMessage(), AlertType.ERROR);
		} finally {
			txtUserName.setText("");
			txtMensagem.setText("");
		}
	}
}
