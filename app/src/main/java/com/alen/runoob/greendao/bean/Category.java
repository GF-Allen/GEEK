package com.alen.runoob.greendao.bean;

import com.alen.runoob.greendao.gen.CategoryDao;
import com.alen.runoob.greendao.gen.DaoSession;
import com.alen.runoob.greendao.gen.ItemDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

/**
 * 获取分类
 * Created by Jeff on 2016/5/23.
 */
@Entity
public class Category {
    @Id
    private Long id;

    private String title;
    @ToMany(referencedJoinProperty = "categroyId")
    private List<Item> item;

    /** Used for active entity operations. */
    @Generated(hash = 40161530)
    private transient CategoryDao myDao;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    public Category(String title, List<Item> item) {
        super();
        this.title = title;
        this.item = item;
    }

    @Generated(hash = 206903207)
    public Category(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    @Generated(hash = 1150634039)
    public Category() {
    }

    @Override
    public String toString() {
        return "Category [title=" + title + ", item=" + item + "]";
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
    @Generated(hash = 488856272)
    public synchronized void resetItem() {
        item = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 784641744)
    public List<Item> getItem() {
        if (item == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ItemDao targetDao = daoSession.getItemDao();
            List<Item> itemNew = targetDao._queryCategory_Item(id);
            synchronized (this) {
                if(item == null) {
                    item = itemNew;
                }
            }
        }
        return item;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 503476761)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCategoryDao() : null;
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
