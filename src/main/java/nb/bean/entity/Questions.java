package nb.bean.entity;

/**
 * Created by Iryna_Filipava1 on 10/25/2016.
 */
public class Questions {

    private String data;
    private int subject;
    private int testId;
    private int rightAnsId;
    private String answer;
    private String wrongAnsw;

    public int getRightAnsId() {
        return rightAnsId;
    }

    public void setRightAnsId(int rightAnsId) {
        this.rightAnsId = rightAnsId;
    }

    public String getWrongAnsw() {
        return wrongAnsw;
    }

    public void setWrongAnsw(String wrongAnsw) {
        this.wrongAnsw = wrongAnsw;
    }

    public Questions(String data) {
        this.data = data;
    }

    public Questions(String data, int subject, String answer, String wrongAnsw) {
        this.data = data;
        this.subject = subject;
        this.answer = answer;
        this.wrongAnsw = wrongAnsw;
    }

    public Questions(String data, int testId) {
        this.data = data;
        this.testId = testId;
    }

    public Questions(String data, int test, int rightAnsId) {
        this.data = data;
        this.rightAnsId = rightAnsId;
        this.testId = test;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getSubject() {
        return subject;
    }

    public int getTestId() {
        return testId;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public void printQuestions() {
        System.out.println(this.data);
    }

}
