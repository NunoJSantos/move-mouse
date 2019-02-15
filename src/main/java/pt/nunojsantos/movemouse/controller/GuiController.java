package pt.nunojsantos.movemouse.controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pt.nunojsantos.movemouse.service.MoveMouseService;

public class GuiController extends Application implements MoveMouseController {

	private MoveMouseService moveMouseService;
	@FXML
	private TextField timeField;
	@FXML
	private Button startStopButton;

	@Override
	public void init(String... args) {
		launch(args);
	}

	@Override
	public void setMoveMouseService(MoveMouseService moveMouseService) {
		this.moveMouseService = moveMouseService;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(GuiController.class.getResource("/gui.fxml"));
		AnchorPane page = loader.load();
		Scene scene = new Scene(page);

		primaryStage.setTitle("Move Mouse");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	@FXML
	private void initialize() {

		startStopButton.setOnAction(event -> {
			try {

				int timeInterval = Integer.parseInt(timeField.getText());
				moveMouseService.moveMouse(timeInterval);

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}