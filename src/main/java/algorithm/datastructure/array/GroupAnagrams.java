package algorithm.datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author lancelot
 * @date 2020/7/22
 * @description leetcode [49] 字母异位词分组
 * @difficulty Medium
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hash = new HashMap<>();

        for (String str: strs) {
            char[] strArr = str.toCharArray();
            //排序
            Arrays.sort(strArr);
            //映射到 key
            String key = String.valueOf(strArr);
            if (hash.containsKey(key)) {
                hash.get(key).add(str);
            } else {
                List<String> temp = new ArrayList<String>();
                temp.add(str);
                hash.put(key, temp);
            }
        }

        return new ArrayList<List<String>>(hash.values());
    }


}
