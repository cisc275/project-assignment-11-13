public enum GameState {
	FOODGAME("foodGame"),
	NESTGAME("nestGame"),
	MIGRATION("migrationGame"),
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
