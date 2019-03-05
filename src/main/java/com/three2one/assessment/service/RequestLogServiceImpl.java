package com.three2one.assessment.service;

import com.three2one.assessment.model.RequestLog;
import com.three2one.assessment.repository.RequestLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestLogServiceImpl implements RequestLogService {

    @Autowired
    RequestLogRepository requestLogRepository;


    @Override
    public RequestLog save(RequestLog requestLog) throws Exception {
        return requestLogRepository.save(requestLog);
    }
}
