package Utils;

public class UriPath {
	// ��������·��
	public static final String BASE_URL = "http://sns.maimaicha.com/api?apikey=b4f4ee31a8b9acc866ef2afb754c33e6&format=json&method=news.getListByType";
	// ��ȡ����apk�汾·��
	public static final String UPAPKPATH = "http://baike.maimaicha.com/getversion.ashx";
	// ��ҳ����·��
	public static final String HOMEPATH = "http://sns.maimaicha.com/api?apikey=b4f4ee31a8b9acc866ef2afb754c33e6&format=json&method=news.getSlideshow";
	// ͷ������·��
	public static final String TOU_TIAO = "http://sns.maimaicha.com/api?apikey=b4f4ee31a8b9acc866ef2afb754c33e6&format=json&method=news.getHeadlines";
	// ������ҳ
	public static final String NEWCONTENTPATH = "http://sns.maimaicha.com/api?apikey=b4f4ee31a8b9acc866ef2afb754c33e6&format=json&method=news.getNewsContent";
	// �ٿ� post�� rows=15&page=0&type=16
	public static final String BAI_KE = BASE_URL + "&type=16";
	// ���� post�� rows=10&page=1&search=tea
	public static final String SOU_SU = "http://sns.maimaicha.com/api?apikey=b4f4ee31a8b9acc866ef2afb754c33e6&format=json&method=news.searcListByTitle";
	// ��Ѷ post��rows=15&page=0&type=52
	public static final String ZI_XUN = BASE_URL + "&type=52";
	// ��Ӫ�ӿڣ�ͬ�� post��rows=15&page=0&type=53
	public static final String JING_YING = BASE_URL + "&type=53";
	// ���ݽӿڣ�ͬ�� post��rows=15&page=0&type=54
	public static final String SHU_JU = BASE_URL + "&type=54";

}
