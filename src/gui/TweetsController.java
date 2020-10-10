package gui;

import application.Main;
import exceptions.PDException;
import exceptions.PIException;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TweetsController {
	@FXML
	private TextField txtUserName;

	@FXML
	private Button btTweets;

	@FXML
	public synchronized void onBtTweetsAction() {
		try {
			System.out.println(Main.service.tweets(txtUserName.getText()));
		} catch (PDException | PIException e) {
			Alerts.showAlert("Error", null, e.getMessage(), AlertType.ERROR);
		} finally {
			txtUserName.setText("");
		}
	}
}
