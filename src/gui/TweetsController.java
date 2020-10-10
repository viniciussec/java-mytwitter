package gui;

import java.util.ArrayList;

import application.Main;
import entities.Tweet;
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
			ArrayList<Tweet> tweets = Main.service.tweets(txtUserName.getText());
			System.out.println(tweets);
			
		} catch (PDException | PIException e) {
			Alerts.showAlert("Error", null, e.getMessage(), AlertType.ERROR);
		} finally {
			txtUserName.setText("");
		}
	}
}
