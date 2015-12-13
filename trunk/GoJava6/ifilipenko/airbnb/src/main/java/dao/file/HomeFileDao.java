package dao.file;

import entity.enums.CityList;
import entity.Home;
import entity.enums.HomeType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeFileDao {
    private final FileAccess fileAccess;

    public HomeFileDao() {
        String file = this.getClass().getResource("/files/home").getPath();
        this.fileAccess = new FileAccess(file);
    }

    public HomeFileDao(FileAccess fileAccess) {
        this.fileAccess = fileAccess;
    }

    public String serialize(Home home) {
        StringBuilder sb = new StringBuilder();
        sb.append(home.getHostByEmail())
                .append(" | ")
                .append(home.getCity())
                .append(" | ")
                .append(home.getHomeType());

        return sb.toString();
    }

    public Home read(String line) {
        Home home = new Home();

        String[] params = line.split("\\|");
        for (int i = 0; i < params.length; i++) {
            params[i] = params[i].trim();
        }

        home.setHostByEmail(params[0]);
        home.setCity(CityList.valueOf(params[1]));
        home.setHomeType(HomeType.valueOf(params[2]));

        return home;
    }

    public List<Home> readAll() {
        List<Home> result = new ArrayList<>();

        try {
            List<String> homes = fileAccess.readAllLines();
            for (String home : homes) {
                result.add(read(home));
            }
        } catch (IOException ex) {
            System.out.println("Cannot perform output" + ex);
        }

        return result;
    }

    public void create(Home home) throws IOException {
        List<String> homes = fileAccess.readAllLines();
        homes.add(this.serialize(home));
        fileAccess.writeAllLines(String.join("\n", homes));
    }
}
