package com.alen.runoob.greendao.bean;

import com.alen.runoob.greendao.gen.DaoSession;
import com.alen.runoob.greendao.gen.RunoobCategoryDao;
import com.alen.runoob.greendao.gen.RunoobItemDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

/**
 * 获取分类
 * Created by AlenBeyond on 2016/5/23.
 */
@Entity
public class RunoobCategory {
    @Id
    private Long id;

    private String title;
    @ToMany(referencedJoinProperty = "categroyId")
    private List<RunoobItem> runoobItem;

    /** Used for active entity operations. */
    @Generated(hash = 1185788285)
    private transient RunoobCategoryDao myDao;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    @Generated(hash = 170471397)
    public RunoobCategory(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public RunoobCategory(String title, List<RunoobItem> runoobItem) {
        this.title = title;
        this.runoobItem = runoobItem;
    }

    @Generated(hash = 839713230)
    public RunoobCategory() {
    }

    @Override
    public String toString() {
        return "RunoobCategory [title=" + title + ", runoobItem=" + runoobItem + "]";
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 891056255)
    public synchronized void resetRunoobItem() {
        runoobItem = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1549947286)
    public List<RunoobItem> getRunoobItem() {
        if (runoobItem == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            RunoobItemDao targetDao = daoSession.getRunoobItemDao();
            List<RunoobItem> runoobItemNew = targetDao._queryRunoobCategory_RunoobItem(id);
            synchronized (this) {
                if(runoobItem == null) {
                    runoobItem = runoobItemNew;
                }
            }
        }
        return runoobItem;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 482658309)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getRunoobCategoryDao() : null;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
