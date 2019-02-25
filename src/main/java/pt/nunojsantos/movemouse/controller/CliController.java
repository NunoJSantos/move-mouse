package pt.nunojsantos.movemouse.controller;

import pt.nunojsantos.movemouse.service.MoveMouseService;
import pt.nunojsantos.movemouse.utils.Constants;

public class CliController implements MoveMouseController {

	private MoveMouseService moveMouseService;

	@Override
	public void init(String... args) {
		System.out.println(Constants.WELCOME_CLI);

		if (args.length > 1) {
			System.err.println(Constants.BAD_USAGE);
			return;
		}

		try {

			int secondsInterval = args.length == 1 ? Integer.parseInt(args[0]) : Constants.DEFAULT_TIME_INTERVAL;

			moveMouseService.moveMouse(secondsInterval);

		} catch (NumberFormatException e) {
			System.err.println(Constants.BAD_USAGE);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(Constants.GENERIC_ERROR);
		}

	}

	@Override
	public void setMoveMouseService(MoveMouseService moveMouseService) {
		this.moveMouseService = moveMouseService;
	}

}
