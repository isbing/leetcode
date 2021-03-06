---
title: LeetCode206-单链表反转
date: 2020-03-07
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL

输出: 5->4->3->2->1->NULL


## 分析
输入: 1->2->3->4->5->NULL

- 第一步： null <- 1  |||  2->3->4->5->null

- 第二步： null <- 1 <- 2 ||| 3->4->5->null

- ....

这样就完成了单链表的反转  Time: O(n), Space: O(1)

## 总结
1. 采用迭代的方法，用当前指针与前驱指针，只要当前指针每次循环指向前驱指针就行，但是要注意链表不要断链，需要用next保存一下
2. 采用递归的方法，总体思路与迭代的方式一样，核心就是当前指针需要指向前驱指针，然后两个指针一起移动

## 解答

````java
import org.junit.Test;
public class LeetCode206 {

    // 迭代  1-2-3-4-5
    public ListNode reverseList_1(ListNode head) {
        // 定义两个指针，current与它的前指针
        ListNode current = head, pre = null;
        while (current != null){
            ListNode next = current.next;
            current.next = pre;// current指向前指针 即可
            // 更新current与pre指针
            pre = current;
            current = next;
        }
        return pre;
    }

    // 采用递归。思路还是这样，用当前指针，前驱指针
    public ListNode reverseList_2(ListNode head) {
        return reverseList_2_di(null,head);
    }

    private ListNode reverseList_2_di(ListNode pre, ListNode current) {
        if(current == null) return pre;
        // 保存next指针
        ListNode next = current.next;
        current.next = pre;
        return reverseList_2_di(current,next);
    }

}


````









