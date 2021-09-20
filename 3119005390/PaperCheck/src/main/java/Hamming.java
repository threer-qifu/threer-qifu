public class Hamming {
    //计算海明距离
    public static int getHammingDistance(String SimHash1, String SimHash2) {
        int distance = 0;
        if (SimHash1.length() != SimHash2.length()) {
            // 出错，返回-1
            distance = -1;
        } else {
            for (int i = 0; i < SimHash1.length(); i++) {
                // 每一位进行比较
                if (SimHash1.charAt(i) != SimHash2.charAt(i)) {
                    distance++;
                }
            }
        }
        return distance;
    }
    //计算重复率
    public static double getSimilarity(String SimHash1, String SimHash2) {
        // 通过 SimHash1 和 SimHash2 获得它们的海明距离
        int distance = getHammingDistance(SimHash1, SimHash2);
        // 通过海明距离计算出重复率
        return 0.01 * (100 - distance * 100 / 128);
    }
}