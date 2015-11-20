package ua.com.goit.gojava7.kickstarter.dao.file.util;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.beans.Reward;
import ua.com.goit.gojava7.kickstarter.dao.DataType;
import ua.com.goit.gojava7.kickstarter.dao.StorageFactory;

public class CsvParserTest {
    
    String filePath = "src/test/resources/storages/file/%name%.CSV".replace("%name%", Quote.class.getSimpleName());
    
    CsvParser parser;

    private StorageFactory factory;


    @Before
    public void setUp() throws Exception {
        factory = new StorageFactory(DataType.MEMORY);
        
        parser = new CsvParser(Reward.class);
        parser.setDelimiter(";");
        parser.setLineSeparator("\n");

    }

    @Test
    public void testWriteCollection()  throws Exception {
        parser.write(factory.getRewardDAO().getAll(), filePath);
    }
    
    @Test
    public void testWriteSingleElement()  throws Exception {
        parser.write(factory.getRewardDAO().get(0), filePath);
    }

}
