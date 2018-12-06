package compress;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Created by Grzegorz Chrzaszczyk on 01-12-2018  11:58 AM
 */
public class OptimalCompresor implements Compresor {

    public OptimalCompresor() {

//        Smaz smaz = new Smaz();
//        String testString = "this is a simple test";
//        byte[] compressed = smaz.compress(testString);
//        String uncompressedString = smaz.decompress(compressed);
//        assertEquals(testString, uncompressedString);
    }

    @Override
    public String compress(String inputStr) {

        Smaz smaz = new Smaz();
        byte[] compressed = smaz.compress(inputStr);
//        return compressed.toString(); //shows only byte value!
        //Convert byte[] to String using String constructor
        String str = new String(compressed, StandardCharsets.UTF_8);
        return str;
    }

    @Override
    public String decompress(String inputStr) {

        Smaz smaz = new Smaz();
        byte[] bytes = inputStr.getBytes(StandardCharsets.UTF_8);
        //Base64 Decoded
//        byte[] bytes = Base64.getDecoder().decode(inputStr);
        String uncompressedString = smaz.decompress(bytes);
        return uncompressedString;
    }

    public byte[] compressByte(String inputStr) {

        Smaz smaz = new Smaz();
        byte[] compressed = smaz.compress(inputStr);
        return compressed;
    }

    public String decompressByte(byte[] bytes) {

        Smaz smaz = new Smaz();
        String uncompressedString = smaz.decompress(bytes);
        return uncompressedString;
    }

    public void conversion() {

        System.out.println("\n---CONVERSION---\n");

        String str = "Hello World";

        byte[] bytes = str.getBytes();
        byte[] byteArr = str.getBytes(StandardCharsets.UTF_8);

        //Convert byte[] to String
        String s = new String(bytes);
        System.out.println(s);
        s = new String(byteArr);
        System.out.println(s);

        //Convert byte[] to String
        s = Base64.getEncoder().encodeToString(byteArr);
        System.out.println("Base64.getEncoder = " + s);

        //Base64 Decoded
        byte[] bytesDecoded = Base64.getDecoder().decode(s);
        s = new String(bytesDecoded);
        System.out.println("Text Decrypted : " + s);

    }

    public void sample() {

        byte[] byteArray = {87, 79, 87, 46}; //WOW.
        String value0 = new String(byteArray);
        String value1 = new String(byteArray, StandardCharsets.UTF_8);
        System.out.println("\n" + value0 + " " + value1);

        String example = "This is an example";
        byte[] bytes = example.getBytes();

        System.out.println("Text : " + example + "\t\t\t\tsize = " + example.length());
        System.out.println("Text [Byte Format] : " + bytes + "\t\tsize = " + bytes.length);
        System.out.println("Text [Byte Format] : " + bytes.toString() + "\t\tsize = " + bytes.toString().length());

        String ss = new String(bytes);
        System.out.println("Text Decrypted : " + ss);

        // Smaz use
        Smaz smaz = new Smaz();
        String testString = "this is a simple test for Smaz";
        System.out.println(">>> Smaz use <<<\nSmaz txt : " + testString + "\t\t\t\tsize = " + testString.length());
        byte[] compressed = smaz.compress(testString);
        System.out.println("Smaz compressed [Byte Format] : " + compressed + "\t\t\t\tsize = " + compressed.length);
        String uncompressedString = smaz.decompress(compressed);
        System.out.println("Smaz decompressed : " + uncompressedString + "\t\tsize = " + uncompressedString.length() + "\n\n\n");


    }


}
