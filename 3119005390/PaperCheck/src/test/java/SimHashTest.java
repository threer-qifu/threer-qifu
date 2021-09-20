import org.junit.Test;
public class SimHashTest {
    @Test
    public void getHashTest(){
        String[] strings = {"绝绝子", "绝绝子", "暴风吸入", "翘jiojio", "在逃公主", "隐藏甜品"};
        for (String string : strings) {
            String stringHash = SimHash.getHash(string);
            System.out.println(stringHash.length());
            System.out.println(stringHash);

        }
    }
    @Test
    public void getSimHashTest(){
        System.out.println("\n");
        String str0 = IO.IN("C:/Users/86153/Desktop/ceshi2/orig.txt");
        String str1 = IO.IN("C:/Users/86153/Desktop/ceshi2/orig_0.8_add.txt");
        System.out.println(SimHash.getSimHash(str0));
        System.out.println(SimHash.getSimHash(str1));
    }
}