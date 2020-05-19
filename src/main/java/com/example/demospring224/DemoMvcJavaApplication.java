/*
 * <p>文件名称: DemoMvcJavaApplication.java</p>
 * <p>项目描述: KOCA 金证云原生平台 v1.3.0</p>
 * <p>公司名称: 深圳市金证科技股份有限公司</p>
 * <p>版权所有: (C) 2019-2020</p>
 */

package com.example.demospring224;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RestController
public class DemoMvcJavaApplication {

    static public AtomicLong count = new AtomicLong();

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("hey you are %s haha!", name);
	}

	@GetMapping("/")
	public String welcome() {
		return String.format("hey welcome you");
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoMvcJavaApplication.class, args);

		while (true) {
			System.out.println("hey test springMVC app with simple java: " + count.incrementAndGet());
			try {
				Thread.sleep(1000*1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
