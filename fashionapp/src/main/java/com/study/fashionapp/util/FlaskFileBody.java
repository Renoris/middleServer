package com.study.fashionapp.util;

import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.util.Args;

import java.io.File;

public class FlaskFileBody extends FileBody {

    public FlaskFileBody(File file) {
        super(file);
    }
//
//    public FlaskFileBody(final File file, final ContentType contentType, final String filename) {
//        super(contentType);
//        Args.notNull(file, "File");
//        this.file = file;
//        this.filename = filename;
//    }


    public FlaskFileBody(File file, ContentType contentType) {
        super(file, contentType);
    }

}
