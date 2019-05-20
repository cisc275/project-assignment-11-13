import java.util.*;

// Scoreboard class is further below in this file.
// Scores are merely the element components comprising the Scoreboard.
class Score implements Comparable<Score>, java.io.Serializable{
	
	int foodgame_score;
	int nestgame_score;
	int cumulative_score;
	
	Score(int foodgamescore, int nestgamescore){
		foodgame_score = foodgamescore;
		nestgame_score = nestgamescore;
		cumulative_score = foodgamescore + nestgamescore;
	}
	
	public int compareTo(Score other) {
		if(this.cumulative_score <= other.cumulative_score) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
}

public class Scoreboard implements java.io.Serializable{

	private ArrayList<Score> scores;
	private static final int MAX_SCOREBOARD_SIZE = 10;
	
    public Scoreboard(){
    	scores = new ArrayList<Score>();
    }
    
    public void addScore(int foodgame_score, int nestgame_score) {
    	scores.add(new Score(foodgame_score, nestgame_score));
    	scores.sort((s1, s2) -> s1.compareTo(s2));
    	if(scores.size() > MAX_SCOREBOARD_SIZE) {
    		scores.remove(MAX_SCOREBOARD_SIZE);
    	}
    	scores.trimToSize();
    }
    
    public ArrayList<Score> getScores(){
    	return scores;
    }
    
}
