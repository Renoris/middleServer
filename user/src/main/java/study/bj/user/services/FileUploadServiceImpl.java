package study.bj.user.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class FileUploadServiceImpl implements FileUploadService{

    @Override
    public void FileUpload(String path, File file) {

    }

    @Override
    public void MultipartFileUpload(String path, MultipartFile file) throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream(new File(path+file.getOriginalFilename()));
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(file.getBytes());
        bufferedOutputStream.close();

    }
}
