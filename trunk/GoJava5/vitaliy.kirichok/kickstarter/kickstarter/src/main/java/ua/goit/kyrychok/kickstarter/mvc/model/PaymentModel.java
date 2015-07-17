package ua.goit.kyrychok.kickstarter.mvc.model;

public class PaymentModel extends BaseModel {
    public void store(int categoryIndex, int projectIndex, Integer amount) {
        getDataProvider().incProjectBalance(categoryIndex, projectIndex, amount);
    }
}
