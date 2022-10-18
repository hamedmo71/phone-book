package ir.maktab74.phonebook.base.service.impl;

import ir.maktab74.phonebook.base.domain.BaseEntity;
import ir.maktab74.phonebook.base.repository.BaseEntityRepository;
import ir.maktab74.phonebook.base.service.BaseEntityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public class BaseEntityServiceImpl<E extends BaseEntity<ID>, ID extends Serializable,
        R extends BaseEntityRepository<E, ID>>
        implements BaseEntityService<E, ID> {

    protected final R repository;

    public BaseEntityServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public E save(E e) {
        return repository.save(e);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public Optional<E> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public Page<E> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }
}
