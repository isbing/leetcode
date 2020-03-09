package com.isbing.leetcode.coding;

import com.isbing.leetcode.bean.ListNode;

/**
 * Created by songbing
 * Created time 2020/3/9 下午3:41
 */
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
