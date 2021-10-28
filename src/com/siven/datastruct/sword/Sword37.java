package com.siven.datastruct.sword;

import com.siven.datastruct.sword.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * create time : 2021/7/12
 * coding : siven
 * description : 剑指 Offer 37. 序列化二叉树
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword37 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(5);
        String result = codec.serialize(node);
        TreeNode nodeResult = codec.deserialize(result);
        System.out.println("");
    }
    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null){
                return null;
            }
            List<String> temp = new ArrayList<>();
            justSerialize(root,temp);
            StringBuilder result = new StringBuilder();
            for (String node : temp){
                result.append(",");
                result.append(node);
            }
            return result.toString().replaceFirst(",","");
        }

        private void justSerialize(TreeNode node,List<String> list){
            if (node == null){
                list.add("null");
                return;
            }
            list.add(String.format("%s",node.val));
            justSerialize(node.left,list);
            justSerialize(node.right,list);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0){
                return null;
            }
            String[] nodeArray = data.split(",");
            List<String> nodeList = new ArrayList<>();
            for (String node : nodeArray){
                nodeList.add(node);
            }
            TreeNode root = new TreeNode(Integer.parseInt(nodeList.remove(0)));
            root.left = justDeserialize(nodeList);
            root.right = justDeserialize(nodeList);
            return root;
        }

        private TreeNode justDeserialize(List<String> nodeList){
            if (nodeList.isEmpty()){
                return null;
            }
            String nodeStr = nodeList.remove(0);
            if ("null".equals(nodeStr)){
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(nodeStr));
            // left
            node.left = justDeserialize(nodeList);
            // right
            node.right = justDeserialize(nodeList);
            return node;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

}
