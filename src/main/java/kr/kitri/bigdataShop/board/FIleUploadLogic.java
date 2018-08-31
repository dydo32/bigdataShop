package kr.kitri.bigdataShop.board;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FIleUploadLogic {
	FileOutputStream fos;

	public void upload(MultipartFile[] file, String path, ArrayList<String> fileName) {
		System.out.println("upload:"+path+","+fileName);
		try {
			for (int i = 0; i < fileName.size(); i++) {
				byte[] data = file[i].getBytes();
				fos = new FileOutputStream(path + File.separator + fileName.get(i));
				fos.write(data);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
