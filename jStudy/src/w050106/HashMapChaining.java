package w050106;

import java.util.ArrayList;
import java.util.List;

/**
 * 列表式的哈希表
 * 支持扩容
 *
 */
public class HashMapChaining {
    //键值对数量
    int size;
    //哈希表容量
    int capacity;
    //触发扩容的负载因子阈值
    double loadThres;
    //扩容倍数
    int extendRatio;
    //桶数组
    List<List<Pair>> buckets;

    public HashMapChaining() {
        size = 0;
        capacity = 4;
        loadThres = 2.0/3.0;
        extendRatio = 2;
        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    /**
     * 哈希函数
     */
    private int hashFunc(int key) {
        return key % capacity;
    }

    /**
     * 负载因子
     */
    double loadFactor() {
        return (double) size / capacity;
    }

    /**
     * 添加操作
     */
    void put(int key, String val) {
        if (loadFactor() > loadThres) {
            extend();
        }
        int index = hashFunc(key);
        List<Pair> pairList = buckets.get(index);
        for (Pair pair : pairList) {
            if (key == pair.getKey()) {
                pair.setVal(val);
                return;
            }
        }
        buckets.get(index).add(new Pair(key, val));
        size++;
    }

    /**
     * 删除操作
     */
    void remove(int key) {
        int index = hashFunc(key);
        List<Pair> pairList = buckets.get(index);
        for (Pair pair : pairList) {
            if (key == pair.getKey()) {
                pairList.remove(pair);
                size--;
                break;
            }
        }
    }

    /**
     * 查询操作
     */
    String get(int key) {
        int index = hashFunc(key);
        for (Pair pair : buckets.get(index)) {
            if (key == pair.getKey()) {
                return pair.getVal();
            }
        }
        return null;
    }

    /**
     * 扩容操作
     */
    void extend() {
        List<List<Pair>> bucketMaps = buckets;
        buckets = new ArrayList<>(capacity * extendRatio);
        for (int i = 0; i < capacity; i++) {
            buckets.add(new ArrayList<>());
        }
        size = 0;
        for (List<Pair> pairList : bucketMaps) {
            for (Pair pair : pairList) {
                put(pair.getKey(), pair.getVal());
            }
        }
    }

    void print() {
        for (List<Pair> bucket : buckets) {
            List<String> res = new ArrayList<>();
            for (Pair pair : bucket){
                res.add(pair.getVal() + " -> " + pair.getVal());
            }
            System.out.println(res);
        }
    }
}
