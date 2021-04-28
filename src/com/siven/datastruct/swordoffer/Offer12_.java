package com.siven.datastruct.swordoffer;

/**
 * author siven
 * date: 2020/7/26
 * desc: 典型的矩阵搜索问题，可使用 深度优先搜索（DFS）+ 剪枝 解决
 *
 * @link https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 **/
public class Offer12_ {

    /**
     * 背景：
     * 矩阵中有三个方向可以进行深度遍历
     * 思路：
     *
     * @param args
     */
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(new Offer12_().exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 从 (0, 0) 点开始进行 dfs 操作，不断地去找，
                // 如果以 (0, 0) 点没有对应的路径的话，那么就从 (0, 1) 点开始去找
                if (dif(board, chars, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param board
     * @param word
     * @param visited
     * @param i
     * @param j
     * @param cursor  表示找到单词的游标，若cursor == word.length 说明成功了
     * @return
     */
    public static boolean dif(char[][] board, char[] word, boolean[][] visited, int i, int j, int cursor) {
        // 终止条件
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || word[cursor] != board[i][j]) {
            return false;
        }
        if (cursor == word.length-1) {
            return true;
        }
        visited[i][j] = true;
        // 矩形四个方向深度遍历
        // 回退
        boolean result = dif(board, word, visited, i + 1, j, cursor + 1)
                || dif(board, word, visited, i, j + 1, cursor + 1)
                || dif(board, word, visited, i - 1, j, cursor + 1)
                || dif(board, word, visited, i, j - 1, cursor + 1);
        visited[i][j] = false;
        return result;
    }
}
