package com.sandarovich.kickstarter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Quota Generator.
 */

public class QuotaGenerator {
    private static final List<Quota> QUOATES;

    static {
        QUOATES = new ArrayList<Quota>();
        QUOATES.add(new Quota("Mr X", "Every big journey begins with a small step"));
        QUOATES.add(new Quota("Mr X", "No pain, no gain"));
        QUOATES.add(new Quota("Mr X", "Excellence across the board"));
    }

    String getQuota(int quotaIndex) {
        return (quotaIndex <= QUOATES.size()) ? QUOATES.get(quotaIndex).toString()
                : QUOATES.get(0).toString();
    }

    public String getQuota() {
        int quotaIndex = new Random().nextInt(QUOATES.size());
        return getQuota(quotaIndex);
    }
}
