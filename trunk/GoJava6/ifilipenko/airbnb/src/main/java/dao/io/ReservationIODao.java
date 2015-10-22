package dao.io;

import model.Reservation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReservationIODao {
    private List<Reservation> reservations = new ArrayList<>();
    private File file = new File(this.getClass().getResource("/reservation").getFile());

    public void create(Reservation res){
        reservations.add(res);
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(file))
        ) {
            for (Reservation reservation : reservations) {
                writer.write(reservation.getUser() + " | ");
                writer.write(reservation.getHome() + " | ");
                writer.write(reservation.getStart() + " | ");
                writer.write(reservation.getEnd() + "\n");
            }
        } catch (IOException ex) {
            System.out.println("Cannot perform output" + ex);
        }
    }



}
