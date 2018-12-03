package compress;

/**
 * Created by Grzegorz Chrzaszczyk on 01-12-2018  10:48 AM
 */
public interface Compresor {

    String compress(String inputStr);
    String decompress(String inputStr);

}
