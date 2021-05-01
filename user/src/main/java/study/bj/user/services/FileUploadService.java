package study.bj.user.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileUploadService {
    public void FileUpload(String path, File file);
    public void MultipartFileUpload(String path, MultipartFile file) throws IOException;
}
