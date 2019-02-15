package pt.nunojsantos.movemouse.controller;

import pt.nunojsantos.movemouse.service.MoveMouseService;
import pt.nunojsantos.movemouse.utils.Messages;

public class CliController implements MoveMouseController {

	private MoveMouseService moveMouseService;
	private int timeInterval = 30000;

	@Override
	public void init(String... args) {
		System.out.println(Messages.WELCOME_CLI);

		if (args.length > 1) {
			System.err.println(Messages.BAD_USAGE);
			return;
		}

		try {

			if (args.length == 1) {
				timeInterval = Integer.parseInt(args[0]) * 1000;
			}

			moveMouseService.moveMouse(timeInterval);

		} catch (NumberFormatException e) {
			System.err.println(Messages.BAD_USAGE);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(Messages.GENERIC_ERROR);
		}

	}

	@Override
	public void setMoveMouseService(MoveMouseService moveMouseService) {
		this.moveMouseService = moveMouseService;
	}

}
