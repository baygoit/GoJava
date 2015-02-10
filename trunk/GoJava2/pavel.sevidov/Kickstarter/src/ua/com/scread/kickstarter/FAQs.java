package ua.com.scread.kickstarter;

import java.util.ArrayList;
import java.util.List;

public class FAQs {
    List<FAQ> faqs;
    
    public FAQs(List<FAQ> faqs) {
        faqs = new ArrayList<FAQ>();
        this.faqs.addAll(faqs);
    }
    
    public FAQs(FAQ faq) {
        faqs = new ArrayList<FAQ>();
        faqs.add(faq);
    }
    
    public void add(FAQ faq) {
        faqs.add(faq);
    }
    
    public List<FAQ> getFAQs() { 
        return faqs;
    }
}
