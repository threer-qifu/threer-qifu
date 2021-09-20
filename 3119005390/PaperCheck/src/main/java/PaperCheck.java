public class PaperCheck {
    public static void main(String[] args) {
        // 依次按输入的绝对路径读取文件并转化为字符串
        String str0 = IO.IN(args[0]);
        String str1 = IO.IN(args[1]);
        String str2 = args[2];
        // 得到两篇文章各自对应的 SimHash 值
        String simHash0 = SimHash.getSimHash(str0);
        String simHash1 = SimHash.getSimHash(str1);
        // 由 SimHash 值求出重复率
        double similarity = Hamming.getSimilarity(simHash0, simHash1);
        // 在答案文件中写入重复率
        IO.OUT(similarity, str2);
        System.out.println("结果已写入："+str2);
        // 退出程序
        System.exit(0);
    }
}