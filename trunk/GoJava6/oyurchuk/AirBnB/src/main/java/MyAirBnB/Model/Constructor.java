package MyAirBnB.Model;

import MyAirBnB.JDBC.Jdbc;

/**
 * Created by macmini on 20.09.15.
 */
public class Constructor {
    public static void main(String[] args) {

        //создать юзера.
        
        User user = new User("mail@mail.ru","Ivanov", "Vasya");


//регистрация пользователя
           Registration registration = new Registration();
        registration.register(user);

        System.out.println(user);

        Jdbc jdbc = new Jdbc();
        String query = "select count(*) from user";
        jdbc.doConn(query);
    }

}
