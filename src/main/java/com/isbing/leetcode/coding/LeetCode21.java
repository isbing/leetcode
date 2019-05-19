package com.isbing.leetcode.coding;

import com.isbing.leetcode.LeetCoding;
import com.isbing.leetcode.bean.ListNode;

/**
 * Created by songbing
 * Created time 2019/5/18 上午10:51
 */
public abstract class LeetCode21 extends LeetCoding{

    // 思路：new一个新的List。哪个节点小，这个listNode就挂去哪个小节点。
    // Time: O(m+n), Space: O(1)   时间复杂度 就是 最长的那个链表

    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     示例：
     输入：1->2->4, 1->3->4
     输出：1->1->2->3->4->4
     不能创建新节点
     */
    @Override
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // newList是新的节点。最后返回 是返回的 newList.next
        ListNode newList = new ListNode(-1);
        // 每次移动要用副本去移动 不能破坏原始头指向
        ListNode p = newList;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                // 谁小 就由新的链表去指向这个节点
                ListNode temp = l1.next;
                p.next = l1;
                l1 = temp;
                p = p.next;//p要重新指向 方便链接下一个节点
            }else{
                ListNode temp = l2.next;
                p.next = l2;
                l2 = temp;
                p = p.next;//p要重新指向 方便链接下一个节点
            }
        }
        // 谁有多的 就直接 链接过来。因为两个链表 都是 有序的
        if (l1 != null)
            p.next = l1;
        if (l2 != null)
            p.next = l2;
        return newList.next;
    }
}
