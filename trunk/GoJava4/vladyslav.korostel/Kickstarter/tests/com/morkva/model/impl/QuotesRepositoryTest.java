package com.morkva.model.impl;

import com.morkva.entities.Quote;
import com.morkva.entities.utils.ID;
import com.morkva.model.Repository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by vladyslav on 08.05.15.
 */
public class QuotesRepositoryTest {

    Quote[] defaultQuotes;

    Repository<Quote> quoteRepository;

    @Before
    public void setUp() throws Exception {
        defaultQuotes = new Quote[] {
                new Quote(1, "Test Quote", "Test author"),
                new Quote(2, "«Пользователь» — слово, используемое компьютерщиками-профессионалами вместо слова «идиот».", "Дейв Барри"),
                new Quote(3, "Каждый дурак может написать программу, которую может понять компьютер. Хороший программист пишет программу, которую может понять человек.", "Мартин Фаулер"),
                new Quote(4, "Написание первых 90% программы занимает 90% времени. Оставшиеся 10% также требуют 90% времени, а окончательная шлифовка — еще 90% времени.", "Нейл Рубенкинг"),
                new Quote(5, "Программирование — это гонка между компьютерщиками, которые создают программы, все лучше защищенные от дурака, и природой, которая создает все лучших дураков. Пока что природа выигрывает.", "Рич Кук")
        };
        quoteRepository = new QuotesRepository(defaultQuotes);
    }

    @Test
    public void testGetByIndex() throws Exception {
        Quote quote1 = quoteRepository.getByIndex(0);
        Quote quote2 = quoteRepository.getByIndex(4);

        Assert.assertEquals(quote1.getId().getValue(), new ID<>(1).getValue());
        Assert.assertEquals(quote2.getId().getValue(), new ID<>(5).getValue());
    }

    @Test
    public void testGetById() throws Exception {
        Quote quote1 = quoteRepository.getById(new ID(3));

        Assert.assertEquals(quote1.getValue(), "Каждый дурак может написать программу, которую может понять компьютер. Хороший программист пишет программу, которую может понять человек.");
    }

    @Test
    public void testAdd() throws Exception {
        Quote quote1 = new Quote(6, "Test Quote", "Test Author");
        quoteRepository.add(quote1);
        Quote quote2 = quoteRepository.getById(new ID(6));
        Assert.assertEquals(quote2.getValue(), quote1.getValue());
    }

    @Test
    public void testRemove() throws Exception {
        quoteRepository.remove(defaultQuotes[2]);
        Assert.assertEquals(quoteRepository.size(), defaultQuotes.length-1);
    }

    @Test
    public void testUpdate() throws Exception {
        Quote quote1 = defaultQuotes[3];
        quote1.setValue("Test Value");
        quoteRepository.update(quote1);
        Quote quote2 = quoteRepository.getById(quote1.getId());
        Assert.assertEquals(quote2.getValue(), "Test Value");
    }

    @Test
    public void testSize() throws Exception {
        Assert.assertEquals(quoteRepository.size(), defaultQuotes.length);
    }
}