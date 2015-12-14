package stackmachine;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    @Test
    public void verify_WhenTwoDigitsAndPlus_ThenAddAndReturnResult(){
        //-------------Arrange--------
        App solution = new App();
        String line = "1 3 +";

        //-------------Act--------
       int actual =  solution.callStackMachine(line);

        //-------------Assert--------
        Assert.assertEquals(4, actual);
        Assert.assertEquals(1, solution.getMachineSize());
    }

    @Test
    public void verify_WhenTwoDigitsAndAsterisk_ThenMultiplyAndReturnResult(){
        //-------------Arrange--------
        App solution = new App();
        String line = "1 3 *";

        //-------------Act--------
        int actual =  solution.callStackMachine(line);

        //-------------Assert--------
        Assert.assertEquals(3, actual);
        Assert.assertEquals(1, solution.getMachineSize());
    }

    @Test
    public void verify_WhenLineIsEmpty_ThenReturnNegativeOne(){
        //-------------Arrange--------
        App solution = new App();
        String line = "";

        //-------------Act--------
        int actual =  solution.callStackMachine(line);

        //-------------Assert--------
        Assert.assertEquals(-1, actual);
        Assert.assertEquals(0, solution.getMachineSize());
    }


    @Test
    public void verify_WhenTwoSymbols_ThenReturnNegativeOne(){
        //-------------Arrange--------
        App solution = new App();
        String line = "*$";

        //-------------Act--------
        int actual =  solution.callStackMachine(line);

        //-------------Assert--------
        Assert.assertEquals(-1, actual);
        Assert.assertEquals(0, solution.getMachineSize());
    }

    @Test
    public void verify_WhenManySymbols_ThenReturnNegativeOne(){
        //-------------Arrange--------
        App solution = new App();
        String line = "* 1 3 + +";

        //-------------Act--------
        int actual =  solution.callStackMachine(line);

        //-------------Assert--------
        Assert.assertEquals(4, actual);
        Assert.assertEquals(1, solution.getMachineSize());
    }

    @Test
    public void verify_WhenManySymbolsStartAndFinishByAsterisk_ThenReturnNegativeOne(){
        //-------------Arrange--------
        App solution = new App();
        String line = "* 1 3 + 2 *";

        //-------------Act--------
        int actual =  solution.callStackMachine(line);

        //-------------Assert--------
        Assert.assertEquals(8, actual);
        Assert.assertEquals(1, solution.getMachineSize());
    }

    @Test
    public void verify_WhenManySymbolsStartByAsteriskEndByDigit_ThenReturnNegativeOne(){
        //-------------Arrange--------
        App solution = new App();
        String line = "6 1 3 + 2 *";

        //-------------Act--------
        int actual =  solution.callStackMachine(line);

        //-------------Assert--------
        Assert.assertEquals(8, actual);
        Assert.assertEquals(2, solution.getMachineSize());
    }


    @Test
    public void test(){
        //-------------Arrange--------
        App solution = new App();
        String line = "1 3 +";

        //-------------Act--------
        int actual =  solution.callStackMachineM(line);

        //-------------Assert--------
        Assert.assertEquals(4, actual);
        Assert.assertEquals(1, solution.getMachineSize());
    }


}
