package com.alenbeyond.runoob.greendao.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.alenbeyond.runoob.greendao.bean.RunoobCategory;
import com.alenbeyond.runoob.greendao.bean.RunoobChapter;
import com.alenbeyond.runoob.greendao.bean.RunoobItem;
import com.alenbeyond.runoob.resource.rxjava.bean.AllOperators;

import com.alenbeyond.runoob.greendao.gen.RunoobCategoryDao;
import com.alenbeyond.runoob.greendao.gen.RunoobChapterDao;
import com.alenbeyond.runoob.greendao.gen.RunoobItemDao;
import com.alenbeyond.runoob.greendao.gen.AllOperatorsDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig runoobCategoryDaoConfig;
    private final DaoConfig runoobChapterDaoConfig;
    private final DaoConfig runoobItemDaoConfig;
    private final DaoConfig allOperatorsDaoConfig;

    private final RunoobCategoryDao runoobCategoryDao;
    private final RunoobChapterDao runoobChapterDao;
    private final RunoobItemDao runoobItemDao;
    private final AllOperatorsDao allOperatorsDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        runoobCategoryDaoConfig = daoConfigMap.get(RunoobCategoryDao.class).clone();
        runoobCategoryDaoConfig.initIdentityScope(type);

        runoobChapterDaoConfig = daoConfigMap.get(RunoobChapterDao.class).clone();
        runoobChapterDaoConfig.initIdentityScope(type);

        runoobItemDaoConfig = daoConfigMap.get(RunoobItemDao.class).clone();
        runoobItemDaoConfig.initIdentityScope(type);

        allOperatorsDaoConfig = daoConfigMap.get(AllOperatorsDao.class).clone();
        allOperatorsDaoConfig.initIdentityScope(type);

        runoobCategoryDao = new RunoobCategoryDao(runoobCategoryDaoConfig, this);
        runoobChapterDao = new RunoobChapterDao(runoobChapterDaoConfig, this);
        runoobItemDao = new RunoobItemDao(runoobItemDaoConfig, this);
        allOperatorsDao = new AllOperatorsDao(allOperatorsDaoConfig, this);

        registerDao(RunoobCategory.class, runoobCategoryDao);
        registerDao(RunoobChapter.class, runoobChapterDao);
        registerDao(RunoobItem.class, runoobItemDao);
        registerDao(AllOperators.class, allOperatorsDao);
    }
    
    public void clear() {
        runoobCategoryDaoConfig.getIdentityScope().clear();
        runoobChapterDaoConfig.getIdentityScope().clear();
        runoobItemDaoConfig.getIdentityScope().clear();
        allOperatorsDaoConfig.getIdentityScope().clear();
    }

    public RunoobCategoryDao getRunoobCategoryDao() {
        return runoobCategoryDao;
    }

    public RunoobChapterDao getRunoobChapterDao() {
        return runoobChapterDao;
    }

    public RunoobItemDao getRunoobItemDao() {
        return runoobItemDao;
    }

    public AllOperatorsDao getAllOperatorsDao() {
        return allOperatorsDao;
    }

}
