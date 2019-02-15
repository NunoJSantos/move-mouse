package pt.nunojsantos.movemouse;

import pt.nunojsantos.movemouse.controller.MoveMouseController;

public class Main {

	public static void main(String... args) {

		MoveMouseController moveMouseController = new MoveMouseController();
		moveMouseController.start(args);

	}

}
