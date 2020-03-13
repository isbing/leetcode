package com.isbing.leetcode.coding;

import com.isbing.leetcode.bean.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by song bing
 * Created time 2020/3/13 14:26
 */
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
