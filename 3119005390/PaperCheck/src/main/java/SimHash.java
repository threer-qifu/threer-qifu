import com.hankcs.hanlp.HanLP;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
public class SimHash {
    //计算字符串的 Hash 值
    public static String getHash(String str){
        try{
            // 使用 MD5 获得 Hash 值
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            return new BigInteger(1, messageDigest.digest(str.getBytes("UTF-8"))).toString(2);
        }catch(Exception e){
            e.printStackTrace();
            return str;
        }
    }
    //计算字符串的 SimHash 值
    public static String getSimHash(String str){
        // 用数组表示特征向量,取128位,从 0 1 2 位开始表示从高位到低位
        int[] v = new int[128];
        // 1、分词（使用了外部依赖 hankcs 包提供的接口）
        List<String> keywordList = HanLP.extractKeyword(str, str.length());//取出所有关键词
        // Hash
        int size = keywordList.size();
        int i = 0;//以 i 做外层循环
        for(String keyword : keywordList){
            // 2、获取 Hash 值
            String keywordHash = getHash(keyword);
            if (keywordHash.length() < 128) {
                // Hash 值可能少于 128 位，在低位以 0 补齐
                int dif = 128 - keywordHash.length();
                for (int j = 0; j < dif; j++) {
                    keywordHash += "0";
                }
            }
            // 3、加权、合并
            for (int j = 0; j < v.length; j++) {
                // 对 keywordHash 的每一位与 '1' 进行比较
                if (keywordHash.charAt(j) == '1') {
                    //权重分 10 级，由词频从高到低，取权重 10~0
                    v[j] += (10 - (i / (size / 10)));
                } else {
                    v[j] -= (10 - (i / (size / 10)));
                }
            }
            i++;
        }
        // 4、降维
        String simHash = "";// 储存返回的 SimHash 值
        for (int j = 0; j < v.length; j++) {
            // 从高位遍历到低位
            if (v[j] <= 0) {
                simHash += "0";
            } else {
                simHash += "1";
            }
        }
        return simHash;
    }

}