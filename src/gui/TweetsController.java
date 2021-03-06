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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TweetsController {
	
	@FXML
	private Label labelTtText;
	
	@FXML
	private Label labelTweets;
	
	@FXML
	private TextField txtUserName;

	@FXML
	private Button btTweets;

	@FXML
	public void onBtTweetsAction() {
		try {
			labelTtText.setText("Tweets");
			ArrayList<Tweet> tweets = Main.service.tweets(txtUserName.getText());
			labelTweets.setText(tweets.toString().substring(1,tweets.toString().length()-1));
			
		} catch (PDException | PIException e) {
			Alerts.showAlert("Error", null, e.getMessage(), AlertType.ERROR);
		} finally {
			txtUserName.setText("");
		}
	}
}
