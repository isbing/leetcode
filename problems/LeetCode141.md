---
title: LeetCode141-链表是否有环
date: 2019-07-09
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
这个题目说的是，给你一个单链表，你要判断它是否会形成环

环形的定义：链表的最后一个节点指向了前面一个已经存在的节点

## 分析
### 解法1
有环的定义就是 链表最后一个节点的next要等于链表中的某一个节点

可以一次循环，将遍历过的点都保存到set集合中,每遍历到一个新的节点，就去set中看是否曾经出现过

时间0(N) 空间O(N)

### 优化解
快慢指针 我们可以设想一下 

快慢指针初始都在起点处，快指针每次走两步 慢指针每次走一步

若是环形的，快指针一定会超过慢指针一圈 两圈 三圈....

若不是环形的，快的next 先为null了

设想一下 在环形操场跑步的场景 

这里不需要额外的set集合，空间为0(1) 时间0(N)

## 解答

````java
import org.junit.Test;
public class LeetCode141Test {

	// 时间O(N) 空间O(1)
	public boolean hasCycleV2(ListNode head) {
		if(head == null) return false;
		// 初始化快慢指针
		ListNode fast = head;
		ListNode low = head;
		while (fast != null && fast.next != null){
			// 快的跑两步 慢的跑一步
			fast = fast.next.next;
			low = low.next;
			if(fast == low){
				return true;
			}
		}
		return false;
	}

	// 时间O(N) 空间O(N)
	public boolean hasCycle(ListNode head) {
		if(head == null) return false;
		Set<ListNode> set = new HashSet<>();
		while (head != null){
			if(set.contains(head)){
				return true;
			}
			set.add(head);
			head = head.next;
		}
		return false;
	}
}


````









