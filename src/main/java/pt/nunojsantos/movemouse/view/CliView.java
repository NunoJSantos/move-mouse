package pt.nunojsantos.movemouse.view;

import pt.nunojsantos.movemouse.utils.Messages;

public class CliView implements MoveMouseView {

	@Override
	public void init() {
		System.out.println(Messages.WELCOME_CLI);
	}

	@Override
	public void showErrorMessage(String errorMessage) {
		System.err.println(errorMessage);
	}

}
