import org.junit.Test;
public class HammingTest {
    @Test
    public void getHammingDistanceTest() {
        String str0 = IO.IN("C:/Users/86153/Desktop/ceshi2/orig.txt");
        String str1 = IO.IN("C:/Users/86153/Desktop/ceshi2/orig_0.8_add.txt");
        int distance = Hamming.getHammingDistance(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        System.out.println("海明距离：" + distance);
        System.out.println("重复率: " + (100 - distance * 100 / 128) + "%");
    }
}