package com.siven.datastruct.sword;

import com.siven.datastruct.sword.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * create time : 2021/6/18
 * coding : siven
 * description : 剑指 Offer 32 - I. 从上到下打印二叉树
 * <p>
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * <p>
 *  
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回：
 * <p>
 * [3,9,20,15,7]
 *  
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword32 {

    public static void main(String[] args) {

    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int[] levelOrder(TreeNode root) {
            if (root == null){
                return null;
            }
            List<Integer> reResult = recuLevelOrder(root);
            int[] result = new int[reResult.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = reResult.get(i).intValue();
            }
            return result;
        }

        public List<Integer> recuLevelOrder(TreeNode root) {
            if (root == null) {
                return null;
            }
            List<Integer> result = new ArrayList<>();
            // 用一个队列来来临时存储节点，每次优先左子树入队
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                result.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            return result;
        }
    }
}
