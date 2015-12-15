package dao.file;

import dao.IUserDao;
import entity.enums.CityList;
import entity.enums.GenderType;
import entity.User;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserFileDao implements IUserDao {
    private final FileAccess fileAccess;

    public UserFileDao() {
        String file = this.getClass().getResource("/files/users").getPath();
        this.fileAccess = new FileAccess(file);
    }

    public UserFileDao(FileAccess fileAccess) {
        this.fileAccess = fileAccess;
    }

    public void create(User newUser) throws IOException {
        List<String> users = fileAccess.readAllLines();
        users.add((serialize(newUser)));
        fileAccess.writeAllLines(String.join("\n", users));
    }

    public String serialize(User user) {
        StringBuilder builder = new StringBuilder();
        builder.append(user.getId())
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
                .append(user.getCityEnum());

        return builder.toString();
    }

    public List<User> readAll() {
        List<User> result = new ArrayList<>();
        try {
            List<String> lines = fileAccess.readAllLines();
            for (String line : lines) {
                result.add(read(line));
            }
        } catch (IOException ex) {
            System.out.println("Cannot perform output" + ex);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public User readByCode(int code) {
        for (User user : readAll()) {
            if (user.getId() == code) {
                return user;
            }
        }
        return null;
    }

    public User read(String data) throws ParseException {
        User user = new User();
        String[] params = data.split("\\|");
        for (int j = 0; j < params.length; j++) {
            params[j] = params[j].trim();
        }

        user.setId(Integer.parseInt(params[0]));
        user.setName(params[1]);
        user.setLastName(params[2]);
        user.setGender(params[3].equals("FEMALE") ? GenderType.FEMALE : GenderType.MALE);
        user.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(params[4]));
        user.setEmail(params[5]);
        user.setCityEnum(CityList.valueOf(params[6]));

        return user;
    }

    public User readByEmail(String email) {
        for (User user : readAll()) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }
}
