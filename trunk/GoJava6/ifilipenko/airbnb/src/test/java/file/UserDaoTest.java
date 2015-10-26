package file;

import dao.file.FileAccess;
import dao.file.UserFileDao;
import model.CityList;
import model.GenderType;
import model.User;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class UserDaoTest {

    private FileAccess getFileAccessStub() throws IOException {
        FileAccess stubFileAccess = mock(FileAccess.class);
        when(stubFileAccess.readAllLines()).thenReturn(
                new ArrayList<>(Arrays.asList(
                        "2 | Inna | Filipenko | FEMALE | 01/02/2015 | br@gmail.com | NEW_YORK",
                        "3 | Bob | Marley | MALE | 30/03/2015 | br@gmail.com | NEW_YORK",
                        "4 | John | Smith | MALE | 01/12/2015 | br@gmail.com | NEW_YORK"
                ))
        );
        return stubFileAccess;
    }


    @Test
    public void readAll_Success() throws IOException {
        //Arrangement
        UserFileDao userDao = new UserFileDao(getFileAccessStub());

        //Act
        List<User> users = userDao.readAll();

        //Assert
        Assert.assertEquals(3, users.size());
        Assert.assertEquals("Inna", users.get(0).getName());
    }


    @Test
    public void read_Success() throws ParseException, IOException {
        //
        String data = "2 | Inna | Filipenko | FEMALE | 01/02/2015 | br@gmail.com | NEW_YORK";
        UserFileDao userDao = new UserFileDao(null);

        //
        User user = userDao.read(data);

        //
        Assert.assertEquals(2, user.getExternalCode());
        Assert.assertEquals("Inna", user.getName());
        Assert.assertEquals("Filipenko", user.getLastName());
        Assert.assertEquals(GenderType.FEMALE, user.getGender());
        Assert.assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2015"), user.getBirthDate());
        Assert.assertEquals("br@gmail.com", user.getEmail());
        Assert.assertEquals(CityList.NEW_YORK, user.getCity());
    }

    @Test
    public void readByCode_Success() throws IOException {
        //
        UserFileDao userDao = new UserFileDao(getFileAccessStub());

        //
        User user = new UserFileDao(getFileAccessStub()).readByCode(2);

        //
        Assert.assertEquals(2, user.getExternalCode());
    }


    @Test
    public void create_Success() throws ParseException, IOException {
        //
        FileAccess fileAccessStub = getFileAccessStub();
        UserFileDao userDao = new UserFileDao(fileAccessStub);
        User user = userDao.read("10 | Inna | Filipenko | FEMALE | 01/02/2015 | br@gmail.com | NEW_YORK");

        //
        userDao.create(user);

        //
        verify(fileAccessStub).save("2 | Inna | Filipenko | FEMALE | 01/02/2015 | br@gmail.com | NEW_YORK\n" +
                "3 | Bob | Marley | MALE | 30/03/2015 | br@gmail.com | NEW_YORK\n" +
                "4 | John | Smith | MALE | 01/12/2015 | br@gmail.com | NEW_YORK\n" +
                "10 | Inna | Filipenko | FEMALE | 01/02/2015 | br@gmail.com | NEW_YORK");
    }

    @Test
    public void serialize_Success() throws IOException, ParseException {
        //
        FileAccess fileAccessStub = getFileAccessStub();
        UserFileDao userDao = new UserFileDao(fileAccessStub);
        User user = userDao.read("10 | Inna | Filipenko | FEMALE | 01/02/2015 | br@gmail.com | NEW_YORK");

        //
        String actual = userDao.serialize(user);

        //
        Assert.assertEquals("10 | Inna | Filipenko | FEMALE | 01/02/2015 | br@gmail.com | NEW_YORK", actual);
    }


}
