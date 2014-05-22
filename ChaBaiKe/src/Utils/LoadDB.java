package Utils;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.database.OperateDataBase;
import com.example.database.TeaProviderMetaData.TableMaindataMetaData;
import com.example.database.TeaProviderMetaData.TableViewPagerMetaData;
import com.example.entity.Entity;
import com.example.entity.TouTiaoLVEntity;
import com.example.entity.TouTiaoVPEntity;

public class LoadDB {
	private static final String TAG = "DownLoadDB";

	/**
	 * ��������ListView�͵��ListViewItem�������
	 * 
	 * @param mContext
	 * @param dbName
	 * @param category
	 * @param iDownLoadDB
	 */
	public static ArrayList<? extends Entity> LoadingDBs(Context mContext,
			String dbName, String category) {
		Cursor cursor = null;
		Log.d(TAG, "category: " + category);

		if (category != null) {
			// ��maindata���
			cursor = OperateDataBase.getInstance(mContext).query(dbName, null,
					TableMaindataMetaData.CATEGORY + " = ?",
					new String[] { category }, null);
		} else {
			// Ϊcollect��viewPager���
			cursor = OperateDataBase.getInstance(mContext).query(dbName, null,
					null, null, null);
		}

		if (cursor != null && !isEmpty(cursor)) {
			// new ArrayList<>����������ݣ��ɿͻ��˻ص�
			return createEntity(cursor, category);
		}
		Log.d(TAG, dbName + "���ݿ�Ϊ��");
		return null;
	}

	/**
	 * ��������ViewPager������
	 * 
	 * @param mContext
	 * @param dbName
	 * @param iDownLoadDB
	 */
	public static ArrayList<? extends Entity> LoadingDB(Context mContext,
			String dbName) {
		return LoadingDBs(mContext, dbName, null);
	}

	/**
	 * �����ж����ݿ��Ƿ��Ѵ���������ݣ�������Ϊlist_item�Ĳ�ѯ��Ч
	 * 
	 * @param mContext
	 * @param table
	 * @param id
	 * @return true���ڣ�false������
	 */
	public static boolean inDataBase(Context mContext, String table, String id) {
		return inLIDataBase(mContext, table, id, false);
	}

	/**
	 * �����ж����ݿ��Ƿ��Ѵ���������ݣ��ɲ�ѯ����Ϊlist_item����
	 * 
	 * @param mContext
	 * @param table
	 * @param id
	 * @param isListItem
	 *            �Ƿ����ڲ�ѯListItem����
	 * @return true���ڣ�false������
	 */
	public static boolean inLIDataBase(Context mContext, String table,
			String id, boolean isListItem) {
		Cursor cursor = null;
		if (isListItem) {
			cursor = OperateDataBase.getInstance(mContext)
					.query(table,
							null,
							"id = ? and category = ?",
							new String[] { id,
									TableMaindataMetaData.CATEGORY_LIST_ITEM },
							null);
		} else {
			cursor = OperateDataBase.getInstance(mContext).query(table, null,
					"id = ?", new String[] { id }, null);

		}
		if (isEmpty(cursor)) {
			return false;
		}
		return true;

	}

	/**
	 * ����cursor��category�����б����
	 * 
	 * @param cursor
	 * @param category
	 * @return �������ݿ�����ʵ������С�����Ϊnull
	 */
	public static ArrayList<? extends Entity> createEntity(Cursor cursor,
			String category) {

		if (category != null) {
			ArrayList<TouTiaoLVEntity> datas = new ArrayList<TouTiaoLVEntity>();
			while (cursor.moveToNext()) {
				datas.add(createLVEntity(cursor));
			}
			datas.trimToSize();
			return datas;

		} else {
			Log.d(TAG, "��ȡviewpager���");
			ArrayList<TouTiaoVPEntity> datas = new ArrayList<TouTiaoVPEntity>();
			while (cursor.moveToNext()) {
				datas.add(createVPEntity(cursor));
			}
			datas.trimToSize();
			return datas;

		}

	}

	public static TouTiaoLVEntity createLVEntity(Cursor cursor) {
		String id = LoadDB.getString(cursor, TableMaindataMetaData.ID);
		String title = LoadDB.getString(cursor, TableMaindataMetaData.TITLE);
		String source = LoadDB.getString(cursor, TableMaindataMetaData.SOURCE);
		String description = LoadDB.getString(cursor,
				TableMaindataMetaData.DESCRIPTION);
		String wapThumb = LoadDB.getString(cursor,
				TableMaindataMetaData.WAP_THUMB);
		String createTime = LoadDB.getString(cursor,
				TableMaindataMetaData.CREATE_TIME);
		String nickName = LoadDB.getString(cursor,
				TableMaindataMetaData.NICK_NAME);
		return new TouTiaoLVEntity(id, title, source, description, wapThumb,
				createTime, nickName);

	}

	public static TouTiaoVPEntity createVPEntity(Cursor cursor) {
		String id = getString(cursor, TableViewPagerMetaData.ID);
		String title = getString(cursor, TableViewPagerMetaData.TITLE);
		String name = getString(cursor, TableViewPagerMetaData.NAME);
		String link = getString(cursor, TableViewPagerMetaData.LINK);
		String content = getString(cursor, TableViewPagerMetaData.CONTENT);
		String image = getString(cursor, TableViewPagerMetaData.IMAGE);
		String imageS = getString(cursor, TableViewPagerMetaData.IMAGE_S);
		return new TouTiaoVPEntity(id, title, name, link, content, image,
				imageS);
	}

	/**
	 * 
	 * @param cursor
	 * @return cursor�������ݷ���true,�����ݷ���false;
	 */
	public static boolean isEmpty(Cursor cursor) {
		Log.d(TAG, "cursor count: " + cursor.getCount());

		if (cursor.getCount() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * ��cursorָ����������У���ȡ����ΪcolumnName���ַ���ֵ
	 * 
	 * @param cursor
	 * @param columnName
	 * @return �ַ���ֵ
	 */
	public static String getString(Cursor cursor, String columnName) {
		return cursor.getString(cursor.getColumnIndex(columnName));
	}
}
