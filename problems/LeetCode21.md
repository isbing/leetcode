---
title: LeetCode21-合并两个有序链表
date: 2019-07-08
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

然后两个链表中，谁小，就断链，将这个节点单独弄出来，然后将新链表指向它

最后谁还剩，指向它就行了。。画个图分析 还是很简单的

Time: O(m+n), Space: O(1)   时间复杂度 就是 最长的那个链表

## 解答

````java
import org.junit.Test;
public class LeetCode21Test {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode myNode = new ListNode(-1);
		ListNode p = myNode;
		while (l1 != null && l2 != null){
			if(l1.val <= l2.val){
				ListNode temp = l1.next;
				// 断链
				l1.next = null;
				p.next = l1;
				p = l1;
				l1 = temp;
			}else{
				ListNode temp = l2.next;
				// 断链
				l2.next = null;
				p.next = l2;
				p = l2;
				l2 = temp;
			}
		}
		if (l1 != null){
			p.next = l1;
		}
		if (l2 != null){
			p.next = l2;
		}
		return myNode.next;
	}
}


````









