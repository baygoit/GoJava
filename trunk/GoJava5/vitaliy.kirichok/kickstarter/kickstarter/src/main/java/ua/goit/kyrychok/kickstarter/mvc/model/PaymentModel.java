package ua.goit.kyrychok.kickstarter.mvc.model;

public class PaymentModel extends BaseModel {
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void store(int categoryIndex, int projectIndex) {
        getDataProvider().incProjectBalance(categoryIndex, projectIndex, amount);
    }
}
