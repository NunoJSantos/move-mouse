package pt.nunojsantos.movemouse.controller;

import pt.nunojsantos.movemouse.service.MoveMouseService;
import pt.nunojsantos.movemouse.utils.Constants;

public class CliController implements MoveMouseController {

	private MoveMouseService moveMouseService;

	public CliController() {
		this.moveMouseService = new MoveMouseService();
	}

	@Override
	public void init(String... args) {
		System.out.println(Constants.WELCOME_CLI);

		if (args.length > 1) {
			System.err.println(Constants.BAD_USAGE);
			return;
		}

		try {

			int secondsInterval = args.length == 1 ? Integer.parseInt(args[0]) : Constants.DEFAULT_TIME_INTERVAL;

			Runnable task = () -> {
				try {
					moveMouseService.moveMouse(secondsInterval);
				} catch (Exception e) {
					e.printStackTrace();
				}
			};

			Thread thread = new Thread(task);
			thread.setDaemon(true);
			thread.start();

			System.out.println(Constants.FOR_EXIT);
			while (thread.isAlive()) {
				showSpinner();
			}

		} catch (NumberFormatException e) {
			System.err.println(Constants.BAD_USAGE);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(Constants.GENERIC_ERROR);
		}

	}

	private void showSpinner() throws InterruptedException {
		String chars = "|/-\\";
		for (int i = 0; i < chars.length(); i++) {
			System.out.print("\b \b" + chars.charAt(i));
			Thread.sleep(60);
		}
	}

}
