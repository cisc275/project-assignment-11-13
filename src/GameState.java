public enum GameState {
	FOODGAME("FoodGame"),
	NESTGAME("NestGame"),
	MIGRATIONGAME("MigrationGame"),
	STARTMENU("start"),
	SCOREBOARD("score");
	
	
	private String name = null;
	
	private GameState(String s){
		name = s;
	}
	public String getState() {
		return name;
	}


}
