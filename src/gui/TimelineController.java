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

public class TimelineController {
	@FXML
	TextField txtUserName;

	@FXML
	Button btTimeline;

	@FXML
	Label labelTimeline;
	
	@FXML
	Label labelTweets;
	
	public void onBtTimelineOnAction() {
		try {
			labelTimeline.setText("Timeline");
			ArrayList<Tweet> timeline = Main.service.timeline(txtUserName.getText());
			labelTweets.setText(timeline.toString().substring(1, timeline.toString().length() - 1));

		} catch (PDException | PIException e) {
			Alerts.showAlert("Error", null, e.getMessage(), AlertType.ERROR);
		} finally {
			txtUserName.setText("");
		}
	}

}
