package tyomsky.kickstarter;

import java.util.ArrayList;
import java.util.List;

public class BootStrap {

    public static void main(String[] args) {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("Games"));
        categoryList.add(new Category("Music"));
        categoryList.add(new Category("Sport"));

        Kickstarter kickstarter = new Kickstarter(categoryList);
        kickstarter.run();
    }

//    UserStory2 Как гость я хочу видеть список категорий, с тем чтобы сфокусироваться на интересующей меня теме
//    сценарий 1: захожу в приложение -> вижу пронумерованный список категорий и запрос на выбор категории ->
//    выбираю категорию по номеру -> вижу сообщение о том, что я выбрал

}
