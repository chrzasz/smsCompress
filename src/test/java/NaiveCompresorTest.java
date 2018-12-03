import compress.Compresor;
import compress.NaiveCompresor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Grzegorz Chrzaszczyk on 01-12-2018  01:33 PM
 */
public class NaiveCompresorTest {

    private NaiveCompresor compresor;

    @Before
    public void setUp() {

        compresor = new NaiveCompresor();
    }

    @Test
    public void sampleTest() throws Exception {

        String s = compresor.compress("Ala ma kota");
        Assert.assertEquals("AlaMaKota", s);

    }

    @Test
    public void emptyTextTest() {
        Assert.assertEquals("", compresor.compress(""));
    }


    @Test
    public void decompressTest() {
        String s = "Ala ma kota";
        String comprStr = compresor.compress(s);

        Assert.assertEquals("ala ma kota", compresor.decompress(comprStr));
//        Assert.assertEquals(comprStr.getBytes(), compresor.decompress(comprStr).getBytes());
    }

}

