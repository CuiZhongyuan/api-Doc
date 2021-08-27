package com.taltools.service;

import org.springframework.stereotype.Service;

@Service
public interface AppraiseResultService {
    String getAll(String wo_number);

    String appraiseLog(String reqJson);
}
