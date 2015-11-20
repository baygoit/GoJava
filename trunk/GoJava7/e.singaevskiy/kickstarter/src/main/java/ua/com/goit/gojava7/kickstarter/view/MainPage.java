package ua.com.goit.gojava7.kickstarter.view;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.beans.Reward;

public class MainPage {

    PrintStream outStream;

    public MainPage(PrintStream outStream) {
        this.outStream = outStream;
    }

    public void showQuote(Quote quote) {
        outStream.println("\"" + quote.getText() + "\" - " + quote.getAuthor() + "\n");
    }

    public void showCategories(List<Category> categories) {
        outStream.print("Categories: | ");
        for (int i = 1; i <= categories.size(); i++) {
            outStream.print(String.valueOf(i) + ". " + categories.get(i - 1).getName() + " | ");
        }
        showExit();
    }

    public void showProjects(Collection<Project> projects) {
        int i = 1;
        for (Iterator<Project> iterator = projects.iterator(); iterator.hasNext();) {
            Project project = iterator.next();
            outStream.println(i++ + ". " + project);
            outStream.println("\t" + "Goal: " + project.getGoalSum() + "; Balance: " + project.getBalanceSum()
                    + "; Days left: " + project.daysLeft());
        }

        showExit();
    }

    public void showProjectDetails(Project project) {
        outStream.println(project);
        outStream.println(project.getDescription());
        outStream.println("Goal: " + project.getGoalSum());
        outStream.println("Balance: " + project.getBalanceSum());
        outStream.println("Started:" + project.getEndDate());
        outStream.println("Days left: " + project.daysLeft());
        outStream.println("Video: " + project.getVideoUrl());
        outStream.println("FAQ:");
        project.getQuestionsAndAnswers().stream().map(faq -> "\t" + faq.toString()).forEach(outStream::println);

        outStream.println("1. Send message");
        outStream.println("2. Pay");

        showExit();
    }

    public void showMessageRequest() {
        outStream.print("Enter your message: ");
    }

    public void showShortProject(Project project) {
        outStream.println(project);
    }

    public void showPaymentRequest(Project project) {
        showShortProject(project);
        outStream.println("Enter your name, card ID and sum, divided by ' '");
    }

    public void showRewards(List<Reward> rewards) {
        if (!rewards.isEmpty()) {
            for (int i = 0; i < rewards.size(); i++) {
                Reward reward = rewards.get(i);
                outStream.println(i + 1 + ". Pay $" + reward.getPledgeSum() + " : " + reward.getDescription());
            }
        }
        outStream.println((rewards.size() + 1) + ". Pay any amount you like");
        showExit();
    }

    private void showExit() {
        outStream.println("0. Exit");
    }

    public void showDivider() {
        outStream.println("==========================================");
    }

    public void showMessage(String message) {
        outStream.println(message);
    }

}
