---
title: LeetCode21-合并两个有序链表
date: 2020-03-09
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4

输出：1->1->2->3->4->4

## 分析

以前我们做过 合并两个有序的数组，那是通过 从数组最末尾来插入赋值实现的

现在要合并两个有序的链表的话，就是 弄一个新的链表头

然后两个链表中，谁小，就用当前指针指向谁，然后一起移动。最后谁还剩，指向它就行了。。画个图分析 还是很简单的

Time: O(m+n), Space: O(1)   时间复杂度 就是 最长的那个链表

## 总结
1. 这道题构建一个头结点会很容易，这样就不用关心第一个节点怎么处理了
2. 头结点与当前指针，两个链表中，谁小，就将当前指针指向谁，然后一起移动，OK
3. 最后谁还有多余的，直接当前指针指向即可

## 解答

````java
import org.junit.Test;
public class LeetCode21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 定义一个头结点，这样便于操作
        ListNode head = new ListNode(0);
        ListNode p = head;
        // 如果l1 l2 都不为空 谁小 就将p指向谁
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 != null) p.next = l1;
        if(l2 != null) p.next = l2;
        return head.next;

    }
}



````









