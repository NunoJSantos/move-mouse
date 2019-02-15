package pt.nunojsantos.movemouse.view;

import pt.nunojsantos.movemouse.controller.MoveMouseController;

public interface MoveMouseView {

	void init(String... args);

	void setMoveMouseController(MoveMouseController moveMouseController);
}
