package com.gojava6.airbnb.dao.io;

import com.gojava6.airbnb.dao.ISubscriberDao;
import com.gojava6.airbnb.model.Subscriber;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SubsriberDaoIO implements ISubscriberDao {

    public void createSubscriber(Subscriber subscriber) {
        String line = "" + subscriber.getUserId();
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(new FileWriter("subscriber.txt",true));
            outputStream.println(line);
        } catch (IOException ex) {
            System.out.println("IOException in method createSubscriber");
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public void deleteSubscriber(Subscriber subscriber) {
        List<Subscriber> newSubscriberList = new ArrayList<Subscriber>();

        List<Subscriber> subscriberList = getSubscriberList();
        for (Subscriber s : subscriberList) {
            if (s.getUserId() != subscriber.getUserId()) {
                newSubscriberList.add(s);
            }
        }
        cleanSubscriberTxtFile();
        saveSubscribersInTxtFile(newSubscriberList);
    }

    public List<Subscriber> getSubscriberList() {
        List<Subscriber> subscriberList = new ArrayList<Subscriber>();
        BufferedReader inputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("subscriber.txt"));
            String line;
            while ((line = inputStream.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");

                int userId = Integer.valueOf(tokenizer.nextToken());

                Subscriber subscriber = new Subscriber();
                subscriber.setUserId(userId);

                subscriberList.add(subscriber);
            }
        } catch (IOException e) {
            if (e instanceof FileNotFoundException) {
                System.out.println("FileNotFoundException in method getSubscriberList");
            } else {
                System.out.println("IOException in method getSubscriberList");
            }
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println("OException in method getSubscriberList while closing");
            }
        }
        return subscriberList;
    }

    public Subscriber getSubscriber(Integer userId) {
        List<Subscriber> subscriberList = getSubscriberList();
        for (Subscriber subscriber : subscriberList) {
            if (subscriber.getUserId() == userId) {
                return subscriber;
            }
        }
        return null;
    }


    private void cleanSubscriberTxtFile() {
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter("subscriber.txt");
            outputStream.print("");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException in method cleanSubscriberTxtFile");
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    private void saveSubscribersInTxtFile(List<Subscriber> subscriberList) {
        for (Subscriber subscriber : subscriberList) {
            createSubscriber(subscriber);
        }
    }
}
