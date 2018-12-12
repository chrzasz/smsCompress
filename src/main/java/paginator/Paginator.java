package paginator;

/**
 * Created by Grzegorz Chrzaszczyk on 01-12-2018  11:41 AM
 */
public class Paginator {

    private int smsLenght;

    public Paginator(int smsLenght) throws IllegalArgumentException {
        if (smsLenght > 0) {
            this.smsLenght = smsLenght;
        } else {
            this.smsLenght = 0;
            throw new IllegalArgumentException();
        }
    }

    public int getSmsLenght() {
        return smsLenght;
    }

    public void setSmsLenght(int smsLenght) {
        this.smsLenght = smsLenght;
    }

    public String[] paginate(String text) {

        if (text.length() == 0) {
            return null;
        }

        int splitSize = text.length() / smsLenght;
        String[] outStrTab = new String[splitSize + 1];
        int idx = 0;

        if (splitSize > 1) {

            for (int i = 0; i < text.length(); i += smsLenght) {
                outStrTab[idx++] = text.substring(i, Math.min(i + smsLenght, text.length()));
//                System.out.println("SMS no." + ((i/smsLenght)+1) + " = " +text.substring(i, Math.min(i + smsLenght, textLenght)));
            }
        }

        return outStrTab;
    }


}
