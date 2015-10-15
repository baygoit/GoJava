package com.gojava6.airbnb.dao.io;

import com.gojava6.airbnb.dao.IReservationDao;
import com.gojava6.airbnb.model.Reservation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ReservationDaoIO implements IReservationDao {

    public void createReservation(Reservation reservation) {
        int reservationId = getLastReservationId() + 1;

        String line = reservationId + "," +
                reservation.getApartmentId() + "," +
                reservation.getUserId() + "," +
                reservation.getStart() + "," +
                reservation.getEnd();

        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(new FileWriter("reservation.txt",true));
            outputStream.println(line);
        } catch (IOException e) {
            System.out.println("IOException in method createReservation");
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public void updateReservation(Reservation reservation) {
        int reservationId = reservation.getReservationId();
        long start = reservation.getStart();
        long end = reservation.getEnd();

        List<Reservation> reservationList = getReservationListInclDeleted();
        for (Reservation r : reservationList) {
            if (r.getReservationId() == reservationId) {
                r.setStart(start);
                r.setEnd(end);
            }
        }
        cleanReservationTxtFile();
        saveReservationsInTxtFile(reservationList);
    }

    public void deleteReservation(Reservation reservation) {
        List<Reservation> reservationList = getReservationListInclDeleted();
        for (Reservation r : reservationList) {
            if (r.getReservationId() == reservation.getUserId()) {
                r.setApartmentId(0);
                r.setUserId(0);
                r.setStart(0);
                r.setEnd(0);
            }
        }
        cleanReservationTxtFile();
        saveReservationsInTxtFile(reservationList);
    }

    public List<Reservation> getReservationList() {
        List<Reservation> reservationList = new ArrayList<Reservation>();
        List<Reservation> reservationListInclDeleted = getReservationListInclDeleted();
        for (Reservation reservation : reservationListInclDeleted) {
            int apartmentId = reservation.getApartmentId();
            if (apartmentId != 0) {
                reservationList.add(reservation);
            }
        }
        return reservationList;
    }

    public List<Reservation> getApartmentReservationList(Integer apartmentId) {
        List<Reservation> apartmentReservationList = new ArrayList<Reservation>();
        List<Reservation> reservationList = getReservationList();
        for (Reservation reservation : reservationList) {
            if (reservation.getApartmentId() == apartmentId) {
                apartmentReservationList.add(reservation);
            }
        }
        return apartmentReservationList;
    }

    public Reservation getReservation(Integer reservationId) {
        List<Reservation> reservationList = getReservationList();
        for (Reservation reservation : reservationList) {
            if (reservation.getReservationId() == reservationId) {
                return reservation;
            }
        }
        return null;
    }



    private List<Reservation> getReservationListInclDeleted() {
        List<Reservation> reservationList = new ArrayList<Reservation>();
        BufferedReader inputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("reservation.txt"));
            String line;
            while ((line = inputStream.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");

                int reservationId = Integer.valueOf(tokenizer.nextToken());
                int apartmentId = Integer.valueOf(tokenizer.nextToken());
                int userId = Integer.valueOf(tokenizer.nextToken());
                long start = Long.valueOf(tokenizer.nextToken());
                long end = Long.valueOf(tokenizer.nextToken());

                Reservation reservation = new Reservation();
                reservation.setReservationId(reservationId);
                reservation.setApartmentId(apartmentId);
                reservation.setUserId(userId);
                reservation.setStart(start);
                reservation.setEnd(end);

                reservationList.add(reservation);
            }
        } catch (IOException e) {
            if (e instanceof FileNotFoundException) {
                System.out.println("FileNotFoundException in method getReservationListInclDeleted");
            } else {
                System.out.println("IOException in method getReservationListInclDeleted");
            }
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println("OException in method getReservationListInclDel while closing");
            }
        }
        return reservationList;
    }

    private int getLastReservationId() {
        int lastReservationId = 0;

        BufferedReader inputStream = null;
        try {
            inputStream = new BufferedReader(new FileReader("reservation.txt"));
            while (inputStream.readLine() != null) {
                lastReservationId++;
            }
        } catch (IOException e) {
            if (e instanceof FileNotFoundException) {
                System.out.println("FileNotFoundException in getLastReservationId method");
            } else {
                System.out.println("IOException in getLastReservationId method");
            }
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println("IOExc in getLastReservationId method while inptStream closing");
            }
        }
        return lastReservationId;
    }

    private void cleanReservationTxtFile() {
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter("reservation.txt");
            outputStream.print("");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException in method cleanReservationTxtFile");
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    private void saveReservationsInTxtFile(List<Reservation> reservationList) {
        for (Reservation reservation : reservationList) {
            createReservation(reservation);
        }
    }

}
