package com.study.fashionapp.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.file.Files;

@RestController
@RequiredArgsConstructor
public class ImageController {
    @Autowired
    String clientImagePath;

    @GetMapping(value = "/images/{imageName}.{extension}",produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[] getImage(@PathVariable(name = "imageName") String imageName, @PathVariable(name="extension") String extension) throws IOException {
        String path=clientImagePath+"/"+imageName+"."+extension;
        File file=new File(path);
        return Files.readAllBytes(file.toPath());
    }
}
