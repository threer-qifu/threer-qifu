import org.junit.Test;
public class IOTest {
    @Test
    public void readTxtTest() {
        String str = IO.IN("C:/Users/86153/Desktop/ceshi2/test.txt");
        String[] strings = str.split(" ");
        for (String string : strings) {
            System.out.println(string);
        }
    }
    @Test
    public void writeTxtTest() {
        double[] elem = {0.11, 0.22, 0.33, 0.44, 0.55};
        for (int i = 0; i < elem.length; i++) {
            IO.OUT(elem[i], "C:/Users/86153/Desktop/ceshi2/ttest.txt");
        }
    }
}