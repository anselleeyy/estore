package cn.njxzc.estore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "cn.njxzc.estore.dao")
public class EstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstoreApplication.class, args);
	}

}
