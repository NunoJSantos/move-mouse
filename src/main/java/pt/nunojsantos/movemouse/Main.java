package pt.nunojsantos.movemouse;

import pt.nunojsantos.movemouse.service.MoveMouseService;
import pt.nunojsantos.movemouse.controller.CliController;
import pt.nunojsantos.movemouse.controller.MoveMouseController;

public class Main {

	public static void main(String... args) {

		MoveMouseService moveMouseService = new MoveMouseService();
		MoveMouseController view = new CliController();

		// Comment while GuiController not properly implemented
//		if (args.length == 0) {
//			controller = new GuiController();
//		} else {
//			controller = new CliController();
//		}

		view.setMoveMouseService(moveMouseService);

		moveMouseService.setView(view);

		moveMouseService.init(args);

	}

}
