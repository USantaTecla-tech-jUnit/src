package masterMind;

import masterMind.models.Game;
import masterMind.models.Limits;
import masterMind.presenters.LimitsPresenter;
import masterMind.presenters.GamePresenter;
import masterMind.views.MainView;

public class MasterMind {

	public MasterMind() {
		Limits limits = new Limits();
		Game game = new Game(limits);
		LimitsPresenter limitsPresenter = new LimitsPresenter(limits);
		GamePresenter gamePresenter = new GamePresenter(game);
		new MainView(limitsPresenter, gamePresenter);
	}
	
	public static void main(String[] args){
		new MasterMind();
	}
}
