package components;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ticTacToe.models.Game;
import ticTacToe.models.Color;
import ticTacToe.models.Coordinate;
import ticTacToe.models.State;

public class GameTest {

	private Game outGame;

	@Before
	public void before() {
		outGame = new Game();
	}

	@Test
	public void testGame() {
		for (int i = 0; i < Color.values().length - 1; i++) {
			for (int j = 0; j < Color.values().length - 1; j++) {
				assertEquals(Color.NONE,
						outGame.getColor(new Coordinate(i, j)));
			}
		}
		assertEquals(State.INITIAL, outGame.getState());
	}

	@Test
	public void testGetColor() {
		for (int i = 0; i < Color.values().length - 1; i++) {
			for (int j = 0; j < Color.values().length - 1; j++) {
				assertEquals(Color.NONE,
						outGame.getColor(new Coordinate(i, j)));
			}
		}
		outGame.put(new Coordinate(0, 0));
		assertEquals(Color.XS, outGame.getColor(new Coordinate(0, 0)));
		outGame.change();
		outGame.put(new Coordinate(0, 1));
		assertEquals(Color.OS, outGame.getColor(new Coordinate(0, 1)));
		outGame.change();
		outGame.put(new Coordinate(0, 2));
		assertEquals(Color.XS, outGame.getColor(new Coordinate(0, 2)));
		outGame.change();
		outGame.put(new Coordinate(1, 0));
		assertEquals(Color.OS, outGame.getColor(new Coordinate(1, 0)));
		outGame.change();
		outGame.put(new Coordinate(1, 1));
		assertEquals(Color.XS, outGame.getColor(new Coordinate(1, 1)));
		outGame.change();
		outGame.put(new Coordinate(1, 2));
		assertEquals(Color.OS, outGame.getColor(new Coordinate(1, 2)));
		outGame.change();
		outGame.remove(new Coordinate(0, 0));
		outGame.change();
		outGame.remove(new Coordinate(0, 1));
		outGame.change();
		outGame.remove(new Coordinate(0, 2));
		outGame.change();
		outGame.remove(new Coordinate(1, 0));
		outGame.change();
		outGame.remove(new Coordinate(1, 1));
		outGame.change();
		outGame.remove(new Coordinate(1, 2));
		for (int i = 0; i < Color.values().length - 1; i++) {
			for (int j = 0; j < Color.values().length - 1; j++) {
				assertEquals(Color.NONE,
						outGame.getColor(new Coordinate(i, j)));
			}
		}
	}

	@Test
	public void testComplete() {
		assertFalse(outGame.complete());
		outGame.put(new Coordinate(0, 0));
		assertFalse(outGame.complete());
		outGame.change();
		outGame.put(new Coordinate(0, 1));
		assertFalse(outGame.complete());
		outGame.change();
		outGame.put(new Coordinate(0, 2));
		assertFalse(outGame.complete());
		outGame.change();
		outGame.put(new Coordinate(1, 0));
		assertFalse(outGame.complete());
		outGame.change();
		outGame.put(new Coordinate(1, 1));
		assertFalse(outGame.complete());
		outGame.change();
		outGame.put(new Coordinate(1, 2));
		assertTrue(outGame.complete());
		outGame.change();
		outGame.remove(new Coordinate(0, 0));
		assertFalse(outGame.complete());
		outGame.change();
		outGame.remove(new Coordinate(0, 1));
		assertFalse(outGame.complete());
		outGame.change();
		outGame.remove(new Coordinate(0, 2));
		assertFalse(outGame.complete());
		outGame.change();
		outGame.remove(new Coordinate(1, 0));
		assertFalse(outGame.complete());
		outGame.change();
		outGame.remove(new Coordinate(1, 1));
		assertFalse(outGame.complete());
		outGame.change();
		outGame.remove(new Coordinate(1, 2));
		assertFalse(outGame.complete());
	}

	@Test
	public void testExistTicTacToe() {
		outGame.put(new Coordinate(0, 0));
		outGame.change();
		outGame.put(new Coordinate(0, 1));
		outGame.change();
		outGame.put(new Coordinate(0, 2));
		outGame.change();
		outGame.put(new Coordinate(1, 0));
		outGame.change();
		outGame.put(new Coordinate(1, 1));
		outGame.change();
		outGame.put(new Coordinate(1, 2));
		assertFalse(outGame.existTicTacToe());
		outGame.change();
		outGame.remove(new Coordinate(0, 0));
		outGame.put(new Coordinate(2, 0));
		assertTrue(outGame.existTicTacToe());
		outGame.remove(new Coordinate(1, 1));
		outGame.put(new Coordinate(2, 2));
	}


