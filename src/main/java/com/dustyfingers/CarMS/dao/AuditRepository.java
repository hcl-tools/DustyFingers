package com.dustyfingers.CarMS.dao;

import com.dustyfingers.CarMS.model.Audit;
import org.springframework.data.repository.CrudRepository;

public interface AuditRepository extends CrudRepository<Audit, Integer> {

}
