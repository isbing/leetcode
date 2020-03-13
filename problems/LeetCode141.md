---
title: LeetCode141-链表是否有环
date: 2020-03-13
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

## 总结
1. 判断链表有环，法一，使用set，set中保存每一个ListNode
2. 判断链表有环，法二，快慢指针，若有环，一定会相遇；若没环，快指针就直接走完了

## 解答

````java
import org.junit.Test;
public class LeetCode141 {

	// 每遍历到一个节点，就看看set中是否存在，存在即代表有环，比较的是节点，而不是节点中的数据
	// 时间o(n) 空间o(n)
	public boolean hasCycle_1(ListNode head) {
		Set<ListNode> set = new HashSet<>();
		while (head != null){
			if(set.contains(head)){
				return true;
			}else{
				set.add(head);
			}
			head = head.next;
		}
		return false;
	}

	// 不使用set，快慢指针，存在环，两个指针一定会相遇，不存在环，快指针直接就走完了
	// 时间o(n) 空间o(1)
	public boolean hasCycle_2(ListNode head) {
		ListNode fast = head,slow = head;
		while (fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) return true;
		}
		return false;
	}

}



````









