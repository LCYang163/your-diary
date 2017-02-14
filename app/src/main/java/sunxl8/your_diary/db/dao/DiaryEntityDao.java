package sunxl8.your_diary.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import sunxl8.your_diary.db.entity.DiaryEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DIARY_ENTITY".
*/
public class DiaryEntityDao extends AbstractDao<DiaryEntity, Long> {

    public static final String TABLENAME = "DIARY_ENTITY";

    /**
     * Properties of entity DiaryEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Title = new Property(1, String.class, "Title", false, "TITLE");
        public final static Property Content = new Property(2, String.class, "content", false, "CONTENT");
        public final static Property Weather = new Property(3, int.class, "weather", false, "WEATHER");
        public final static Property Mood = new Property(4, int.class, "mood", false, "MOOD");
        public final static Property Date = new Property(5, java.util.Date.class, "date", false, "DATE");
        public final static Property ShowDate = new Property(6, boolean.class, "showDate", false, "SHOW_DATE");
    }


    public DiaryEntityDao(DaoConfig config) {
        super(config);
    }
    
    public DiaryEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DIARY_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"TITLE\" TEXT," + // 1: Title
                "\"CONTENT\" TEXT," + // 2: content
                "\"WEATHER\" INTEGER NOT NULL ," + // 3: weather
                "\"MOOD\" INTEGER NOT NULL ," + // 4: mood
                "\"DATE\" INTEGER," + // 5: date
                "\"SHOW_DATE\" INTEGER NOT NULL );"); // 6: showDate
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DIARY_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DiaryEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String Title = entity.getTitle();
        if (Title != null) {
            stmt.bindString(2, Title);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(3, content);
        }
        stmt.bindLong(4, entity.getWeather());
        stmt.bindLong(5, entity.getMood());
 
        java.util.Date date = entity.getDate();
        if (date != null) {
            stmt.bindLong(6, date.getTime());
        }
        stmt.bindLong(7, entity.getShowDate() ? 1L: 0L);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DiaryEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String Title = entity.getTitle();
        if (Title != null) {
            stmt.bindString(2, Title);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(3, content);
        }
        stmt.bindLong(4, entity.getWeather());
        stmt.bindLong(5, entity.getMood());
 
        java.util.Date date = entity.getDate();
        if (date != null) {
            stmt.bindLong(6, date.getTime());
        }
        stmt.bindLong(7, entity.getShowDate() ? 1L: 0L);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DiaryEntity readEntity(Cursor cursor, int offset) {
        DiaryEntity entity = new DiaryEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // Title
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // content
            cursor.getInt(offset + 3), // weather
            cursor.getInt(offset + 4), // mood
            cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)), // date
            cursor.getShort(offset + 6) != 0 // showDate
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DiaryEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTitle(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setContent(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setWeather(cursor.getInt(offset + 3));
        entity.setMood(cursor.getInt(offset + 4));
        entity.setDate(cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)));
        entity.setShowDate(cursor.getShort(offset + 6) != 0);
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DiaryEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DiaryEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DiaryEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
