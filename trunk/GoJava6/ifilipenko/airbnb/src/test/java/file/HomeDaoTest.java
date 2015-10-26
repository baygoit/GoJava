package file;

import dao.file.HomeFileDao;
import model.CityList;
import model.Home;
import model.HomeType;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class HomeDaoTest {

    @Test
    public void serialize_Success() {
        //-------------------------------------
        HomeFileDao homeDao = new HomeFileDao();
        String expected = "2 | MIAMI | APARTMENT";
        Home home = homeDao.parseOneHome(expected);

        //-------------------------------------
        String actual = homeDao.serializeHome(home);

        //-------------------------------------
        Assert.assertEquals(expected, actual );

    }

    @Test
    public void read_Success() {
        //-------------------------------------
        String line = "2 | MIAMI | APARTMENT ";
        HomeFileDao homeDao = new HomeFileDao();

        //-------------------------------------
        Home home = homeDao.parseOneHome(line);

        //-------------------------------------
        Assert.assertEquals(2, home.getHostCode());
        Assert.assertEquals(CityList.MIAMI, home.getCity());
        Assert.assertEquals(HomeType.APARTMENT, home.getHomeType());
    }

    @Test
    public void readAll_Success(){

    }

    @Test
    public void readByCode_Success(){

    }

    @Test
    public void create_Success(){

    }

    @Ignore
    @Test
    public void test() {
        Home home = new Home(2, CityList.MIAMI, HomeType.APARTMENT);
        System.out.println(home.toString());
    }
}
