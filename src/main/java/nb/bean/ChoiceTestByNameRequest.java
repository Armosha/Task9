package nb.bean;

/**
 * Created by Iryna Filipava on 06.10.2016.
 */

public class ChoiceTestByNameRequest extends Request {

    private String content;
    private int userId;
    private int testId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public int getTestId() {
        return testId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }
}
