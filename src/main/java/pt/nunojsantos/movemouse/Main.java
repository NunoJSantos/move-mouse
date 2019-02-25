package pt.nunojsantos.movemouse;

import pt.nunojsantos.movemouse.controller.CliController;
import pt.nunojsantos.movemouse.controller.GuiController;
import pt.nunojsantos.movemouse.controller.MoveMouseController;

public class Main {

	public static void main(String... args) {

		MoveMouseController controller = args.length == 0 ? new GuiController() : new CliController();

		controller.init(args);

	}

}
