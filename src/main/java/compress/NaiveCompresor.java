package compress;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Grzegorz Chrzaszczyk on 01-12-2018  10:59 AM
 */
public class NaiveCompresor implements Compresor {

    public NaiveCompresor() {
    }

    @Override
    public String compress(String inputStr) {

        //remove spaces and make toUpperCase first letter after space

        String outputStr = "";

        if (!inputStr.isEmpty()) {

            String[] str = inputStr.split(" ");

            for (int i = 0; i < str.length; i++) {
                str[i] = (str[i]).substring(0, 1).toUpperCase() + (str[i]).substring(1);
            }

            for (int i = 0; i < str.length; i++) {
                outputStr += str[i];
            }
        }

        return outputStr;

    }

    @Override
    public String decompress(String inputStr) {

        //add spaces before UpperCase letters and make them LowerCase

        String outputStr = "";

        List<String> listWords = new ArrayList();

        int j = 0;
        int lastIdx = 0;

        if (!inputStr.isEmpty()) {

            for (int i = 1; i < inputStr.length(); i++) {
                if (Character.isUpperCase(inputStr.charAt(i))) {
                    listWords.add(inputStr.substring(lastIdx, i).toLowerCase());
                    lastIdx = i;
                }

            }
            listWords.add(inputStr.substring(lastIdx, inputStr.length()).toLowerCase());

            for (String s : listWords) {
                outputStr += s + " ";
            }
            // Remove Whitespaces ONLY at the end of a String
            // replaceFirst:
            // \\s++ - one or more white space characters
            // $ - end of string
            outputStr = outputStr.replaceFirst("\\s++$", ""); //


//            System.out.println(outputStr);
        }
        return outputStr;
    }


}
