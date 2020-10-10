package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BuscarController implements Initializable{
	@FXML
	private TextField txtUser;
	
	@FXML
	private Button btSearch;
	
	public void onBtSearchAction() {
		System.out.println(Main.service.buscar(txtUser.getText()));
		txtUser.setText("");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
