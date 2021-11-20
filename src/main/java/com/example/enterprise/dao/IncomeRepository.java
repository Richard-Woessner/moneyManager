package com.example.enterprise.dao;

import com.example.enterprise.dto.Income;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

@Profile("!test")
public interface IncomeRepository extends CrudRepository<Income, Integer>, JpaSpecificationExecutor<Income> {


}
