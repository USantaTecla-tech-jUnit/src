package integration;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import ticTacToe.models.Color;
import ticTacToe.models.Coordinate;
import ticTacToe.models.DecisionTreeBoard;

public class DecisionTreeBoardTest {
	
	private DecisionTreeBoard board;
	
	@Test
	public void testWrite() {
		board = new DecisionTreeBoard();
		board.put(new Coordinate(0,0), Color.XS);
		board.put(new Coordinate(2,1), Color.OS);
		board.put(new Coordinate(1,1), Color.XS);
		board.put(new Coordinate(2,2), Color.OS);
		board.writeFile("pruebaEscritura2");	
		String[] expected = new String[] {
				"0 2 2 ", 
				"2 0 2 ", 
				"2 1 1 ", };
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("pruebaEscritura.ttt"));
			for(int i=0; i<3; i++){
				assertEquals(expected[i], in.readLine());
			}
		} catch (IOException ex) {
			fail("IOException al leer: " + ex.getMessage());
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException ex) {
					fail("IOException al cerrar: " + ex.getMessage());
				}
			}
		}

	}
	
	@Test
	public void testRead() {
		board = new DecisionTreeBoard();
		board.readFile("pruebaLectura");
		assertEquals(Color.XS, board.getColor(new Coordinate(0,0)));
		assertEquals(Color.NONE, board.getColor(new Coordinate(0,1)));
		assertEquals(Color.NONE, board.getColor(new Coordinate(0,2)));
		assertEquals(Color.NONE, board.getColor(new Coordinate(1,0)));
		assertEquals(Color.XS, board.getColor(new Coordinate(1,1)));
		assertEquals(Color.NONE, board.getColor(new Coordinate(1,2)));
		assertEquals(Color.NONE, board.getColor(new Coordinate(2,0)));
		assertEquals(Color.OS, board.getColor(new Coordinate(2,1)));
		assertEquals(Color.OS, board.getColor(new Coordinate(2,2)));
	}

}
