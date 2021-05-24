package com.study.fashionapp.services;

import com.study.fashionapp.services.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class FileUploadServiceImpl implements FileUploadService {


    @Override
    public void FileUpload(String path, File file) {

    }

    @Override
    public void MultipartFileUpload(MultipartFile file, String clientImagePath) throws IOException {
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
