package com.sales.dao.jpa;

import com.sales.model.Sales;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesJPARepository extends CrudRepository<Sales, Long> {

}