	public void testEmpty() {
		assertTrue(outGame.empty(new Coordinate(0, 0)));
		outGame.put(new Coordinate(0, 0));
		assertFalse(outGame.empty(new Coordinate(0, 0)));
		assertTrue(outGame.empty(new Coordinate(0, 1)));
		outGame.put(new Coordinate(0, 1));
		assertFalse(outGame.empty(new Coordinate(0, 1)));
		assertTrue(outGame.empty(new Coordinate(0, 2)));
		outGame.put(new Coordinate(0, 2));
		assertFalse(outGame.empty(new Coordinate(0, 2)));
		assertTrue(outGame.empty(new Coordinate(1, 0)));
		outGame.put(new Coordinate(1, 0));
		assertFalse(outGame.empty(new Coordinate(1, 0)));
		assertTrue(outGame.empty(new Coordinate(1, 1)));
		outGame.put(new Coordinate(1, 1));
		assertFalse(outGame.empty(new Coordinate(1, 1)));
		assertTrue(outGame.empty(new Coordinate(1, 2)));
		outGame.put(new Coordinate(1, 2));
		assertFalse(outGame.empty(new Coordinate(1, 2)));
		outGame.remove(new Coordinate(1, 2));
		assertTrue(outGame.empty(new Coordinate(1, 2)));
		outGame.remove(new Coordinate(1, 1));
		assertTrue(outGame.empty(new Coordinate(1, 1)));
		outGame.remove(new Coordinate(1, 0));
		assertTrue(outGame.empty(new Coordinate(1, 0)));
		outGame.remove(new Coordinate(0, 2));
		assertTrue(outGame.empty(new Coordinate(0, 2)));
		outGame.remove(new Coordinate(0, 1));
		assertTrue(outGame.empty(new Coordinate(0, 1)));
		outGame.remove(new Coordinate(0, 0));
		assertTrue(outGame.empty(new Coordinate(0, 0)));
	}


	public void testFull() {
		assertFalse(outGame.full(new Coordinate(0, 0)));
		outGame.put(new Coordinate(0, 0));
		assertTrue(outGame.full(new Coordinate(0, 0)));
		assertFalse(outGame.full(new Coordinate(0, 1)));
		outGame.put(new Coordinate(0, 1));
		assertTrue(outGame.full(new Coordinate(0, 1)));
		assertFalse(outGame.full(new Coordinate(0, 2)));
		outGame.put(new Coordinate(0, 2));
		assertTrue(outGame.full(new Coordinate(0, 2)));
		assertFalse(outGame.full(new Coordinate(1, 0)));
		outGame.put(new Coordinate(1, 0));
		assertTrue(outGame.full(new Coordinate(1, 0)));
		assertFalse(outGame.full(new Coordinate(1, 1)));
		outGame.put(new Coordinate(1, 1));
		assertTrue(outGame.full(new Coordinate(1, 1)));
		assertFalse(outGame.full(new Coordinate(1, 2)));
		outGame.put(new Coordinate(1, 2));
		assertTrue(outGame.full(new Coordinate(1, 2)));
		outGame.remove(new Coordinate(1, 2));
		assertFalse(outGame.full(new Coordinate(1, 2)));
		outGame.remove(new Coordinate(1, 1));
		assertFalse(outGame.full(new Coordinate(1, 1)));
		outGame.remove(new Coordinate(1, 0));
		assertFalse(outGame.full(new Coordinate(1, 0)));
		outGame.remove(new Coordinate(0, 2));
		assertFalse(outGame.full(new Coordinate(0, 2)));
		outGame.remove(new Coordinate(0, 1));
		assertFalse(outGame.full(new Coordinate(0, 1)));
		outGame.remove(new Coordinate(0, 0));
		assertFalse(outGame.full(new Coordinate(0, 0)));
	}


	public void testPutSameColorWithException() {
		outGame.put(new Coordinate(0, 0));
		outGame.put(new Coordinate(0, 0));
	}


	public void testPutDistinctColorWithException() {
		outGame.put(new Coordinate(0, 0));
		outGame.put(new Coordinate(0, 0));
	}


	public void testRemoveEmptyWithException() {
		outGame.remove(new Coordinate(0, 0));
	}


	public void testRemoveDistinctColorWithException() {
		outGame.put(new Coordinate(0, 0));
		outGame.remove(new Coordinate(0, 0));
	}


	public void testClear() {
		outGame.put(new Coordinate(0, 0));
		outGame.put(new Coordinate(0, 1));
		outGame.put(new Coordinate(0, 2));
		outGame.put(new Coordinate(1, 0));
		outGame.put(new Coordinate(1, 1));
		outGame.put(new Coordinate(1, 2));
		outGame.clear();
		for (int i = 0; i < Color.values().length - 1; i++) {
			for (int j = 0; j < Color.values().length - 1; j++) {
				assertEquals(Color.NONE,
						outGame.getColor(new Coordinate(i, j)));
			}
		}
	}

}
