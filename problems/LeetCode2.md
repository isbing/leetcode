---
title: LeetCode2-链表中的两数相加
date: 2019-07-13
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
### 常规想法
我觉得看到这题的常规想法就是 

1. 链表1循环一遍 得到整数243，然后从右向左读成342
2. 链表2循环一遍 得到整数564，然后从右向左读成465
3. 342+465=807
4. 807 % 10 取到第一个数7作为新链表的第一个节点
5. 然后807/10变为80 取到第二个数字0作为第二个节点
6. 这样最后新的链表就出来了

Time: O(max(m, n)), Space: O(max(m, n))

### 另一种解法
其实这种解法也说不上优化，只是代码写起来 会更方便。但是时间 空间没啥变化

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)

我们要记录一个进位标记，flag初始化为0

1. 链表1不为空，或者链表2不为空，或者flag不为0 就可以进入循环
2. 链表1 链表2同时开始循环，首先2+5=7 无进位，7作为新链表的第一个节点
3. 4+6+0=10 有进位为1,0作为新链表的第二个节点
4. 3+4+1=8 无进位，+1在这里是加上了进位。8作为第三个节点
5. 发现进位为0.链表1 2都为null了，结束循环就可以

Time: O(max(m, n)), Space: O(max(m, n))

## 解答

````java
import org.junit.Test;
public class LeetCode2Test {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// -1作为头结点
		ListNode result = new ListNode(-1);
		// 尾插法
		ListNode tail = result;
		// 进位标识
		int flag = 0;
		while (l1 != null || l2 != null || flag != 0){
			int num = flag; //需要加上 进位
			if(l1 != null){
				num += l1.val;
				l1 = l1.next;
			}
			if(l2 != null){
				num += l2.val;
				l2 = l2.next;
			}
			flag = num / 10;
			if(num >= 10){
				num = num % 10;
			}
			ListNode node = new ListNode(num);
			tail.next = node;
			tail = node;
		}
		return result.next;
	}

}



````









