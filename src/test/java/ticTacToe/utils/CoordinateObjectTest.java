package ticTacToe.utils;

import static org.junit.Assert.assertEquals;

public class CoordinateObjectTest {
	private int OUTRow;
	private int OUTColumn;
	private Coordinate coordinate;
	private boolean expectedInRow;
	private boolean expectedInColumn;
	private boolean expectedInMainDiagonal;
	private Direction expectedDirection;
	private Coordinate OUTCoordinate;

	public CoordinateObjectTest(
			// OUT
			int OUTRow, 
			int OUTColumn,
			// arguments
			Coordinate coordinate, 
			boolean expectedInRow, 
			boolean expectedInColumn, 
			boolean expectedInMainDiagonal,
			Direction expectedDirection) {
		this.OUTRow = OUTRow;
		this.OUTColumn = OUTColumn;
		this.coordinate = coordinate;
		this.expectedInRow = expectedInRow;
		this.expectedInColumn = expectedInColumn;
		this.expectedInMainDiagonal = expectedInMainDiagonal;
		this.expectedDirection = expectedDirection;
	}

	private void before() {
		OUTCoordinate = new Coordinate(OUTRow, OUTColumn);
	}

	public void testInRow() {
		this.before();
		boolean resultInRow = OUTCoordinate.inRow(coordinate);
		assertEquals("testInRow: For OUTCoordinate " + OUTCoordinate + " and " + coordinate, expectedInRow, resultInRow);
	}

	public void testInColumn() {
		this.before();
		boolean resultInColumn = OUTCoordinate.inColumn(coordinate);
		assertEquals("testInColumn: For OUTCoordinate " + OUTCoordinate + " and " + coordinate, expectedInColumn,
				resultInColumn);
	}

	public void testInMainDiagonal() {
		this.before();
		boolean resultInMainDiagonal = OUTCoordinate.inMainDiagonal();
		assertEquals("testInMainDiagonal: For OUTCoordinate " + OUTCoordinate, expectedInMainDiagonal,
				resultInMainDiagonal);
	}

	public void testDirection() {
		this.before();
		Direction resultDirection = OUTCoordinate.direction(coordinate);
		assertEquals("testDirection: For OUTCoordinate " + OUTCoordinate + " and " + coordinate, expectedDirection,
				resultDirection);
	}

}
