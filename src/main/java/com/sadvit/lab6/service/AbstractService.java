package com.sadvit.lab6.service;

import com.sadvit.lab6.dao.DAO;
import com.sadvit.lab6.dao.DAOProxy;
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