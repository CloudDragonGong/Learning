package leetcode.backtrack;
//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
//
//例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
//给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/restore-ip-addresses
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//执行结果：
//通过
//显示详情
//查看示例代码
//添加备注
//
//执行用时：
//5 ms
//, 在所有 Java 提交中击败了
//45.59%
//的用户
//内存消耗：
//40.8 MB
//, 在所有 Java 提交中击败了
//77.19%
//的用户
//通过测试用例：
//146 / 146
import java.util.ArrayList;
import java.util.List;

public class p4 {
    public static void main(String[] args) {
        String s = new String("0279245587303");
        System.out.println(restoreIpAddresses(s));
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() < 4) return list;
        BT(s, 0, 0, list);
        return list;
    }

    public static void BT(String s, int position, int pointNum, List<String> list) {
        if (pointNum == 3) {
            if (judging_meets(s.substring(position, s.length()))) {
                list.add(s);
                return;
            } else return;
        }
        for (int i = position; i < s.length() - 1; i++) {
            if (!judging_meets(s.substring(position, i + 1))) return;
            String scopy = s.substring(0, i + 1) + "." + s.substring(i + 1, s.length());
            pointNum++;
            BT(scopy, i + 2, pointNum, list);
            pointNum--;
        }
    }

    public static boolean judging_meets(String s) {
        if(s.length()>3) return false;
        if(s.charAt(0)=='0'&&s.length()>1) return false;
        if (Integer.parseInt(s) < 256 && Integer.parseInt(s) >= 0) {
            return true;
        } else {
            return false;
        }
    }
}
