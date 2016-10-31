package nb.bean;

/**
 * Created by Iryna_Filipava1 on 10/30/2016.
 */
public class AddTestQuestionsRequest extends Request {

    private String quest;
    private String answer;
    private String wrong;
    private int subject;
    private int userId;

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public String getQuest() {
        return quest;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setWrong(String wrong) {
        this.wrong = wrong;
    }

    public String getWrong() {
        return wrong;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

