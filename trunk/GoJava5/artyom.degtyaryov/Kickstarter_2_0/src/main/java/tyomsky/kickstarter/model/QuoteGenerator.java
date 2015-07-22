package tyomsky.kickstarter.model;

import java.util.Random;

public class QuoteGenerator {

    private Random random;

    public QuoteGenerator(Random random) {
        this.random = random;
    }

    private String[] quotes = new String[]{
            "\"If you want to achieve greatness stop asking for permission.\" --Anonymous",
            "\"Things work out best for those who make the best of how things work out.\" --John Wooden",
            "\"To live a creative life, we must lose our fear of being wrong.\" --Anonymous",
            "\"If you are not willing to risk the usual you will have to settle for the ordinary.\" --Jim Rohn",
            "\"Trust because you are willing to accept the risk, not because it's safe or certain.\" --Anonymous",
            "\"All our dreams can come true if we have the courage to pursue them.\" --Walt Disney",
            "\"Good things come to people who wait, but better things come to those who go out and get them.\" --Anonymous",
            "\"If you do what you always did, you will get what you always got.\" --Anonymous",
            "\"Success is walking from failure to failure with no loss of enthusiasm.\" --Winston Churchill",
            "\"Just when the caterpillar thought the world was ending, he turned into a butterfly.\" --Proverb",
            "\"Successful entrepreneurs are givers and not takers of positive energy.\" --Anonymous",
            "\"Whenever you see a successful person you only see the public glories, never the private sacrifices to reach them.\" --Vaibhav Shah",
            "\"Opportunities don't happen, you create them.\" --Chris Grosser",
            "\"Try not to become a person of success, but rather try to become a person of value.\" --Albert Einstein",
            "\"Great minds discuss ideas; average minds discuss events; small minds discuss people.\" --Eleanor Roosevelt",
            "\"I have not failed. I've just found 10,000 ways that won't work.\" --Thomas A. Edison",
            "\"If you don't value your time, neither will others. Stop giving away your time and talents--start charging for it.\" --Kim Garst",
            "\"A successful man is one who can lay a firm foundation with the bricks others have thrown at him.\" --David Brinkley",
            "\"No one can make you feel inferior without your consent.\" --Eleanor Roosevelt"
    };

    public String getQuote() {
        int index = random.nextInt(quotes.length);
        return quotes[index];
    }

}
