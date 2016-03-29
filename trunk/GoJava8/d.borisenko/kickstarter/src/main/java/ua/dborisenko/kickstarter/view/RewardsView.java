package ua.dborisenko.kickstarter.view;

import java.io.PrintWriter;

import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Reward;

public class RewardsView extends View {

    public void show(PrintWriter writer, Project project) {
        this.pageTitle = "Investment";
        addContentString(getHeaderBlock());
        addContentString("Project " + project.getName() + "<br/>");
        addContentString("Money left to collect: " + (project.getRequiredSum() - project.getCollectedSum()) + "<br/>");
        addContentString("Select your reward:<br/><hr>");
        addContentString("<form name='add_investment' method='POST' action='' accept-charset='utf-8'>");
        addContentString("<input type='hidden' name='requested_action' value='ADD_INVESTMENT'>");
        addContentString("<input type='hidden' name='project_id' value='" + project.getId() + "'>");
        for (Reward reward : project.getRewards()) {
            addContentString("<input type='radio' name='amount' value='" + reward.getAmount() + "'>$ "
                    + reward.getAmount() + " - " + reward.getDescription() + "</input><br/>");
        }
        addContentString("<input type='radio' name='amount' value=0 checked>Custom amount</input><br/>");
        addContentString("<hr>");
        addContentString(
                "<label>Custom amount sum (It can`t becomes an unavailable until Javascript is absent yet)</label><br/>");
        addContentString("<input type='number' name='custom_amount' value='0'/></br>");
        addContentString("<label>Cardholder name</label><br/>");
        addContentString("<input type='text' name='cardholder_name'/><br>");
        addContentString("<label>Card number</label><br/>");
        addContentString("<input type='text' name='card_number'/><br/>");
        addContentString("<input type='submit' value='Invest'/><br/>");
        addContentString("</form>");
        addContentString("<a href='?page=project&id=" + project.getId() + "'>Return to the project page</a>");
        writer.println(content.toString());
    }
}
