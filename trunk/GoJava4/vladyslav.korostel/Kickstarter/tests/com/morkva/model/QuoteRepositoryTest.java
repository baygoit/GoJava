package com.morkva.model;

import com.morkva.entities.Category;
import com.morkva.entities.Quote;
import com.morkva.model.impl.CategoryRepository;
import com.morkva.model.impl.QuoteRepository;
import com.sun.org.apache.xpath.internal.operations.Quo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by vladyslav on 18.05.15.
 */
public class QuoteRepositoryTest {

    Repository<Quote> quoteRepository;
    
    @Before
    public void setUp() {
        quoteRepository = new QuoteRepository();
    }

    @Test
    public void shouldNonEmpty_WhenAdd() {
        quoteRepository.add(new Quote(1, "Value 1", "Author 1"));
        Assert.assertEquals(1, quoteRepository.size());
    }

    @Test
    public void shouldNotAdd_WhenExist() {
        quoteRepository.add(new Quote(1, "Value 1", "Author 1"));
        boolean added = quoteRepository.add(new Quote(1, "Value 1", "Author 1"));
        Assert.assertFalse(added);
        Assert.assertEquals(1, quoteRepository.size());
    }

    @Test
    public void shouldNotRemove_WhenEmpty() {
        boolean removed = quoteRepository.remove(new Quote(1, "Value 1", "Author 1"));
        Assert.assertFalse(removed);
    }

    @Test
    public void shouldNotRemove_WhenNotExist() {
        quoteRepository.add(new Quote(1, "Value 1", "Author 1"));
        quoteRepository.add(new Quote(2, "Value 2", "Author 2"));
        boolean removed = quoteRepository.remove(new Quote(3, "Value 3", "Author 3"));
        Assert.assertFalse(removed);
    }

    @Test
    public void shouldRemove_WhenExist() {
        Quote quote1 = new Quote(1, "Value 1", "Author 1");
        quoteRepository.add(quote1);
        Quote quote2 = new Quote(2, "Value 2", "Author 2");
        quoteRepository.add(quote2);
        Assert.assertEquals(2, quoteRepository.size());

        boolean removed = quoteRepository.remove(quote2);

        Assert.assertTrue(removed);
        Assert.assertEquals(1, quoteRepository.size());
    }

    @Test
    public void shouldNotUpdate_WhenEmpty() {
        boolean updated = quoteRepository.update(new Quote(1, "Value 1", "Author 1"));
        Assert.assertFalse(updated);
    }

    @Test
    public void shouldNotUpdate_WhenNotExist() {
        Quote quote1 = new Quote(1, "Value 1", "Author 1");
        Quote quote2 = new Quote(2, "Value 2", "Author 1");
        quoteRepository.add(quote1);
        quoteRepository.add(quote2);
        Assert.assertEquals(2, quoteRepository.size());

        Quote quote3 = new Quote(3, "Value 3", "Author 3");
        boolean updated = quoteRepository.update(quote3);
        Assert.assertFalse(updated);
    }

    @Test
    public void shouldUpdate_WhenExist() {
        Quote quote1 = new Quote(1, "Value 1", "Author 1");
        Quote quote2 = new Quote(2, "Value 2", "Author 2");
        quoteRepository.add(quote1);
        quoteRepository.add(quote2);
        Assert.assertEquals(2, quoteRepository.size());

        quote2.setValue("New Value 2");
        boolean updated = quoteRepository.update(quote2);
        Assert.assertTrue(updated);
        Assert.assertEquals("New Value 2", quoteRepository.getById(2).getValue());
    }

    @Test
    public void shouldNull_WhenEmpty() throws Exception {
        Quote quote1 = quoteRepository.findByName("Name 1");
        Quote quote2 = quoteRepository.getById(0);
        Quote quote3 = quoteRepository.getByIndex(0);
        Quote[] quotes = quoteRepository.getAll();

        Assert.assertNull(quote1);
        Assert.assertNull(quote2);
        Assert.assertNull(quote3);
        Assert.assertNull(quotes);
    }

    @Test
    public void shouldNotNull_WhenNotEmpty() throws Exception {
        quoteRepository.add(new Quote(1, "Value 1", "Author 1"));
        Quote quote1 = quoteRepository.findByName("Value 1");
        Quote quote2 = quoteRepository.getById(1);
        Quote quote3 = quoteRepository.getByIndex(0);
        Quote[] quotes = quoteRepository.getAll();

        Assert.assertNotNull(quote1);
        Assert.assertNotNull(quote2);
        Assert.assertNotNull(quote3);
        Assert.assertNotNull(quotes);
    }

    @Test
    public void shouldNotEmpty_WhenCreatedWithParams() {
        Quote[] quotes = new Quote[] {
                new Quote(1, "Value 1", "Author 1"),
                new Quote(3, "Value 3", "Author 3"),
                new Quote(2, "Value 2", "Author 2")
        };
        quoteRepository = new QuoteRepository(quotes);
        int size = quoteRepository.size();
        Assert.assertEquals(3, size);
    }
}
