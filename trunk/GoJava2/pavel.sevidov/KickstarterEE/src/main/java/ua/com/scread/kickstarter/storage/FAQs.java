package ua.com.scread.kickstarter.storage;

import java.util.ArrayList;
import java.util.List;

import ua.com.scread.kickstarter.data.FAQ;

public class FAQs {
    private List<FAQ> faqs = new ArrayList<FAQ>();
    
    public FAQs(List<FAQ> faqs) {
        this.faqs.addAll(faqs);
    }
    
    public FAQs(FAQ faq) {
        faqs.add(faq);
    }
    
    public FAQs() { }
    
    public void add(FAQ faq) {
        faqs.add(faq);
    }
    
    public List<FAQ> getFAQs() { 
        return faqs;
    }
    
    @Override
    public String toString() {
    	String result = "";
    	for(FAQ faq: faqs) {
    		result += faq.toString();
    	}
    	return result;
    }
}
