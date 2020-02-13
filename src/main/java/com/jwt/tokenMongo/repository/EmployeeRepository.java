package com.jwt.tokenMongo.repository;

import com.jwt.tokenMongo.model.Employee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, ObjectId> {
    void deleteByEmpId(String empID);
}
