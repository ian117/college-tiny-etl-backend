package datawarehouse.wareouse.repo.db3;

import datawarehouse.wareouse.entity.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShoesRepo3 extends JpaRepository<Shoes, Long>,JpaSpecificationExecutor<Shoes> {
}