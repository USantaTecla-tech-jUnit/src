package ticTacToe.controllers.local;

import ticTacToe.controllers.ColocateControllerVisitor;
import ticTacToe.controllers.Error;
import ticTacToe.controllers.OperationControllerVisitor;
import ticTacToe.controllers.PutController;
import ticTacToe.models.Coordinate;
import ticTacToe.models.Game;

public class LocalPutController extends LocalColocateController implements
		PutController {

	LocalPutController(Game game, LocalCoordinateController coordinateController) {
		super(game, coordinateController);
	}

	@Override
	public void put(Coordinate target) {
		assert this.validateTarget(target) == null;
		super.put(target);
	}

	public Error validateTarget(Coordinate target) {
		return super.validateTarget(target);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

	@Override
	public void accept(ColocateControllerVisitor colocateControllerVisitor) {
		colocateControllerVisitor.visit(this);
	}
}
