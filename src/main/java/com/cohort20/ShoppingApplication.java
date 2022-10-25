package com.cohort20;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);
	}

}



//<div>
//<label for="exampleInputEmail1">Top up account balance</label> <input type="number"
//	class="form-control"
//	 placeholder="Top-up account balance" name="accountBalance">
//</div>
//#spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
//#spring.datasource.url=jdbc:mysql://localhost:3306/assessment2/springBootSession?createDatabaseIfNotExist=true&useSSL=false
//#spring.datasource.username=root
//#spring.datasource.password=admin123
//#
//#spring.session.store-type=jdbc
//#spring.session.jdbc.initialize-schema=always
//#spring.session.timeout.seconds=600
//#spring.h2.console.enabled=true