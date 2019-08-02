package com.isbing.leetcode.coding;

import com.isbing.leetcode.bean.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by song bing
 * Created time 2019/6/27 17:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
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
