package algorithm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lancelot
 * @date 2020/3/22
 * 约瑟夫环问题
 */
public class Josephus {

    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i);

        int c = (m - 1) % n;
        while (list.size() != 1) {
            list.remove(c);
            c = (c + m - 1) % list.size();
        }
        return list.get(0);
    }
}
