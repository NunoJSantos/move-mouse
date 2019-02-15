package pt.nunojsantos.movemouse;

import pt.nunojsantos.movemouse.controller.MoveMouseController;
import pt.nunojsantos.movemouse.view.CliView;
import pt.nunojsantos.movemouse.view.GuiView;
import pt.nunojsantos.movemouse.view.MoveMouseView;

public class Main {

	public static void main(String... args) {

		MoveMouseController moveMouseController = new MoveMouseController();
		MoveMouseView view = new CliView();

		// Comment while GuiView not properly implemented
//		if (args.length == 0) {
//			view = new GuiView();
//		} else {
//			view = new CliView();
//		}

		view.setMoveMouseController(moveMouseController);

		moveMouseController.setView(view);

		moveMouseController.init(args);

	}

}
