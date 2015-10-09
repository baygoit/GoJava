import java.sql.* ;



/**
 * Created by Ыўср on 08.10.2015.
 */
public class DAOjdbc {



    public void retrieve() throws SQLException {
        Connection connection = null;
        Statement stmt = null;
        String query = "select * from users";

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/AIRBNB", "root", "1234");

            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
//just print on the console
           /* while (rs.next()) {
                String userName = rs.getString("UserName");
                String userSurname = rs.getString("UserSurname");
                System.out.println("firstname: " + userName + ", lastname: " + userSurname);
            }
*/
            // create users from database

            while (rs.next()) {
                User user = new User();
                user.setName(rs.getString("UserName"));
                user.setSurname(rs.getString("UserSurname"));
                user.setEmail(rs.getString("UserEmail"));
                user.setIsHost(rs.getInt("IsHost"));
                System.out.println( user);
            }



        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        } finally {
            connection.close();
        }
    }


    private static void addUser(User user) throws SQLException {
        Connection connection = null;
        Statement stmt = null;
        //String query = "incert into users (usersName, UserSurname, UsersEmail, IsHost) values ('Nik', 'Tolkin', 'NTolkin@gmail.com', 1)";
        String query = "insert into user values (null, '" + user.getName() + "', '" + user.getSurname()+ "', '" + user.getEmail()+"')";
         stmt.execute(query);

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/AIRBNB", "root", "1234");

            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        } finally {
            connection.close();
        }
    }




}
