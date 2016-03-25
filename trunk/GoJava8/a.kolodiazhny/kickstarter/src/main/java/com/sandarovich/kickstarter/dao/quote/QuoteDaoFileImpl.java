package com.sandarovich.kickstarter.dao.quote;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sandarovich.kickstarter.domain.Quote;

import java.io.IOException;
import java.util.List;

/**
 * Quote Dao file mode
 */

public class QuoteDaoFileImpl extends QuoteDaoMemoryImpl {
    public QuoteDaoFileImpl() {
        fillQuotas();
    }

    @Override
    void fillQuotas() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.quotes = objectMapper.readValue(
                    getClass().getClassLoader().getResourceAsStream("quoteDaoFile.json"),
                    objectMapper.getTypeFactory().constructCollectionType(
                            List.class, Quote.class));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
