package pt.nunojsantos.movemouse;

import pt.nunojsantos.movemouse.controller.CliController;
import pt.nunojsantos.movemouse.controller.GuiController;
import pt.nunojsantos.movemouse.controller.MoveMouseController;
import pt.nunojsantos.movemouse.service.MoveMouseService;

public class Main {

	public static void main(String... args) {

		MoveMouseService moveMouseService = new MoveMouseService();
		MoveMouseController controller = args.length == 0 ? new GuiController() : new CliController();

		controller.setMoveMouseService(moveMouseService);

		moveMouseService.setView(controller);

		moveMouseService.init(args);

	}

}
