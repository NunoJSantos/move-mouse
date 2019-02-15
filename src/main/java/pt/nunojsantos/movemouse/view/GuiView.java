package pt.nunojsantos.movemouse.view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pt.nunojsantos.movemouse.controller.MoveMouseController;

public class GuiView extends Application implements MoveMouseView {

	private MoveMouseController moveMouseController;
	@FXML
	private TextField timeField;
	@FXML
	private Button startStopButton;

	@Override
	public void init(String... args) {
		launch(args);
	}

	@Override
	public void setMoveMouseController(MoveMouseController moveMouseController) {
		this.moveMouseController = moveMouseController;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(GuiView.class.getResource("/gui.fxml"));
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
				moveMouseController.moveMouse(timeInterval);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}
