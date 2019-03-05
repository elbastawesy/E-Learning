package com.three2one.assessment.repository;

import com.three2one.assessment.model.RequestLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestLogRepository extends CrudRepository<RequestLog, Long> {

}
