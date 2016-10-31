package nb.bean;

/**
 * Created by Iryna_Filipava1 on 10/25/2016.
 */
public class AddTestRequest extends Request {

    private String quest;
    private int subject;
    private int numberTest;
    private int amtOfTests;

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public int getSubject() {
        return subject;
    }

    public void setnumberTest(int numberTest) {
        this.numberTest = numberTest;
    }

    public int getnumberTest() {
        return numberTest;
    }

    public void setamtOfTests(int quantityOfTests) {
        this.amtOfTests = quantityOfTests;
    }

    public int getamtOfTests() {
        return amtOfTests;
    }


    public String getQuest() {
        return quest;
    }

    public void setQuest(String qui) {
        this.quest = quest;
    }

}
