/**
 * the enum gameState allows for an enumerated type that is used to define gamestate
 *
 */

public enum GameState {
	FOODGAME("FoodGame"),
	FOODQUIZ("FoodQuiz"),
	NESTGAME("NestGame"),
	MIGRATIONGAME("MigrationGame"),
	STARTMENU("start"),
	SCOREBOARD("score"),
	NESTQUIZ("NestQuiz");
	
	
	private String name = null;
	
	/**
	 * The method is used to define the gamestate based on string input
	 * 
	 * @param s defines the gamestate
	 */
	private GameState(String s){
		name = s;
	}
	
	/**
	 * The getState method is a getter for the string that represents
	 * the gameState
	 * 
	 * @return name the string that represents the gameState
	 */
	public String getState() {
		return name;
	}


}
