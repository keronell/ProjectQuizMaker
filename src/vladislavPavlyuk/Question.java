package vladislavPavlyuk;

public class Question {

    //Class attributes
    private String question;                // - Question string
    private Boolean[] boolAnsType;          // - Mark correct answer in boolean array
    private int[] fitAns;                   // - Link answer from answers tray to int array of the question
    private int ansCount;                   // - Answer counter
    private int correctAnsCount=0;          // - Correct answer counter (for Exam printing)
    private final int MAX_ANS = 10;         // - Max answers counter (can be replaced by number 10)
    private int questionID;                 // - Question ID
    private static int questionCounter;     // - Question counter
    private String correctAnswer;           // - Correct answer for open question



    public Question(String question) {                       // - Multiple choise question constractor 
        setQuestion(question);                                  // - Set question
        this.boolAnsType = new Boolean[MAX_ANS];                // - Creates array of booleans (size of Max answers)
        this.fitAns = new int[MAX_ANS];                         // - Creates array of answers (size of Max answers)
        this.ansCount = 0;                                      // - Counter of answers reset
        setID();                                                // - Sets question unic ID
    }

    public Question(String question, String correctAnswer){  // - Open question constractor
        setQuestion(question);                                  // - Set question
        setID();                                                // - Sets question unic ID 
        setAnswer(correctAnswer);                               // - Sets Answer to open question
    }
    public void setID(){
        this.questionID = questionCounter;                      // - sets question ID number
        questionCounter++;                                      // - adds +1 to question counter
    }
    public void setQuestion(String question) {                  // - Set question function
        this.question = question;
    }

    public void setAnswer(String answer) {                  // - Set question function
        this.correctAnswer = answer;
    }
   
    public void setAnswer(int ansNum, Boolean ansType) {    // - Set answer function that takes index of answer and if it correct or not 
        if (ansCount < MAX_ANS) {                               // - Checks if answer can fit in answers array (max = 10 answers)
            this.fitAns[ansCount] = ansNum;                     // - Link answer index from tray to array of answers in this question
            this.boolAnsType[ansCount] = ansType;               // - Sets if the answer is correct or not
            ansCount++;                                         // - answers counter +1
            if(ansType)                                         // - if the answer if correct
                correctAnsCount++;                              //   correct answers +1
            return;
        }
        System.out.println(
                "\nOut of limit answers per question.\nRemove answer before adding a new one \n(max number of answers is 10)");

    }

    public void deleteAns(int ansNum) {                     // - Function that deletes answer from question (only the link)
        if(this.boolAnsType[ansNum])                            // - Checks if the answer was correct and resets counter of correct answers
            correctAnsCount--;
        if (ansNum < ansCount)
            this.fitAns[ansNum] = 0;
        else
            System.out.println("There is no such answer in this question!");

        for (int i = ansNum; i < ansCount - 1; i++)             // - Moving all answers links in answers array to fill the hole
            this.fitAns[i] = this.fitAns[i + 1];
        
        this.fitAns[ansCount - 1] = 0;                          // - Sets the deleted answer as 0 - that means there is no answer
        ansCount--;                                             // - Resets the answer counter 
    }

    // - All get function for class attributes
    public int getCorrectAnsCount(){
        return correctAnsCount;
    }

    public String getQuestion() {
        return question;
    }

    public int getFitAns(int num) {
        return fitAns[num];
    }

    public int getAnsCount() {
        return this.ansCount;
    }

    public Boolean getboolAnsType(int i) {
        return boolAnsType[i];
    }

    public int getQuestionID() {
        return this.questionID;
    }
    
    public String getCorrectAnswer(){
        return this.correctAnswer;
    }
}
