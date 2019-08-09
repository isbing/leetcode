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
public class LeetCode82Test {

	public ListNode deleteDuplicates(ListNode head) {
		ListNode temp = new ListNode(-1);
		temp.next = head;

		// 定义两个前后指针
		ListNode p = temp;
		ListNode q = p.next;
		while (q != null){
			// 首先循环查找是否有相同的元素
			while (q.next != null && q.val == q.next.val) q = q.next;
			// 只要不相等，就说明跑了。此时就不会相等
			if(p.next != q){
				// 需要删除
				p.next = q.next;
				q = q.next;
			}else{
				// 不用删除 两个一起移动
				p = q;
				q = q.next;
			}
		}
		return temp.next;
	}
}
