import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class Controller implements ActionListener, KeyListener {
    private View view;
    private ViewStartMenu startView;
    private ViewFoodGame foodView;
    private Model model;
	private PlayableBird mainBird;
	private DropBird dropbird;
	private Foe foe;
	private GameState gs;

    Controller(){
    	gs = GameState.STARTMENU;
    	startView = new ViewStartMenu();
    	gs = startView.gs;
    	gs = GameState.FOODGAME;
    	checkGameState();

    }

    private void checkGameState(){
		switch (gs){
			case FOODGAME:
				foodView = new ViewFoodGame();
				mainBird = new PlayableBird("ProjectPics/Osprey.png", "Osprey");
				foe = new Foe("ProjectPics/Eagle.png", "Eagle", view.getWidth(), view.getHeight());
				model = new Model(view.getWidth(), view.getHeight(), mainBird, foe);
				foodView.addObjects(mainBird, foe);

				view.frame.addKeyListener(new KeyListener() {
					public void keyPressed(KeyEvent e) {
						if (e.getKeyCode() == KeyEvent.VK_UP) {
							mainBird.setUpPressed(true);
						}
						else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
							mainBird.setDownPressed(true);
						}
						else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
							mainBird.setSpacePressed(true);
						}
						if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
							System.exit(1);
						}
					}

					@Override
					public void keyTyped(KeyEvent e) {
						//In place just to have all required methods
					}

					@Override
					public void keyReleased(KeyEvent e) {
						if (e.getKeyCode() == KeyEvent.VK_UP) {
							mainBird.setUpPressed(false);
						}
						else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
							mainBird.setDownPressed(false);
						}
						else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
							mainBird.setSpacePressed(false);

						}
					}
				});

				start();
				break;
			case NESTGAME:
				//Launch View and listener stuff for Osprey/Clapper Rail nest game
				view =  new ViewNestGame();
				model = new ModelNestGame(view.getWidth(), view.getHeight(), dropbird);
				view.frame.addKeyListener(new KeyListener() {
					public void keyPressed(KeyEvent e) {
						if (e.getKeyCode() == KeyEvent.VK_SPACE) {
							dropbird.dropStick();
						}
					}

					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				break;
			case MIGRATIONGAME:
				//Launch View and listener stuff for Osprey migration game
				break;
			case SCOREBOARD:
				//Launch View and listener stuff for the scoreboard
				break;
			default:
				startView = new ViewStartMenu();

				startView.frame.addKeyListener(new KeyListener() {


					public void keyPressed(KeyEvent e){
						if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
							System.exit(1);
						}
					}
					@Override
					public void keyTyped(KeyEvent e) {
						//Required Method
					}

					@Override
					public void keyReleased(KeyEvent e) {
						//Required Method
					}
				});

				startView.ospreyButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						startView.gs = GameState.FOODGAME;
						gs = GameState.FOODGAME;
						startView.checkGameState();
						checkGameState();
					}
				});

				startView.clapperButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						startView.gs = GameState.FOODGAME;
						gs = GameState.FOODGAME;
						System.out.println("Clapper Clicked");

						checkGameState();
					}
				});
				break;

		}
	}

	void start(){
		while(true) {
			model.update();
			foodView.update(mainBird.xPos, mainBird.yPos, mainBird, foe);
		}
	}

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public GameState getGS(){
    	return this.gs;
	}

	public void setGS(GameState gs){
    	this.gs = gs;
	}
}