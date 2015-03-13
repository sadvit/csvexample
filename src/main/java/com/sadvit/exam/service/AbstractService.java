package com.sadvit.exam.service;

import com.sadvit.exam.dao.DAO;
import com.sadvit.exam.dao.DAOProxy;
import org.springframework.stereotype.Service;

@Service
public abstract class AbstractService<T extends Storeable> {

    private DAO<T> daoProxy;

    public AbstractService(DAO<T> daoBasic) {
        this.daoProxy = new DAOProxy<>(daoBasic);
    }

    protected DAO<T> getDaoProxy() {
        return daoProxy;
    }

}