public enum GameState {
	FOODGAME("FoodGame"),
	NESTGAME("NestGame"),
	MIGRATIONGAME("MigrationGame"),
	STARTMENU("start"),
	SCOREBOARD("score"),
	NESTQUIZ("NestQuiz");
	
	
	private String name = null;
	
	private GameState(String s){
		name = s;
	}
	public String getState() {
		return name;
	}


}
