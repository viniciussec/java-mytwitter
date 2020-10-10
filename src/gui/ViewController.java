package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class ViewController implements Initializable {

	@FXML
	private MenuItem menuItemBuscar;

	@FXML
	private MenuItem menuItemAtualizar;

	@FXML
	private MenuItem menuItemPessoaFisica;

	@FXML
	private MenuItem menuItemPessoaJuridica;

	@FXML
	private MenuItem menuItemAbout;

	@FXML
	private MenuItem menuItemCriarPerfil;

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
	private MenuItem menuItemListar;

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
	public void onMenuItemBuscarAction() {
		loadView("/gui/Buscar.fxml");
	}

	@FXML
	public void onMenuItemAtualizarAction() {
		loadView("/gui/Atualizar.fxml");
	}

	@FXML
	public void onMenuItemCriarPerfilAction() {
		loadView("/gui/CriarPerfil.fxml");
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
	
	@FXML
	public void onMenuItemListarAction() {
		loadView("/gui/Listar.fxml");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

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
