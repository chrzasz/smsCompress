import compress.NaiveCompresor;
import costs.CostCalculator;
import paginator.Paginator;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.*;

/**
 * Created by Grzegorz Chrzaszczyk on 01-12-2018  11:01 AM
 */
public class Runner {

    public static void main(String[] args) {

        String inputStr = "ASCII stands for American Standard Code for Information Interchange. Computers can only understand numbers, so an ASCII code is the " +
                "numerical representation of a character such as 'a' or '@' or an action of some sort. ASCII was developed a long time ago and now the non-printing" +
                " characters are rarely used for their original purpose. Below is the ASCII character table and this includes descriptions of the first 32 " +
                "non-printing characters. ";

        CostCalculator costCalc = new CostCalculator(BigDecimal.valueOf(0.99));

        System.out.println(costCalc.calculate(100).toString());

        Paginator pag160 = new Paginator(160);

        NaiveCompresor nc = new NaiveCompresor();

//        pag160.paginate(nc.compress(inputStr));

//        System.out.println(pag160.paginate(nc.compress(inputStr)));

        String s = nc.compress(inputStr);

        System.out.println(s);
        s = nc.decompress(s);
        System.out.println(s);


    }


}
