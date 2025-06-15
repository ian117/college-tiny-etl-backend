package datawarehouse.wareouse.repo.db2;

import datawarehouse.wareouse.entity.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShoesRepo2 extends JpaRepository<Shoes, Long>,JpaSpecificationExecutor<Shoes> {
}