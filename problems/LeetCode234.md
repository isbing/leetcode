---
title: LeetCode234-回文链表
date: 2020-03-08
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
请判断一个链表是否为回文链表。

示例 1:

输入: 1->2

输出: false

示例 2:

输入: 1->2->2->1

输出: true

进阶：

你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

## 分析

### 解法1 
我们之前做过回文数的题目，那里提供的思路是 将数字转为字符串，或者从右向左读 构造一个新的数字

但是这里是链表，我们正常的思路 只能是将每一个链表的节点值压入栈中。最后出栈与链表中的值比较

时间0(N) 空间O(N)

### 解法2
因为上面用到了栈，空间复杂度提高了，可不可以不借助辅助栈呢？

链表遍历一次 得到长度，然后将前面一半的链表进行反转。

这样就出现了两个一半的链表，然后这两个链表同时遍历比较即可【注意奇数的情况】

时间0(N) 空间O(1)

## 总结
1. 第一次看到这个题目的时候，我的第一感觉就是可不可以将链表直接遍历一遍，将链表中的所有数字拼成字符串呢？不行的！！！第一段代码这样实现并且分析了错误原因
2. 正确做法有两种：用栈和不用栈
3. 用栈，第一次遍历，将链表中元素全部入栈，这样栈中的顺序就与链表顺序相反，再遍历一遍链表与栈中元素比较即可
4. 不用栈，反转一半长度的链表，这样就出现了两个半截长度的链表，依次进行比较，空间为o(1)，没有借助额外空间

## 解答

````java
import org.junit.Test;
public class LeetCode234 {
    
    // 遍历一次链表，将遍历得到的数字拼接成字符串，用字符串的方式比较
    // 时间o(n) 空间o(n) 因为开辟了字符串，数字变为字符串还是空间o(1)的
    // 发现这个思路是错误的，转为字符串之后，是一个个字符比较的，对于链表中的一个数字，应该是一个整体
    public boolean isPalindrome_1_fail(ListNode head) {
        StringBuilder num = new StringBuilder();
        while (head != null){
            num.append(head.val);
            head = head.next;
        }
        // 字符串
        String n = num.toString();
        int i = 0, j = n.length()-1;
        while (i < j){
            if(n.charAt(i) != n.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    // 用栈，第一次遍历链表，将所有元素都入栈，这样栈中的元素顺序就与链表顺序是相反的
    // 第二次遍历链表，每个元素与栈中的元素对比.时间空间都是o(n)
    public boolean isPalindrome_1(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp1 = head, temp2 = head;
        while (temp1 != null){
            stack.push(temp1.val);
            temp1 = temp1.next;
        }
        while (temp2 != null){
            if(temp2.val != stack.pop()) return false;
            temp2 = temp2.next;
        }
        return true;
    }

    // 如果不用栈，可以想到反转一半的单链表 用两个半截单链表比较 空间为o(1) 时间为o(n)
    // 假设1-2-3-2-1  奇数个时  链表1为:2-1 链表2为:3-2-1 奇数的时候 链表2特殊处理为 从第二个元素开始遍历
    // 假设1-2-2-1 偶数个时，链表1为:2-1 链表2为:2-1，直接比较
    // 反转多少个长度的链表呢？ 5/2 = 2  4/2 = 2  可知链表长度/2 不论对于奇数还是偶数都比较好
    public boolean isPalindrome_2(ListNode head) {
        // 第一次循环 算出来链表长度
        int length = 0;
        for(ListNode temp = head; temp != null; temp = temp.next)
            length++;
        // 反转length/2个数的链表 反转链表的核心就是当前指针+前驱指针
        ListNode current = head, pre = null;
        for(int i=0; i<length/2; i++){ // 控制长度 反转多少个
            ListNode tempNext = current.next;
            current.next = pre;
            pre = current;
            current = tempNext;
        }
        // 这样反转出来之后 对于 1-2-3-2-1链表来说
        // pre链表为：2-1 current链表为 3-2-1
        if(length % 2 != 0) current = current.next;
        // 依次比较两个指针指向的数值就OK
        while (pre != null && current != null){
            if(pre.val != current.val) return false;
            pre = pre.next;
            current = current.next;
        }
        return true;
    }
}


````









