package compress;

/**
 * Created by Grzegorz Chrzaszczyk on 01-12-2018  11:58 AM
 */
public class OptimalCompresor implements Compresor{

    public OptimalCompresor() {
    }

    @Override
    public String compress(String inputStr) {

        Smaz smaz = new Smaz();
        byte[] compressed = smaz.compress(inputStr);
        return compressed.toString();
    }

    @Override
    public String decompress(String inputStr) {

        Smaz smaz = new Smaz();
        byte[] compressed = smaz.compress(inputStr);
        String uncompressedString = smaz.decompress(compressed);
        return uncompressedString;
    }
}
