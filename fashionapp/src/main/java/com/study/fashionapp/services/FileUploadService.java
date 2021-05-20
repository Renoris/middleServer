package com.study.fashionapp.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface FileUploadService {
    public void FileUpload(String path, File file);
    public void MultipartFileUpload(MultipartFile file) throws IOException;
}
