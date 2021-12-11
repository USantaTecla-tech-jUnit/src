package ticTacToe.controllers;

import ticTacToe.models.Coordinate;

public interface PutController extends ColocateController {

	Error validateTarget(Coordinate target);

}
