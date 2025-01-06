package w050106;

import java.util.ArrayList;
import java.util.List;

/**
 * 简易实现的 map
 * 此 map 容量固定为 100，不支持扩容
 * 还会出现哈希冲突， 当 key % 100 时获取数据就有问题。
 */
public class ArrayHashMap {
    private List<Pair> buckets;

    /**
     * 构造函数
     */
    public ArrayHashMap() {
        buckets = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            buckets.add(null);
        }
    }

    /**
     * 哈希函数
     */
    private int hashFunc(int key) {
        return key % 100;
    }

    /**
     * 添加操作
     */
    public void put(int key, String val) {
        Pair pair = new Pair(key, val);
        int index = hashFunc(key);
        buckets.set(index, pair);
    }

    /**
     * 删除操作
     */
    public void remove(int key) {
        buckets.set(hashFunc(key), null);
    }

    /**
     * 获取所有键值对
     */
    public List<Pair> pairSet() {
        List<Pair> pairList = new ArrayList<>();
        for (Pair pair : buckets) {
            if (pair != null) {
                pairList.add(pair);
            }
        }
        return pairList;
    }

    /**
     * 获取所有键
     */
    public List<Integer> keySet() {
        List<Integer> keySet = new ArrayList<>();
        for (Pair pair : buckets) {
            if (pair != null) {
                keySet.add(pair.getKey());
            }
        }
        return keySet;
    }

    /**
     * 获取所有值
     */
    public List<String> valueSet() {
        List<String> valueSet = new ArrayList<>();
        for (Pair pair : buckets) {
            if (pair != null) {
                valueSet.add(pair.getVal());
            }
        }
        return valueSet;
    }

    /**
     * 打印哈希表
     */
    public void print() {
        for (Pair pair : buckets) {
            System.out.println(pair.getKey() + " -> " + pair.getVal());
        }
    }
}
