package dao.file;

import model.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ReservationFileDao {
    private FileAccess fileAccess;

    public ReservationFileDao() {
        String path = this.getClass().getResource("/files/reservation").getPath();
        this.fileAccess = new FileAccess(path);
    }

    public ReservationFileDao(FileAccess fileAccess) {
        this.fileAccess = fileAccess;
    }


    public void create(Reservation res) {

    }

    public Reservation read(String data) throws ParseException {
        Reservation res = new Reservation();
        String[] params = data.split("\\|");

        for (int i = 0; i < params.length; i++) {
            params[i] = params[i].trim();
        }

        res.setUserId(Integer.parseInt(params[0]));
        res.setHomeId(Integer.parseInt(params[1]));
        res.setStart(new SimpleDateFormat("dd/MM/yyyy").parse(params[2]));
        res.setEnd(new SimpleDateFormat("dd/MM/yyyy").parse(params[3]));

        return res;
    }

    public String serialize(Reservation res) {
        StringBuilder builder = new StringBuilder();
        builder.append(res.getUserId())
                .append(" | ")
                .append(res.getHomeId())
                .append(" | ")
                .append(new SimpleDateFormat("dd/MM/yyyy").format(res.getStart()))
                .append(" | ")
                .append(new SimpleDateFormat("dd/MM/yyyy").format(res.getEnd()));

        return builder.toString();
    }
}
