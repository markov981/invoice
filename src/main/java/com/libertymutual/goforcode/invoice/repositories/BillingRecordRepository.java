package com.libertymutual.goforcode.invoice.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libertymutual.goforcode.invoice.models.BillingRecord;
import com.libertymutual.goforcode.invoice.models.User;


@Repository
public interface BillingRecordRepository extends JpaRepository<BillingRecord, Long>{

}
