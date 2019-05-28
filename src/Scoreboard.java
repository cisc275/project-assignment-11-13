import java.util.*;

@SuppressWarnings("serial")
// Scoreboard class is further below in this file.
// Scores are merely the element components comprising the Scoreboard.
class Score implements Comparable<Score>, java.io.Serializable{
	
	int foodgame_score;
	int nestgame_score;
	int cumulative_score;
	
	/**
	 * Constructor for Score object; initializes three scoring criteria
	 * @param foodgamescore
	 * @param nestgamescore
	 */
	Score(int foodgamescore, int nestgamescore){
		foodgame_score = foodgamescore;
		nestgame_score = nestgamescore;
		cumulative_score = foodgamescore + nestgamescore;
	}
	
	/**
	 * Checker to see if the score is greater than a previous score; used for the scoreboard ordering
	 * 
	 * @return int
	 */
	public int compareTo(Score other) {
		if(this.cumulative_score <= other.cumulative_score) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
}

@SuppressWarnings("serial")
public class Scoreboard implements java.io.Serializable{

	private ArrayList<Score> scores;
	private static final int MAX_SCOREBOARD_SIZE = 10;
	
	/**
	 * Constructor for the Scoreboard class
	 */
    public Scoreboard(){
    	scores = new ArrayList<Score>();
    }
    
    /**
     * Adds a valued score to the scoreboard
     * 
     * @return void
     * @param foodgame_score
     * @param nestgame_score
     */
    public void addScore(int foodgame_score, int nestgame_score) {
    	scores.add(new Score(foodgame_score, nestgame_score));
    	scores.sort((s1, s2) -> s1.compareTo(s2));
    	if(scores.size() > MAX_SCOREBOARD_SIZE) {
    		scores.remove(MAX_SCOREBOARD_SIZE);
    	}
    	scores.trimToSize();
    }
    
    /**
     * Retrieves the scores
     * 
     * @return ArrayList<Score>
     */
    public ArrayList<Score> getScores(){
    	return scores;
    }
    
}
