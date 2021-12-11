package ticTacToe.views.console;

import ticTacToe.controllers.CoordinateController;
import ticTacToe.controllers.CoordinateControllerVisitor;
import ticTacToe.models.Coordinate;
import ticTacToe.utils.IO;

abstract class ColocateCoordinateView implements CoordinateControllerVisitor {

	private CoordinateController coordinateController;
	
	private IO io;
	
	protected ColocateCoordinateView(CoordinateController coordinateController){
		assert coordinateController != null;
		this.coordinateController = coordinateController;
		io = new IO();
	}
	
	abstract Coordinate getCoordinate();
	
	protected void show(String infix, Coordinate coordinate){
		new CoordinateView("La máquina " + infix + " ", coordinate).write();
		io.readString(". Pulse enter para continuar");
	}
	
	protected CoordinateController getCoordinateController(){
		return coordinateController;
	}
}
