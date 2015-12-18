package file;

import dao.file.FileAccess;
import dao.file.HomeFileDao;
import entity.enums.CityList;
import entity.Home;
import entity.enums.HomeType;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HomeFileDaoTest {

    private FileAccess getFileAccessStub() throws IOException {
        FileAccess stubFileAccess = mock(FileAccess.class);
        when(stubFileAccess.readAllLines())
                .thenReturn(new ArrayList<>(Arrays.asList(
                                "if@gmail.com | MIAMI | APARTMENT",
                                "bm@gmail.com | NEW_YORK | ROOM",
                                "js@gmail.com | MIAMI | HOUSE"
                        ))
                );

        return stubFileAccess;
    }

    @Test
    public void serialize_Success() {
        //-------------------------------------
        HomeFileDao homeDao = new HomeFileDao();
        String expected = "if@gmail.com | MIAMI | APARTMENT";
        Home home = homeDao.read(expected);

        //-------------------------------------
        String actual = homeDao.serialize(home);

        //-------------------------------------
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void create_Success() throws IOException {
        //-------------------------------------
        FileAccess stubFileAccess = getFileAccessStub();
        HomeFileDao homeDao = new HomeFileDao(stubFileAccess);
        Home home = homeDao.read("if@gmail.com | NEW_YORK | ROOM");

        //-------------------------------------
        homeDao.create(home);

        //-------------------------------------
        verify(stubFileAccess).writeAllLines(
                "if@gmail.com | MIAMI | APARTMENT\n" +
                        "bm@gmail.com | NEW_YORK | ROOM\n" +
                        "js@gmail.com | MIAMI | HOUSE\n" +
                        "if@gmail.com | NEW_YORK | ROOM");

    }

    @Test
    public void read_Success() {
        //-------------------------------------
        String line = "if@gmail.com | MIAMI | APARTMENT ";
        HomeFileDao homeDao = new HomeFileDao();

        //-------------------------------------
        Home home = homeDao.read(line);

        //-------------------------------------
        Assert.assertEquals("if@gmail.com", home.getHostByEmail());
        Assert.assertEquals(CityList.MIAMI, home.getCity());
        Assert.assertEquals(HomeType.APARTMENT, home.getHomeType());
    }

    @Test
    public void readAll_Success() throws IOException {
        //-------------------------------------
        HomeFileDao homeFileDao = new HomeFileDao(getFileAccessStub());

        //-------------------------------------
        List<Home> homes = homeFileDao.readAll();

        //-------------------------------------
        Assert.assertEquals(3, homes.size());
        Assert.assertEquals(HomeType.APARTMENT, homes.get(0).getHomeType());
    }



}
