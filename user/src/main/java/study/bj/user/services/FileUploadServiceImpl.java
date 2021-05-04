package study.bj.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class FileUploadServiceImpl implements FileUploadService{

    @Autowired
    String clientImagePath;

    @Override
    public void FileUpload(String path, File file) {

    }

    @Override
    public void MultipartFileUpload(MultipartFile file) throws IOException {
        File root=new File(clientImagePath);
        if(!root.exists()){
            root.mkdirs();
        }
        FileOutputStream fileOutputStream=new FileOutputStream(root+"/"+file.getOriginalFilename());
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(file.getBytes());
        bufferedOutputStream.close();

    }
}
