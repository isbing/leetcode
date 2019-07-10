package com.isbing.leetcode.coding;

import com.isbing.leetcode.bean.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * Created by song bing
 * Created time 2019/6/27 17:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
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
