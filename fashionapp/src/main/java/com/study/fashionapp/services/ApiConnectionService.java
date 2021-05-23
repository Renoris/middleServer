package com.study.fashionapp.services;

import java.util.Map;

public interface ApiConnectionService {
    public void changePath(String path);
    public ApiConnectionServiceImpl addParam(Map<String, Object> param);
    public String submit();
}
