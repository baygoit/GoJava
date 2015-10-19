package com.gojava6.airbnb.dao.io;

import com.gojava6.airbnb.dao.IApartmentDao;
import com.gojava6.airbnb.model.Apartment;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ApartmentDaoIO implements IApartmentDao {

    public void createApartment(Apartment apartment) {
        int apartmentId = getLastApartmentId() + 1;

        String line = apartmentId + "," +
                apartment.getCity() + "," +
                apartment.getApartmentType() + "," +
                apartment.getUserId();

        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(new FileWriter("apartment.txt",true));
            outputStream.println(line);
        } catch (IOException ex) {
            System.out.println("IOException in method createApartment");
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public void updateApartment(Apartment apartment) {
        int apartmentId = apartment.getApartmentId();
        String city = apartment.getCity();
        String apartmentType = apartment.getApartmentType();
        int userId = apartment.getUserId();

        List<Apartment> apartmentList = getApartmentListInclDeleted();
        for (Apartment a : apartmentList) {
            if (a.getApartmentId() == apartmentId) {
                a.setCity(city);
                a.setApartmentType(apartmentType);
                a.setUserId(userId);
            }
        }
        cleanApartmentTxtFile();
        saveApartmentsInTxtFile(apartmentList);
    }

    public void deleteApartment(Apartment apartment) {
        List<Apartment> apartmentList = getApartmentListInclDeleted();
        for (Apartment a : apartmentList) {
            if (a.getApartmentId() == apartment.getApartmentId()) {
                a.setCity("Deleted");
                a.setApartmentType(" ");
                a.setUserId(0);
            }
        }
        cleanApartmentTxtFile();
        saveApartmentsInTxtFile(apartmentList);
    }

    public List<Apartment> getApartmentList() {
        List<Apartment> apartmentList = new ArrayList<Apartment>();
        List<Apartment> apartmentListInclDeleted = getApartmentListInclDeleted();
        for (Apartment apartment : apartmentListInclDeleted) {
            String city = apartment.getCity();
            if (!city.equals("Deleted")) {
                apartmentList.add(apartment);
            }
        }
        return apartmentList;
    }

    public Apartment getApartment(Integer apartmentId) {
        List<Apartment> apartmentList = getApartmentList();
        for (Apartment apartment : apartmentList) {
            if (apartment.getApartmentId() == apartmentId) {
                return apartment;
            }
        }
        return null;
    }



    private List<Apartment> getApartmentListInclDeleted() {
        List<Apartment> apartmentList = new ArrayList<Apartment>();
        BufferedReader inputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("apartment.txt"));
            String line;
            while ((line = inputStream.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");

                int apartmentId = Integer.valueOf(tokenizer.nextToken());
                String city = tokenizer.nextToken();
                String apartmentType = tokenizer.nextToken();
                int userId = Integer.valueOf(tokenizer.nextToken());

                Apartment apartment = new Apartment();
                apartment.setApartmentId(apartmentId);
                apartment.setCity(city);
                apartment.setApartmentType(apartmentType);
                apartment.setUserId(userId);

                apartmentList.add(apartment);
            }
        } catch (IOException e) {
            if (e instanceof FileNotFoundException) {
                System.out.println("FileNotFoundException in method getApartmentListInclDeleted");
            } else {
                System.out.println("IOException in method getApartmentListInclDeleted");
            }
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println("IOException in method getApartmentListInclDel while closing");
            }
        }
        return apartmentList;
    }

    private int getLastApartmentId() {
        int lastUserId = 0;

        BufferedReader inputStream = null;
        try {
            inputStream = new BufferedReader(new FileReader("apartment.txt"));
            while (inputStream.readLine() != null) {
                lastUserId++;
            }
        } catch (IOException e) {
            if (e instanceof FileNotFoundException) {
                System.out.println("FileNotFoundException in getLastApartmentId method");
            } else {
                System.out.println("IOException in getLastApartmentId method");
            }
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println("IOExc in getLastApartmentId method while inputStream closing");
            }
        }
        return lastUserId;
    }

    private void cleanApartmentTxtFile() {
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter("apartment.txt");
            outputStream.print("");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException in method cleanApartmentTxtFile");
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    private void saveApartmentsInTxtFile(List<Apartment> apartmentList) {
        for (Apartment apartment : apartmentList) {
            createApartment(apartment);
        }
    }

}
