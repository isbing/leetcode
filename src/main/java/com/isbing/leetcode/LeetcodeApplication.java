package com.isbing.leetcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class LeetcodeApplication {

	static volatile boolean SAVE_IP_LOCK = false;


	public static void main(String[] args) {
		//consumeSipderQueue();
		SpringApplication.run(LeetcodeApplication.class, args);
	}

	private static void consumeSipderQueue() {
		new Thread(() -> {
			while (true) {
				if (SAVE_IP_LOCK) {
					return;
				}
				SAVE_IP_LOCK = true;
				try {
					System.out.println("do...");
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					SAVE_IP_LOCK = false;
				}
			}
		}).start();
	}


}
