package com.isbing.leetcode.coding;

import com.isbing.leetcode.LeetCoding;
import com.isbing.leetcode.bean.ListNode;

import java.util.Stack;

/**
 * Created by songbing
 * Created time 2019/5/16 下午9:43
 */
public abstract class LeetCode234 extends LeetCoding{

    // 思路一：用额外栈。将链表的数据依次压栈，然后出栈与链表比对。两次循环 时间空间都为O(N)
    // 思路二：不用额外栈。反转单链表。【反转一半】 成为两个链表 用一个循环比较 时间O(N) 空间O(1)

    /**
     * 请判断一个链表是否为回文链表。
     示例 1:
     输入: 1->2
     输出: false
     示例 2:
     输入: 1->2->2->1
     输出: true
     */
    @Override
    public boolean isPalindrome(ListNode head) {
        return solution1(head);
    }


    private boolean solution1(ListNode head) {
        // 1-2-3-2-1
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null){
            stack.push(p.val);
            p = p.next;
        }
        ListNode q = head;
        while (q != null){
            if(q.val != stack.pop())
                return false;
            q = q.next;
        }
        return true;
    }

    private boolean solution2(ListNode head) {
        // todo 这是错误的解法。翻转整个链表的话 会损坏原有链表。只能翻转一半的链表。。。
//        // 单链表的反转
//        ListNode p = head;
//        ListNode current = head;
//        ListNode pre = null;
//        while (current != null){
//            ListNode next = current.next;
//            current.next = pre;
//            pre = current;
//            current = next;
//        }
//        // pre 就指向反转后的第一个节点
//        // p 指向正向的 第一个节点
//        while (p != null && pre != null){
//            if(p.val != pre.val){
//                return false;
//            }
//            p = p.next;
//            pre = pre.next;
//        }
//        return true;



        return true;
    }
}
