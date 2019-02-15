package pt.nunojsantos.movemouse;

import pt.nunojsantos.movemouse.controller.MoveMouseController;
import pt.nunojsantos.movemouse.view.CliView;
import pt.nunojsantos.movemouse.view.GuiView;

public class Main {

	public static void main(String... args) {

		MoveMouseController moveMouseController = new MoveMouseController();

		if (args.length == 0) {
			moveMouseController.setView(new GuiView());
		} else {
			moveMouseController.setView(new CliView());
		}

		moveMouseController.start(args);

	}

}
