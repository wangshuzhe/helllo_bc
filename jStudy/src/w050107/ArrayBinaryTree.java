package w050107;

import java.util.ArrayList;
import java.util.List;

/**
 * 列表实现二叉树
 */
public class ArrayBinaryTree {
    private List<Integer> tree;
    public ArrayBinaryTree(List<Integer> tree) {
        this.tree = new ArrayList<>();
    }

    public int size() {
        return tree.size();
    }

    public Integer val(int index) {
        if (index < 0 || index >= tree.size()) {
            return null;
        }
        return tree.get(index);
    }

    /**
     * 获取左节点的索引
     * @param index
     * @return
     */
    public Integer left(int index) {
        return 2 * index + 1;
    }

    /**
     * 获取右节点的索引
     */
    public Integer right(int index) {
        return 2 * index + 2;
    }

    /**
     * 获取父节点的索引
     */
    public Integer parent(int index) {
        return (index - 1) / 2;
    }

    /**
     * 层序遍历
     */
    public List<Integer> levelOrder() {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < tree.size(); i++) {
            if (val(i) != null) {
                res.add(val(i));
            }
        }
        return res;
    }

    /**
     * 深度优先遍历
     */
    private void dfs(Integer i, String order, List<Integer> res) {
        if (val(i) == null) {
            return;
        }
        // 前序遍历
        if ("pre".equals(order)) {
            res.add(val(i));
        }
        dfs(left(i), order, res);
        //中序遍历
        if ("in".equals(order)) {
            res.add(val(i));
        }
        //后序遍历
        if ("post".equals(order)) {
            res.add(val(i));
        }
    }

    /**
     * 前序遍历
     */
    public List<Integer> preOreder() {
        List<Integer> res = new ArrayList<>();
        dfs(0, "pre", res);
        return res;
    }

    /**
     * 中序遍历
     */
    public List<Integer> inOrder() {
        List<Integer> res = new ArrayList<>();
        dfs(0, "in", res);
        return res;
    }

    /**
     * 后序遍历
     */
    public List<Integer> postOrder() {
        List<Integer> res = new ArrayList<>();
        dfs(0, "post", res);
        return res;
    }
}
