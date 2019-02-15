package pt.nunojsantos.movemouse.view;

import pt.nunojsantos.movemouse.controller.MoveMouseController;

public class GuiView implements MoveMouseView {

	private MoveMouseController moveMouseController;

	@Override
	public void init(String... args) {
		//TODO implement
	}

	@Override
	public void setMoveMouseController(MoveMouseController moveMouseController) {
		this.moveMouseController = moveMouseController;
	}

}
