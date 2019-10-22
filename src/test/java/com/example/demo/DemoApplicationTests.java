package com.example.demo;

import com.example.entity.Sender;
import com.example.task.Task;
import com.example.test.TestUser;
import com.example.test.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private Sender sender;

	@Autowired
	private User user;

	@Autowired
	private TestUser testUser;

	@Autowired
	private Task task;

	@Test
	public void hello() throws  Exception{
//		task.doTaskOne();
//		task.doTaskTwo();
//		task.doTaskThree();
		long start = System.currentTimeMillis();
		Future<String> task1 = task.doTaskOne();
		Future<String> task2 = task.doTaskTwo();
		Future<String> task3 = task.doTaskThree();
//		while(true) {
//			if(task1.isDone() && task2.isDone() && task3.isDone()) {
//				System.out.println(task1.get());
//			// 三个任务都调用完成，退出循环等待
////				break;
//			}
		Thread.sleep(999);
		if(task1.isDone()) {
			System.out.println(task1.get());
		}else
			System.out.println("task 1 not end");
//		}
		long end = System.currentTimeMillis();
		System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
	}

}
