package com.morkva.model;

import com.morkva.entities.Category;
import com.morkva.entities.Quote;
import com.morkva.model.impl.RepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by vladyslav on 11.05.15.
 */
public class RepositoryImplTest {

    Category[] categories;
    Quote[] quotes;

    Repository<Category> categoryRepository;
    Repository<Quote> quoteRepository;

    @Before
    public void setUpAll() throws Exception {
        categories = new Category[] {
                new Category(3, "Name 3"),
                new Category(2, "Name 2"),
                new Category(1, "Name 1"),
                new Category(4, "Name 4")
        };

        quotes = new Quote[] {
                new Quote(1, "Test Quote", "Test author"),
                new Quote(2, "«Пользователь» — слово, используемое компьютерщиками-профессионалами вместо слова «идиот».", "Дейв Барри"),
                new Quote(3, "Каждый дурак может написать программу, которую может понять компьютер. Хороший программист пишет программу, которую может понять человек.", "Мартин Фаулер"),
                new Quote(4, "Написание первых 90% программы занимает 90% времени. Оставшиеся 10% также требуют 90% времени, а окончательная шлифовка — еще 90% времени.", "Нейл Рубенкинг"),
                new Quote(5, "Программирование — это гонка между компьютерщиками, которые создают программы, все лучше защищенные от дурака, и природой, которая создает все лучших дураков. Пока что природа выигрывает.", "Рич Кук")
        };


        categoryRepository = new RepositoryImpl<>(categories);
        quoteRepository = new RepositoryImpl<>(quotes);

    }

    @Test
    public void testGetByIndex() throws Exception {
        Category category = categoryRepository.getByIndex(0);
        Category category2 = categoryRepository.getByIndex(3);

        Assert.assertEquals(category.getName(), "Name 1");
        Assert.assertEquals(category2.getName(), "Name 4");

        Quote quote1 = quoteRepository.getByIndex(0);
        Quote quote2 = quoteRepository.getByIndex(4);

        Assert.assertEquals(quote1.getId(), 1);
        Assert.assertEquals(quote2.getId(), 5);
    }

    @Test
    public void testGetById() throws Exception {
        Quote quote1 = quoteRepository.getById(3);

        Assert.assertEquals(quote1.getValue(), "Каждый дурак может написать программу, которую может понять компьютер. Хороший программист пишет программу, которую может понять человек.");

        Category category = categoryRepository.getById(2);

        Assert.assertEquals(category.getId(), 2);
    }

    @Test
    public void testAdd() throws Exception {
        Category categoryToAdd = new Category(5, "Name 5");
        categoryRepository.add(categoryToAdd);
        Category categoryToTest = categoryRepository.getById(5);
        Assert.assertEquals(categoryToTest.getName(), "Name 5");

        Quote quote1 = new Quote(6, "Test Quote", "Test Author");
        quoteRepository.add(quote1);
        Quote quote2 = quoteRepository.getById(6);
        Assert.assertEquals(quote2.getValue(), quote1.getValue());
    }

    @Test
    public void testRemove() throws Exception {
        quoteRepository.remove(quotes[2]);
        Assert.assertEquals(quoteRepository.size(), quotes.length-1);

        categoryRepository.remove(categories[1]);
        Assert.assertEquals(categoryRepository.size(), 3);
    }

    @Test
    public void testUpdate() throws Exception {
        Category category = categories[0];
        category.setName("Name test");
        categoryRepository.update(category);
        Category category2 = categoryRepository.getById(category.getId());
        Assert.assertEquals(category2.getName(), "Name test");

        Quote quote1 = quotes[3];
        quote1.setValue("Test Value");
        quoteRepository.update(quote1);
        Quote quote2 = quoteRepository.getById(quote1.getId());
        Assert.assertEquals(quote2.getValue(), "Test Value");
    }

    @Test
    public void testSize() throws Exception {
        Assert.assertEquals(categoryRepository.size(), categories.length);
        Assert.assertEquals(quoteRepository.size(), quotes.length);
    }
}