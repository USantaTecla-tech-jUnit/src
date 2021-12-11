package ticTacToe.controllers.local;

import ticTacToe.controllers.ColocateController;
import ticTacToe.controllers.CoordinateController;
import ticTacToe.controllers.Error;
import ticTacToe.models.Coordinate;
import ticTacToe.models.Game;

abstract class LocalColocateController extends LocalOperationController
		implements ColocateController {

	private LocalCoordinateController coordinateController;

	protected LocalColocateController(Game game,
			LocalCoordinateController coordinateController) {
		super(game);
		assert coordinateController != null;
		this.coordinateController = coordinateController;
	}

	public Error validateTarget(Coordinate target) {
		if (!this.empty(target)) {
			System.out.println("Error no libre");
			return Error.NOT_EMPTY;
		}
		return null;
	}

	public CoordinateController getCoordinateController() {
		return coordinateController;
	}

}
