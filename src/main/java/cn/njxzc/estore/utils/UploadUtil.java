package cn.njxzc.estore.utils;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadUtil {

	private static final String FILE_ADDRESS = "/home/ansel/nginx/mall/img/goods/";
	
	private static final String TEMP_FILE = "/mall/img/goods/";

	public static synchronized String savePic(long isbn, MultipartFile file, int flag) {
		Path dirPath = null;
		try {
			String fileName = "";
			if (flag == 0) {
				fileName = "collect.jpg";
			} else if (flag == 2) {
				fileName = "detail.jpg";
			} else {
				long random = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
				fileName = "small_" + random + ".jpg";
			}
			byte[] bytes = file.getBytes();
			// 目录不存在就创建
			dirPath = Paths.get(FILE_ADDRESS, String.valueOf(isbn));
			if (!Files.exists(dirPath)) {
				Files.createDirectory(dirPath);
			}
			Path filePath = Paths.get(FILE_ADDRESS, String.valueOf(isbn), fileName);
			Files.write(filePath, bytes);
			return Paths.get(TEMP_FILE, String.valueOf(isbn), fileName).toString();
		} catch (FileAlreadyExistsException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println("目录已存在");
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println("文件写入失败");
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "";
	}

}
