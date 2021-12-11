package ticTacToe.controllers;

import ticTacToe.models.Color;
import ticTacToe.models.Coordinate;

public interface ColocateController extends OperationController,
		PresenterController {

	Color take();

	void put(Coordinate target);

	boolean existTicTacToe();

	CoordinateController getCoordinateController();
	
	Error validateTarget(Coordinate target);

	void accept(ColocateControllerVisitor colocateControllerVisitor);

}
