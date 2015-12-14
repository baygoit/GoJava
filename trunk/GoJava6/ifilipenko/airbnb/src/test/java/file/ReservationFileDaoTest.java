package file;

import dao.file.FileAccess;
import dao.file.ReservationFileDao;
import entity.Reservation;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;

public class ReservationFileDaoTest {

    private FileAccess getFileAccessStub() throws IOException {
        FileAccess stubFileAccess = mock(FileAccess.class);
        when(stubFileAccess.readAllLines()).thenReturn(
                new ArrayList<>(Arrays.asList(
                        "2 | 1 | 23/01/2015 | 23/01/2015",
                        "3 | 2 | 21/01/2015 | 22/01/2015",
                        "4 | 2 | 23/01/2015 | 24/01/2015"
                ))
        );
        return stubFileAccess;
    }

    @Test
    public void serialize_Success() throws IOException, ParseException {
        //-----------------------------------------------------------
        ReservationFileDao resDao = new ReservationFileDao(getFileAccessStub());
        Reservation res = resDao.read("2 | 3 | 23/01/2015 | 27/01/2015") ;

        //-----------------------------------------------------------
        String actual = resDao.serialize(res);

        //-----------------------------------------------------------
        Assert.assertEquals("2 | 3 | 23/01/2015 | 27/01/2015", actual);
    }

    @Test
    public void read_Success() throws ParseException {
        //-----------------------------------------------------------
        ReservationFileDao resDao = new ReservationFileDao();
        String actual = "2 | 3 | 23/01/2015 | 27/01/2015";

        //-----------------------------------------------------------
        Reservation res = resDao.read(actual);

        //-----------------------------------------------------------
        Assert.assertEquals( 2, res.getUserId());
        Assert.assertEquals( 3, res.getHomeId());
        Assert.assertEquals( new SimpleDateFormat("dd/MM/yyyy").parse("23/01/2015"), res.getStart());
        Assert.assertEquals( new SimpleDateFormat("dd/MM/yyyy").parse("27/01/2015"), res.getEnd());

    }
}
