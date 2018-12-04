import compress.NaiveCompresor;
import compress.OptimalCompresor;
import costs.CostCalculator;
import paginator.Paginator;

import java.math.BigDecimal;

/**
 * Created by Grzegorz Chrzaszczyk on 01-12-2018  11:01 AM
 */
public class Runner {


    private static final String SMS_COST = "0.99";
    private static final int SMS_LENGTH = 100;

    public static void main(String[] args) {

        String inputStr = "ASCII stands for American Standard Code for Information Interchange. Computers can only understand numbers, so an ASCII code is the " +
                "numerical representation of a character such as 'a' or '@' or an action of some sort. ASCII was developed a long time ago and now the non-printing" +
                " characters are rarely used for their original purpose. Below is the ASCII character table and this includes descriptions of the first 32 " +
                "non-printing characters. ";

        String s = null;

        CostCalculator costCalc = new CostCalculator(new BigDecimal(SMS_COST));
        Paginator pag = new Paginator(SMS_LENGTH);
        System.out.println("\n>>>>>> Single SMS cost = " + costCalc.getUnitPrice() +
                "\tsingle message max length = " + pag.getSmsLenght());

        System.out.println("\n---Initial text:--------------------------------------------------");
        System.out.println(inputStr);
        System.out.println("---No of characters in initial text = " + inputStr.length());

        NaiveCompresor nc = new NaiveCompresor();
        System.out.println("\n---Compressed text:-------------------------------------------------");
        s = nc.compress(inputStr);
        System.out.println(s);
        System.out.println("---No of characters in compressed text = " + s.length() +
                "\tno. of compressed characters = " + (inputStr.length() - s.length()));

        String[] pag1 = pag.paginate(s);

        // show pagination
        int cnt = 0;
        for (String st : pag1) {
            System.out.print("SMS no." + (++cnt) + " = ");
            System.out.println(st);
        }

        int smsCount = pag1.length;
        System.out.println("\n>>>>>> Total SMS count = " + smsCount + " <<<<<<");
        System.out.println(">>>>>> Total SMS costs = " + costCalc.calculate(smsCount).toString() + " <<<<<<");

        System.out.println("\n---Decompressed text:-----------------------------------------------");
        s = nc.decompress(s);
        System.out.println(s);
        System.out.println("---No of characters in decompressed text = " + s.length());


        OptimalCompresor oc = new OptimalCompresor();
        s = oc.compress(s);
        System.out.println(s);

    }


}
