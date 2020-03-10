---
title: LeetCode2-链表中的两数相加
date: 2020-03-10
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的

并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)

输出：7 -> 0 -> 8

原因：342 + 465 = 807


## 分析

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)

我们要记录一个进位标记，flag初始化为0

1. 链表1不为空，或者链表2不为空，或者flag不为0 就可以进入循环
2. 链表1 链表2同时开始循环，首先2+5=7 无进位，7作为新链表的第一个节点，尾插法
3. 4+6+0=10 有进位为1,0作为新链表的第二个节点
4. 3+4+1=8 无进位，+1在这里是加上了进位。8作为第三个节点
5. 发现进位为0.链表1 2都为null了，结束循环就可以

Time: O(max(m, n)), Space: O(max(m, n))

## 总结
1. 这个题目 采用进位的思路做，三个很核心的元素：链表1数据，链表2数据，进位标识
2. 只要这三个符合一项就能进入循环计算，具体看代码
3. Time: O(max(m, n)), Space: O(max(m, n))
4. 合理创建头结点

## 解答

````java
import org.junit.Test;
public class LeetCode2 {

	// l1:2-4-3 l2:5-6-4  342+465=807 -> 7-0-8
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// 由于题目的特殊性 直接将两个链表中的每个元素依次相加，注意进位
		int flag = 0;
		ListNode head = new ListNode(0);
		ListNode p = head;
		// 只要两个链表有长度，或者 有进位 都是要进入循环的
		while (l1 != null || l2 != null || flag != 0){
			int l1Val = 0, l2Val = 0;
			if(l1 != null){
				l1Val = l1.val;
				l1 = l1.next;
			}
			if(l2 != null){
				l2Val = l2.val;
				l2 = l2.next;
			}
			// 新链表中的元素
			int l3Val = l1Val + l2Val + flag;
			// 判断是否需要进位
			if(l3Val > 9){
				flag = 1;// 下次使用
				l3Val = l3Val % 10;// 新链表中的元素只能用你的余数了 因为你进位了
			}else{
				// 不用进位 需要将标识重置为0
				flag = 0;
			}
			// 这里典型的尾插法
			ListNode l3 = new ListNode(l3Val);
			p.next = l3;
			p = l3;
		}
		return head.next;
	}

}




````









