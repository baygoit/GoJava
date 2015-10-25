package dao.file;

import model.CityList;
import model.GenderType;
import model.User;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class UserFileDao {
    private final FileAccess fileAccess;

    public UserFileDao() {
        String file = this.getClass().getResource("/users").getPath();
        this.fileAccess = new FileAccess(file);
    }

    public UserFileDao(FileAccess fileAccess) {
        this.fileAccess = fileAccess;
    }

    public List<User> loadAll() {
        List<User> result = new ArrayList<>();
        try {
            List<String> lines = fileAccess.readAllLines();
            for (String line : lines) {
                result.add(parseOneUser(line));
            }
        } catch (IOException ex) {
            System.out.println("Cannot perform output" + ex);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public User parseOneUser(String data) throws ParseException {
        User user = new User();

        String[] params = data.split("\\|");
        for (int j = 0; j < params.length; j++) {
            params[j] = params[j].trim();
        }

        user.setExternalCode(Integer.parseInt(params[0]));
        user.setName(params[1]);
        user.setLastName(params[2]);
        user.setGender(params[3].equals("FEMALE") ? GenderType.FEMALE : GenderType.MALE);
        user.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(params[4]));
        user.setEmail(params[5]);
        user.setCity(CityList.valueOf(params[6]));

        return user;
    }


    public void create(User newUser) throws IOException {
        List<String> users = fileAccess.readAllLines();
        users.add((serializeUser(newUser)));
        fileAccess.save(String.join("\n", users));

    }

    public User loadByCode(int code) {
        for (User user : loadAll()) {
            if (user.getExternalCode() == code) {
                return user;
            }
        }
        return null;
    }

    public String serializeUser(User user) {
        StringBuilder builder = new StringBuilder();
        builder.append(user.getExternalCode())
                .append(" | ")
                .append(user.getName())
                .append(" | ")
                .append(user.getLastName())
                .append(" | ")
                .append(user.getGender())
                .append(" | ")
                .append(new SimpleDateFormat("dd/MM/yyyy").format(user.getBirthDate()))
                .append(" | ")
                .append(user.getEmail())
                .append(" | ")
                .append(user.getCity());

        return builder.toString();
    }
}
