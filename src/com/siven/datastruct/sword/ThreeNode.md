#二叉树知识点

![二叉树](https://upload-images.jianshu.io/upload_images/2405011-5f5b0b136713f744.jpg?imageMogr2/auto-orient/strip|imageView2/2/w/1200/format/webp)
如图1所示，三种遍历方法(人工)得到的结果分别是：<br>
先序：1 2 4 6 7 8 3 5<br>
中序：4 7 6 8 2 1 3 5<br>
后序：7 8 6 4 2 5 3 1<br>

三种遍历方法的考查顺序一致，得到的结果却不一样，原因在于：<br>
+ 先序<br>
考察到一个节点后，即刻输出该节点的值，并继续遍历其左右子树。(根左右)<br>
+ 中序<br>
考察到一个节点后，将其暂存，遍历完左子树后，再输出该节点的值，然后遍历右子树。(左根右)<br>
+ 后序<br>
考察到一个节点后，将其暂存，遍历完左右子树后，再输出该节点的值。(左右根)<br>

## 代码案例
### 先序遍历
+ 递归先序遍历
``` java
// 递归先序遍历
public static void recursionPreorderTraversal(TreeNode root) {
    if (root != null) {
        System.out.print(root.val + " ");
        recursionPreorderTraversal(root.left);
        recursionPreorderTraversal(root.right);
    }
}
```
+ 非递归先序遍历
![](https://upload-images.jianshu.io/upload_images/2405011-c0aa74a23a4d357d.jpg?imageMogr2/auto-orient/strip|imageView2/2/w/1200/format/webp)
因为要在遍历完节点的左子树后接着遍历节点的右子树，为了能找到该节点，需要使用栈来进行暂存。中序和后序也都涉及到回溯，所以都需要用到栈。
``` java
// 非递归先序遍历
public static void preorderTraversal(TreeNode root) {
    // 用来暂存节点的栈
    Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
    // 新建一个游标节点为根节点
    TreeNode node = root;
    // 当遍历到最后一个节点的时候，无论它的左右子树都为空，并且栈也为空
    // 所以，只要不同时满足这两点，都需要进入循环
    while (node != null || !treeNodeStack.isEmpty()) {
        // 若当前考查节点非空，则输出该节点的值
        // 由考查顺序得知，需要一直往左走
        while (node != null) {
            System.out.print(node.val + " ");
            // 为了之后能找到该节点的右子树，暂存该节点
            treeNodeStack.push(node);
            node = node.left;
        }
        // 一直到左子树为空，则开始考虑右子树
        // 如果栈已空，就不需要再考虑
        // 弹出栈顶元素，将游标等于该节点的右子树
        if (!treeNodeStack.isEmpty()) {
            node = treeNodeStack.pop();
            node = node.right;
        }
    }
}
```
### 中序遍历
+  递归中序遍历
``` java
// 递归中序遍历
public static void recursionMiddleorderTraversal(TreeNode root) {
    if (root != null) {
        recursionMiddleorderTraversal(root.left);
        System.out.print(root.val + " ");
        recursionMiddleorderTraversal(root.right);
    }
}
```

+ 非递归中序遍历<br>
和非递归先序遍历类似，唯一区别是考查到当前节点时，并不直接输出该节点。
而是当考查节点为空时，从栈中弹出的时候再进行输出(永远先考虑左子树，直到左子树为空才访问根节点)。

``` java
// 非递归中序遍历
public static void middleorderTraversal(TreeNode root) {
    Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
    TreeNode node = root;
    while (node != null || !treeNodeStack.isEmpty()) {
        while (node != null) {
            treeNodeStack.push(node);
            node = node.left;
        }
        if (!treeNodeStack.isEmpty()) {
            node = treeNodeStack.pop();
            System.out.print(node.val + " ");
            node = node.right;
        }
    }
}
``` 
### 后序遍历
+ 递归后续遍历
``` java
// 递归后序遍历
public static void recursionPostorderTraversal(TreeNode root) {
    if (root != null) {
        recursionPostorderTraversal(root.left);
        recursionPostorderTraversal(root.right);
        System.out.print(root.val + " ");
    }
}
``` 

