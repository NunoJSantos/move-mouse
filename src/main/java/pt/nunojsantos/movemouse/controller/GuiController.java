package pt.nunojsantos.movemouse.controller;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pt.nunojsantos.movemouse.service.MoveMouseService;
import pt.nunojsantos.movemouse.utils.Constants;

public class GuiController extends Application implements MoveMouseController {

	private MoveMouseService moveMouseService;
	@FXML
	private TextField timeField;
	@FXML
	private Button startStopButton;

	private Task<Void> task = null;

	public GuiController() {
		this.moveMouseService = new MoveMouseService();
	}

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

			if (task == null) {

				int secondsInterval =
						timeField.getText().isEmpty() ? Constants.DEFAULT_TIME_INTERVAL : Integer.parseInt(timeField.getText());

				startStopButton.setText("STOP");

				task = new Task<Void>() {
					@Override
					protected Void call() throws Exception {
						try {
							moveMouseService.moveMouse(secondsInterval);
						} catch (Exception e) {
							e.printStackTrace();
						}
						return null;
					}
				};

				Thread thread = new Thread(task);
				thread.setDaemon(true);
				thread.start();

			} else {
				moveMouseService.stopMouse();
				task.cancel();
				task = null;
				startStopButton.setText("START");
			}
		});
	}

}
