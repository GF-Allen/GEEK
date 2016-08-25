package com.alenbeyond.runoob.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.alenbeyond.runoob.resource.rxjava.bean.AllOperators;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ALL_OPERATORS".
*/
public class AllOperatorsDao extends AbstractDao<AllOperators, Long> {

    public static final String TABLENAME = "ALL_OPERATORS";

    /**
     * Properties of entity AllOperators.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Thread = new Property(2, String.class, "thread", false, "THREAD");
        public final static Property Desc = new Property(3, String.class, "desc", false, "DESC");
        public final static Property Img = new Property(4, String.class, "img", false, "IMG");
        public final static Property Url = new Property(5, String.class, "url", false, "URL");
        public final static Property Operators_id = new Property(6, Long.class, "operators_id", false, "OPERATORS_ID");
    };


    public AllOperatorsDao(DaoConfig config) {
        super(config);
    }
    
    public AllOperatorsDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ALL_OPERATORS\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"THREAD\" TEXT," + // 2: thread
                "\"DESC\" TEXT," + // 3: desc
                "\"IMG\" TEXT," + // 4: img
                "\"URL\" TEXT," + // 5: url
                "\"OPERATORS_ID\" INTEGER);"); // 6: operators_id
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ALL_OPERATORS\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, AllOperators entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String thread = entity.getThread();
        if (thread != null) {
            stmt.bindString(3, thread);
        }
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(4, desc);
        }
 
        String img = entity.getImg();
        if (img != null) {
            stmt.bindString(5, img);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(6, url);
        }
 
        Long operators_id = entity.getOperators_id();
        if (operators_id != null) {
            stmt.bindLong(7, operators_id);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, AllOperators entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String thread = entity.getThread();
        if (thread != null) {
            stmt.bindString(3, thread);
        }
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(4, desc);
        }
 
        String img = entity.getImg();
        if (img != null) {
            stmt.bindString(5, img);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(6, url);
        }
 
        Long operators_id = entity.getOperators_id();
        if (operators_id != null) {
            stmt.bindLong(7, operators_id);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public AllOperators readEntity(Cursor cursor, int offset) {
        AllOperators entity = new AllOperators( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // thread
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // desc
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // img
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // url
            cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6) // operators_id
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, AllOperators entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setThread(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDesc(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setImg(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setUrl(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setOperators_id(cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(AllOperators entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(AllOperators entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}