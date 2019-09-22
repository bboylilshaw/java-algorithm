package io.xiaoyao.algorithm;

import io.xiaoyao.algorithm.common.BiTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * 使用前序，中序，后序遍历二叉树
 * 分别使用递归和非递归方式
 *
 * 四种主要的遍历思想为：
 *
 * 前序遍历：根结点 ---> 左子树 ---> 右子树
 *
 * 中序遍历：左子树 ---> 根结点 ---> 右子树
 *
 * 后序遍历：左子树 ---> 右子树 ---> 根结点
 *
 * 层次遍历：只需按层次遍历即可
 */
public class TraverseTree {

    /**
     * 前序遍历, 递归方式
     */
    public static void preOrderTraverse1(BiTreeNode root) {
        if (root == null) return;
        System.out.print(root.value + "  ");
        preOrderTraverse1(root.leftChild);
        preOrderTraverse1(root.rightChild);
    }

    /**
     * 前序遍历，非递归方式
     */
    public static void preOrderTraverse2(BiTreeNode root) {
        BiTreeNode pNode = root;
        Stack<BiTreeNode> stack = new Stack<>();
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                System.out.print(pNode.value + "  ");
                stack.push(pNode);
                pNode = pNode.leftChild;
            } else { //pNode == null, stack不为空
                pNode = stack.pop().rightChild;
            }
        }
    }

    /**
     * 中序遍历，递归方式
     */
    public static void inOrderTraverse1(BiTreeNode root) {
        if (root == null) return;
        inOrderTraverse1(root.leftChild);
        System.out.print(root.value + "  ");
        inOrderTraverse1(root.rightChild);
    }

    /**
     * 中序遍历，非递归方式
     */
    public static void inOrderTraverse2(BiTreeNode root) {
        BiTreeNode pNode = root;
        Stack<BiTreeNode> stack = new Stack<>();
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.leftChild;
            } else {
                BiTreeNode node = stack.pop();
                System.out.print(node.value + "  ");
                pNode = node.rightChild;
            }
        }
    }

    /**
     * 后序遍历，递归方式
     */
    public static void postOrderTraverse1(BiTreeNode root) {
        if (root == null) return;
        postOrderTraverse1(root.leftChild);
        postOrderTraverse1(root.rightChild);
        System.out.print(root.value + "  ");
    }

    /**
     * 后序遍历，非递归方式
     * 后序是 左子节点 --> 右子节点 --> 根节点
     * 那么先按 根节点 --> 右子节点 --> 左子节点，再反转链表
     */
    public static void postOrderTraverse2(BiTreeNode root) {
        BiTreeNode pNode = root;
        Stack<BiTreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                list.add(pNode.value);
                stack.push(pNode);
                pNode = pNode.rightChild;
            } else {
                BiTreeNode node = stack.pop();
                pNode = node.leftChild;
            }
        }

        Collections.reverse(list);

        for (Integer integer : list) {
            System.out.print(integer + "  ");
        }
    }

    public static void levelTraverse(BiTreeNode root) {
        Queue<BiTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BiTreeNode node = queue.poll();
            System.out.print(node.value + "  ");
            if (node.leftChild != null) queue.offer(node.leftChild);
            if (node.rightChild != null) queue.offer(node.rightChild);
        }
    }

    /**
     * 构建如下一棵二叉树
     *       7
     *     /   \
     *    6    3
     *   /\   / \
     *  9 5  4  8
     */
    public static void main(String[] args) {
        BiTreeNode root = new BiTreeNode(7);
        BiTreeNode l1 = new BiTreeNode(6);
        BiTreeNode r1 = new BiTreeNode(3);
        BiTreeNode l11 = new BiTreeNode(9);
        BiTreeNode l12 = new BiTreeNode(5);
        BiTreeNode r11 = new BiTreeNode(4);
        BiTreeNode r12 = new BiTreeNode(8);
        root.leftChild = l1;
        root.rightChild = r1;
        l1.leftChild = l11;
        l1.rightChild = l12;
        r1.leftChild = r11;
        r1.rightChild = r12;

        // 前序遍历
        System.out.println("前序");
        preOrderTraverse1(root);
        System.out.print("\n");
        preOrderTraverse2(root);
        System.out.print("\n");

        // 中序遍历
        System.out.println("中序");
        inOrderTraverse1(root);
        System.out.print("\n");
        inOrderTraverse2(root);
        System.out.print("\n");

        // 后序遍历
        System.out.println("后序");
        postOrderTraverse1(root);
        System.out.print("\n");
        postOrderTraverse2(root);
        System.out.print("\n");

        // 层次遍历
        System.out.println("层次遍历");
        levelTraverse(root);
        System.out.print("\n");
    }

}
