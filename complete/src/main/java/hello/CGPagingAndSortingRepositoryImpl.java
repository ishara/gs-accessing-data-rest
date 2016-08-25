package hello;
/*
 * Copyright (c) 2016. CodeGen Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Created by ishara on 8/24/2016 11:30 AM
 */

import org.hibernate.annotations.FetchMode;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.Field;

import static org.springframework.data.jpa.repository.query.QueryUtils.toOrders;

public class CGPagingAndSortingRepositoryImpl<T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID> implements CGPagingAndSortingRepository<T, ID>
{
    private EntityManager entityManager;

    public CGPagingAndSortingRepositoryImpl( JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager )
    {
        super( entityInformation, entityManager );
        this.entityManager = entityManager;
    }


//    @Override public String test()
//    {
//        return null;
//    }
}
