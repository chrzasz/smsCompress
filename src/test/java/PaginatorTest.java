import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import paginator.Paginator;

/**
 * Created by Grzegorz Chrzaszczyk on 01-12-2018  02:12 PM
 */

@RunWith(JUnitParamsRunner.class)

public class PaginatorTest {

    @Test
    @Parameters(method = "paginate")
    public void paginatorTest(String str, int len, String[] arr) {

        Paginator pag = new Paginator(len);

    }

    private Object[] paginate() {
        return new Object[]{
                new Object[]{"Ala ma kota", 0, new String[]{}},
                new Object[]{"Ala ma kota", 1, new String[]{"A", "l", "a", " ", "m", "a", " ", "k", "o", "t", "a"}},
                new Object[]{"Ala ma kota", 2, new String[]{"Al", "a ", "ma", " k", "ot", "a"}},
                new Object[]{"Ala ma kota", 3, new String[]{"Ala", " ma", " ko", "ta"}},
                new Object[]{"Ala ma kota", 4, new String[]{"Ala ", "ma k", "ota"}},
                new Object[]{"Ala ma kota", 5, new String[]{"Ala m", "a kot", "a"}},
                new Object[]{"Ala ma kota", 100, new String[]{"Ala ma kota"}},
        };
    }

}
