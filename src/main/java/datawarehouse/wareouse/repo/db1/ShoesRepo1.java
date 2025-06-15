package datawarehouse.wareouse.repo.db1;

import datawarehouse.wareouse.entity.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShoesRepo1 extends JpaRepository<Shoes, Long>, JpaSpecificationExecutor<Shoes> {
}