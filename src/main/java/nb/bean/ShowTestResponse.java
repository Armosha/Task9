package nb.bean;

import nb.bean.entity.Questions;

import java.util.List;

/**
 * Created by Iryna Filipava on 06.10.2016.
 */
public class ShowTestResponse extends Response {

    private List<Questions> list = null;
    private int userId;
    private int testId;

    public List<Questions> getList() {
        return list;
    }

    public void setList(List<Questions> list) {
        this.list = list;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}