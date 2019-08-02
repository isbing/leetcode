---
title: LeetCode83-有序链表中去重
date: 2019-07-28
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目

给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:

输入: 1->1->2

输出: 1->2

示例 2:

输入: 1->1->2->3->3

输出: 1->2->3


## 分析

1. 如果为null 就返回null
2. 定义前后指针 p=head,q=head.next
3. 只要q!=null，就进入循环 比较pq节点值，相等 不相等 对应的移动
4. 最后返回head即可

这样的题目 对着图分析 还是比较简单的

Time: O(n), Space: O(1)

## 解答

````java
import org.junit.Test;
public class LeetCode83Test {

	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return null;
		// 定义前后指针
		ListNode p = head;
		ListNode q = head.next;
		while (q != null){
			if(p.val != q.val){
				// 不相等 两个一起跑
				p = p.next;
				q = q.next;
			}else{
				// 相等
				p.next = q.next;
				q = q.next;
			}
		}
		return head;
	}
}


````









