package nb.view;

import nb.bean.*;
import nb.bean.dao.impl.pool.ConnectionPool;
import nb.bean.entity.Questions;
import nb.bean.entity.User;
import nb.controller.Controller;

import java.util.Scanner;

public class View {

 /*   private static String menu = "\"exit - exit from applicaion.\nin - authentication.\nup - registration.";

    private static String menu1 = "exit - exit from applicaion.\nadd - find note by content."
            + "\ndate - find note by date.\nshow - show all notes."
            + "\nclear - clear notebook.\nfind - find notes.";


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print(menu);
            Controller controller = new Controller();
            System.out.println("\nEnter your command, please");
            String string = reader.readLine();
            Response response;

            switch (string) {
                case "exit":
                    reader.close();
                    ConnectionPool.getInstance().closePool();
                    return;
                case "up":
                    System.out.println("Enter your login:");
                    String loginReg = reader.readLine();
                    System.out.println("Enter your password:");
                    String passwordReg = reader.readLine();
                    RegistrationRequest registrationRequest = new RegistrationRequest();
                    registrationRequest.setCommandName("REGISTRATION");
                    registrationRequest.setLogin(loginReg);
                    registrationRequest.setPassword(passwordReg);
                    response = controller.doRequest(registrationRequest);
                    if (response.isErrorStatus() == false) {
                        System.out.println(response.getResultMessage());
                    } else {
                        System.out.println(response.getErrorMessage());
                    }
                    break;
                case "in":
                    System.out.println("Enter your login:");
                    String loginIn = reader.readLine();
                    System.out.println("Enter your password:");
                    String passwordIn = reader.readLine();
                    AuthenticationRequest authenticationRequest = new AuthenticationRequest();
                    authenticationRequest.setCommandName("AUTHENTICATION");
                    authenticationRequest.setLogin(loginIn);
                    authenticationRequest.setPassword(passwordIn);
                    response = controller.doRequest(authenticationRequest);
                    if (!response.isErrorStatus() == false) {
                        System.out.println(response.getErrorMessage());
                    } else {
                        AuthenticationResponse resp = (AuthenticationResponse) response;
                        User currentUser = resp.getUser();
                        int sessionId = currentUser.getId();
                        System.out.println("Hello, " + currentUser.getLogin() + "!");*/

    private static final Controller controller = new Controller();
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean key = true;
    private static String Tutor = "1 - add new question.\n2 - create the test.";
    private static String Student = "3 - Look at list of tests.\n4 - pass the exam.";

