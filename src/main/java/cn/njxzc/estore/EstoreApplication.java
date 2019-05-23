package cn.njxzc.estore;

import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

@SpringBootApplication
@MapperScan(value = "cn.njxzc.estore.dao")
public class EstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstoreApplication.class, args);
	}
	
	// 文件上传配置
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		DataSize size = DataSize.ofMegabytes(10);
		factory.setMaxFileSize(size);
		factory.setMaxRequestSize(size);
		return factory.createMultipartConfig();
	}

}
