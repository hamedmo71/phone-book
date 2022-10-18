package ir.maktab74.phonebook.base.repository;

 import ir.maktab74.phonebook.base.domain.BaseEntity;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseEntityRepository<E extends BaseEntity<ID>, ID extends Serializable>
        extends JpaRepository<E, ID>, JpaSpecificationExecutor<E> {
}