    public static void main(String[] args) throws Exception {

        System.out.println("Good Morning");

        while (key) {
            System.out.print("Enter 1 for authentication, 2 for registration, -1 for exit: ");
            String mainCommand = scanner.nextLine();
            switch (mainCommand) {
                case "1":
                    System.out.print("Enter your login: ");
                    String authLogin = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String authPassword = scanner.nextLine();
                    AuthenticationRequest authenticationRequest = new AuthenticationRequest();
                    authenticationRequest.setLogin(authLogin);
                    authenticationRequest.setPassword(authPassword);
                    authenticationRequest.setCommandName("AUTHENTICATION");
                    AuthenticationResponse authenticationResponse = (AuthenticationResponse) controller
                            .doRequest(authenticationRequest);
                    if (!authenticationResponse.isErrorStatus()) {
                        User currentUser = authenticationResponse.getUser();
                        int sessionId = currentUser.getId();
                        String role = currentUser.getStatus();
                        System.out.println("Hello, " + role + "!");
                        while (true) {
                            System.out.print("Enter 'any key' or -1 for logout:");
                            String localCommand = scanner.nextLine();

                            if (localCommand.equals("-1")) {
                                System.out.println("Good luck");
                                break;
                            }

                            switch (localCommand) {
                                case "any key":
                                    if (role.equals("student")) {
                                        System.out.println(Student);
                                        break;
                                    } else if (role.equals("tutor")) {
                                        System.out.println(Tutor);
                                        break;
                                    }

                                case "1":
                                    System.out.print("Enter  the number of subject: ");
                                    int subject = new Scanner(System.in).nextInt();
                                    System.out.print("Enter a new question: ");
                                    String quest = new Scanner(System.in).nextLine();
                                    System.out.print("Enter the right answer: ");
                                    String answer = new Scanner(System.in).nextLine();
                                    System.out.print("Enter the wrong answer: ");
                                    String wrong = new Scanner(System.in).nextLine();
                                    AddTestQuestionsRequest addTestQuestionsRequest = new AddTestQuestionsRequest();
                                    addTestQuestionsRequest.setCommandName("ADD_NEW_QUEST");
                                    addTestQuestionsRequest.setAnswer(answer);
                                    addTestQuestionsRequest.setWrong(wrong);
                                    addTestQuestionsRequest.setQuest(quest);
                                    addTestQuestionsRequest.setSubject(subject);
                                    addTestQuestionsRequest.setUserId(sessionId);
                                    Response addQuestResponse = controller.doRequest(addTestQuestionsRequest);
                                    if (addQuestResponse.isErrorStatus() == false) {
                                        System.out.println(addQuestResponse.getResultMessage());
                                    } else {
                                        System.out.println(addQuestResponse.getErrorMessage());
                                    }
                                    break;
                                case "2":
                                    System.out.print("Enter  the number of subject: ");
                                    int choisesubject = new Scanner(System.in).nextInt();
                                    System.out.print("Enter a number of test, what you want to create: ");
                                    int numberOfTest = new Scanner(System.in).nextInt();
                                    System.out.print("Enter how many tests should be include in the test ");
                                    int amtOfTests = new Scanner(System.in).nextInt();

                                    AddTestRequest createTest = new AddTestRequest();
                                    createTest.setCommandName("ADD_NEW_TEST");
                                    createTest.setSubject(choisesubject);
                                    createTest.setnumberTest(numberOfTest);
                                    createTest.setamtOfTests(amtOfTests);

                                    Response addTestResponse = controller.doRequest(createTest);
                                    if (addTestResponse.isErrorStatus() == false) {
                                        System.out.println(addTestResponse.getResultMessage());
                                    } else {
                                        System.out.println(addTestResponse.getErrorMessage());
                                    }
                                    break;

                                case "3":
                                    System.out.print("Enter the number of test ");
                                    int testId = new Scanner(System.in).nextInt();
                                    ChoiceTestByNameRequest choiceTestByNameRequestTestRequest = new ChoiceTestByNameRequest();
                                    choiceTestByNameRequestTestRequest.setCommandName("FIND_TEST");
                                    choiceTestByNameRequestTestRequest.setTestId(testId);
                                    choiceTestByNameRequestTestRequest.setUserId(sessionId);

                                    ShowTestResponse showTests = (ShowTestResponse) controller.doRequest(choiceTestByNameRequestTestRequest);
                                    if (showTests.isErrorStatus() == false) {
                                        if (showTests.getList().size() == 0) {
                                            System.out.println("Result is empty");
                                        } else {
                                            for (Questions k : showTests.getList()) {
                                                System.out.println(k);
                                            }
                                        }
                                    } else {
                                        System.out.println(showTests.getErrorMessage());
                                    }
                                    break;
                                case "4":
                                    System.out.print("Enter the number of test ");
                                    int testId2 = new Scanner(System.in).nextInt();
                                    ChoiceTestByNameRequest choiceTestByNameRequest2 = new ChoiceTestByNameRequest();
                                    choiceTestByNameRequest2.setCommandName("FIND_TEST");
                                    choiceTestByNameRequest2.setTestId(testId2);
                                    choiceTestByNameRequest2.setUserId(sessionId);

                                    ShowTestResponse showTests1 = (ShowTestResponse) controller.doRequest(choiceTestByNameRequest2);
                                    if (showTests1.isErrorStatus() == false) {
                                        if (showTests1.getList().size() == 0) {
                                            System.out.println("List is empty");
                                        } else {

                                            for (Questions element : showTests1.getList()) {

                                                element.printQuestions();
                                                System.out.println("Enter the correct answer ");
                                                System.out.println("correct answer " + element.getRightAnsId());
                                                int userAnswer = new Scanner(System.in).nextInt();
                                                if (userAnswer == element.getRightAnsId()) {
                                                    System.out.println("you're right");
                                                } else {
                                                    System.out.println("you are not right");
                                                }
                                            }

                                        }
                                    } else {
                                        System.out.println(showTests1.getErrorMessage());
                                    }
                                    break;

                            }
                        }
                    } else {
                        System.out.println(authenticationResponse.getErrorMessage());
                    }
                    break;
                // REGISTRATION
                case "2":
                    System.out.print("Enter your login: ");
                    String regLogin = scanner.nextLine();
                    ;
                    System.out.print("Enter your password: ");
                    String regPassword = scanner.nextLine();
                    ;
                    RegistrationRequest registrationRequest = new RegistrationRequest();
                    registrationRequest.setCommandName("REGISTRATION");
                    registrationRequest.setLogin(regLogin);
                    registrationRequest.setPassword(regPassword);
                    Response registrationResponse = controller.doRequest(registrationRequest);
                    if (registrationResponse.isErrorStatus() == false) {
                        System.out.println(registrationResponse.getResultMessage());
                    } else {
                        System.out.println(registrationResponse.getErrorMessage());
                    }
                    break;
                case "-1":
                    System.out.println("Good luck!");
                    ConnectionPool.getInstance().closePool();
                    key = false;
                    break;
                default:
                    System.out.println("Command does not exits!");
                    break;
            }
        }

    }
}