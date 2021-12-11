package masterMind.presenters;

import static org.junit.Assert.*;

import masterMind.models.Game;
import masterMind.models.Limits;

import org.junit.Before;
import org.junit.Test;

public class SystemTest {

	Limits limits;
	Game game;
	LimitsPresenter limitsPresenter;
	GamePresenter gamePresenter;

	@Before
	public void before() {
		limits = new Limits();
		game = new Game(limits);
		limitsPresenter = new LimitsPresenter(limits);
		gamePresenter = new GamePresenter(game);
	}

	@Test
	public void test1() {
		limitsPresenter.setCombinationLength(3);
		limitsPresenter.setCombinationColors(4);
		limitsPresenter.apply();
		gamePresenter.reset();
		String[] secretColors = gamePresenter.getSecretColors();
		gamePresenter.setProposalColors(secretColors);
		assertTrue(gamePresenter.isGameOver());
	}

}
