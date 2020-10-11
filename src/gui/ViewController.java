package gui;

import java.io.IOException;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class ViewController {

	@FXML
	private MenuItem menuItemPessoaFisica;

	@FXML
	private MenuItem menuItemPessoaJuridica;

	@FXML
	private MenuItem menuItemAbout;

	@FXML
	private MenuItem menuItemCancelarPerfil;

	@FXML
	private MenuItem menuItemTweetar;

	@FXML
	private MenuItem menuItemTimeline;

	@FXML
	private MenuItem menuItemTweets;
	
	@FXML
	private MenuItem menuItemSeguir;

	@FXML
	private MenuItem menuItemNumeroSeguidores;

	@FXML
	private MenuItem menuItemSeguidores;

	@FXML
	private MenuItem menuItemSeguidos;

	@FXML
	public void onMenuItemPessoaFisicaAction() {
		loadView("/gui/PessoaFisicaCadastro.fxml");
	}

	@FXML
	public void onMenuItemPessoaJuridicaAction() {
		loadView("/gui/PessoaJuridicaCadastro.fxml");
	}

	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/About.fxml");
	}

	@FXML
	public void onMenuItemCancelarPerfilAction() {
		loadView("/gui/CancelarPerfil.fxml");
	}

	@FXML
	public void onMenuItemTweetarAction() {
		loadView("/gui/Tweetar.fxml");
	}

	@FXML
	public void onMenuItemTimelineAction() {
		loadView("/gui/Timeline.fxml");
	}

	@FXML
	public void onMenuItemTweetsAction() {
		loadView("/gui/Tweets.fxml");
	}

	@FXML
	public void onMenuItemSeguirAction() {
		loadView("/gui/Seguir.fxml");
	}

	@FXML
	public void onMenuItemNumeroSeguidoresAction() {
		loadView("/gui/NumeroSeguidores.fxml");
	}

	@FXML
	public void onMenuItemSeguidoresAction() {
		loadView("/gui/Seguidores.fxml");
	}

	@FXML
	public void onMenuItemSeguidosAction() {
		loadView("/gui/Seguidos.fxml");
	}

	private synchronized void loadView(String absoluteName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();

			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());

		} catch (IOException e) {
			Alerts.showAlert("IOException", "Erro carregando página", e.getMessage(), AlertType.ERROR);
		}
	}

}
