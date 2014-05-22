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
	 * 用于下载ListView和点击ListViewItem后的数据
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
			// 是maindata表格
			cursor = OperateDataBase.getInstance(mContext).query(dbName, null,
					TableMaindataMetaData.CATEGORY + " = ?",
					new String[] { category }, null);
		} else {
			// 为collect或viewPager表格
			cursor = OperateDataBase.getInstance(mContext).query(dbName, null,
					null, null, null);
		}

		if (cursor != null && !isEmpty(cursor)) {
			// new ArrayList<>用于填充数据，由客户端回调
			return createEntity(cursor, category);
		}
		Log.d(TAG, dbName + "数据库为空");
		return null;
	}

	/**
	 * 用于下载ViewPager的数据
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
	 * 用于判断数据库是否已存在这个数据，对类型为list_item的查询无效
	 * 
	 * @param mContext
	 * @param table
	 * @param id
	 * @return true存在，false不存在
	 */
	public static boolean inDataBase(Context mContext, String table, String id) {
		return inLIDataBase(mContext, table, id, false);
	}

	/**
	 * 用于判断数据库是否已存在这个数据，可查询类型为list_item的行
	 * 
	 * @param mContext
	 * @param table
	 * @param id
	 * @param isListItem
	 *            是否用于查询ListItem类型
	 * @return true存在，false不存在
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
	 * 根据cursor，category生成列表对象
	 * 
	 * @param cursor
	 * @param category
	 * @return 返回数据库生成实体的数列。或者为null
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
			Log.d(TAG, "读取viewpager表格");
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
	 * @return cursor中无数据返回true,有数据返回false;
	 */
	public static boolean isEmpty(Cursor cursor) {
		Log.d(TAG, "cursor count: " + cursor.getCount());

		if (cursor.getCount() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 从cursor指向对数据项中，读取列名为columnName的字符串值
	 * 
	 * @param cursor
	 * @param columnName
	 * @return 字符串值
	 */
	public static String getString(Cursor cursor, String columnName) {
		return cursor.getString(cursor.getColumnIndex(columnName));
	}
}
