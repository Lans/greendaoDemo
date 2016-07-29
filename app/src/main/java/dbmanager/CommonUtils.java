package dbmanager;

import android.content.Context;
import android.util.Log;

import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;
import me.slq.greendao.Note;
import me.slq.greendao.NoteDao;

/**
 * 完成对某一张表的具体操作,ORM 操作的是对象，StudentStudent
 * Created by luoliwen on 16/4/16.
 */
public class CommonUtils {
    private DaoManager manager;
    private static final String TAG = "CommonUtils";

    public CommonUtils(Context context) {
        manager = DaoManager.getInstance();
        manager.init(context);
    }

    /**
     * 完成对数据库中studentstudent 表的插入操作
     *
     * @param
     * @return
     */
    public boolean insertNote(Note note) {
        boolean flag = false;

        flag = manager.getDaoSession().insert(note) != -1 ? true : false;
        Log.i("CommonUtils", "----insertStudentStudent--result is -->>" + flag);
        return flag;
    }

    /**
     * 插入多条记录，需要开辟新的线程
     *
     * @param
     * @return
     */
    public boolean insertMultNote(final List<Note> notes) {
        boolean flag = false;

        try {
            manager.getDaoSession().runInTx(new Runnable() {
                @Override
                public void run() {
                    for (Note note : notes) {
                        manager.getDaoSession().insertOrReplace(note);
                    }
                }
            });
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对studentstudent的某一条记录的修改
     *
     * @param
     * @return
     */
    public boolean updateNote(Note note) {
        boolean flag = false;
        try {
            manager.getDaoSession().update(note);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return flag;
    }

    public boolean deleteNote(Note note) {
        boolean flag = false;
        try {
            manager.getDaoSession().delete(note);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public List<Note> selectNote() {
        QueryBuilder<Note> builder = manager.getDaoSession().queryBuilder(Note.class);
        List<Note> list = builder.where(NoteDao.Properties.Id.gt(7)).list();

        Log.e(TAG, list + "");
        return list;
    }
}
