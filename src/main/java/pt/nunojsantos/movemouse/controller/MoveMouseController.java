package pt.nunojsantos.movemouse.controller;

import pt.nunojsantos.movemouse.service.MoveMouseService;

public interface MoveMouseController {

	void init(String... args);

	void setMoveMouseService(MoveMouseService moveMouseService);
}
