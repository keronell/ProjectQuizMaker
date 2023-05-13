package vladislavPavlyuk;

public abstract class BaseQ {
    
   protected int questionID;
   protected static int questionCounter;
   
   protected enum DifficultyLevel {EASY, NORMAL, HARD}
   protected DifficultyLevel difficultyLevel;

   public BaseQ(DifficultyLevel difficultyLevel){
    setDifficultyLevel(difficultyLevel);
    setID();                                                    // - Sets question unic ID
   }
   

    public void setID(){
        this.questionID = questionCounter;                      // - sets question ID number
        questionCounter++;                                      // - adds +1 to question counter
    }
    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public int getQuestionID() {
     return this.questionID;
    }

    public abstract String getQuestion();

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }
    
}
