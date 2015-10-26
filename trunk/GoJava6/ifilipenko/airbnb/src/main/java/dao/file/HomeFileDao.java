package dao.file;

import model.CityList;
import model.Home;
import model.HomeType;

public class HomeFileDao {
    private final FileAccess fileAccess;

    public HomeFileDao() {
        String file = this.getClass().getResource("/home").getPath();
        this.fileAccess = new FileAccess(file);
    }


    public String serializeHome(Home home) {
        StringBuilder sb = new StringBuilder();
        sb.append(home.getHostCode())
                .append(" | ")
                .append(home.getCity())
                .append(" | ")
                .append(home.getHomeType());

        return sb.toString();
    }

    public Home parseOneHome(String line) {
        Home home = new Home();

        String[] params = line.split("\\|");
        for (int i = 0; i < params.length; i++) {
            params[i] = params[i].trim();
        }

        home.setHost(Integer.parseInt(params[0]));
        home.setCity(CityList.valueOf(params[1]));
        home.setHomeType(HomeType.valueOf(params[2]));

        return home;
    }
}
