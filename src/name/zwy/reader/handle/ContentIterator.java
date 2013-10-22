package name.zwy.reader.handle;

import name.zwy.reader.model.Page;
import name.zwy.reader.model.PageSetting;

public class ContentIterator {
	
	private PageSetting setting = null;
	
	private String content = null;
	
	private int count = 0;
	
	public ContentIterator(PageSetting setting, String content) {
		this.setting = setting;
		this.content = content;
		this.count = 0;
	}
	
	public boolean hasNextPage() {
		return count++ < 500;
	}
	
	public Page nextPage() {
		Page page = new Page(setting);
		String pageContent = getPageContent();
		page.setText(pageContent);
		return page;
	}
	
	private String getPageContent() {
		return "  �������ر��ˡ����������������С���������ĺ��ϱ��õ�������Σ��Ժ��ڴ��Ϸ�תʱ�Ͳ���ѹ�Ų��ӣ���ϴ��ʱҲ����о�����ʹ�ˡ����ҴӴ��Ժ�˵�Ҳ�����ٺ����ˣ���Ҫ�ؼ������������Һ���һ������һ�������ĺ����ˡ��⵹����������ԭ���ұ�����һ���õ��������ģ����ǽ����Ϊס��ͬһ������������������ѣ������ᣬ�˵�̫Σ���ˣ����ǲ��ǵ��ˡ��������ѣ�ֻ���ֵܡ���������̫��սʿ�������Ϸʱ�������һ᲻�ò������棬�����ҿ���ȥ�����顣    �����º��������ʹ�������룬�˵�Ҳ����Ź����ġ����˵�������״̬ʱ���������ﺬ��ĳ�ֶ��������ܺ�ʱ���¿����������񣬾�֪���˵��ǲ���Ź����ġ����··��������˵��ں������ڵ����٣����£������ҷ����ף�Ŷ��������ż�������С��æ�ù˲������ĸ���ˣ�������̫�����ˣ���ɱ�����˰ɣ�̫��սʿ���£����������Ҳ���Ҫ��İ������һ��Լ�������������֣��������������֣�    �������úܳ�ʱ��ģ����¡���ҽ��˵��    ���µ��ͷ��    �����Ǻ������õ��ģ������и�Ⱦ���������˺���������һ��������Щ�˻��������ʧȥ��ĳЩ����������ܻ�Ѱ��һЩ���Ҳ����Ķ������㲻֪��������ʲô���Ҹ�����ɣ���ʵ��Ҫ�ҵľ��Ǽ��������������ˡ����������ָо��ͻ���ʧ�ġ���    ҽ���ڰ��µĺ��ϰ�Ū�ţ�����ͻȻ�е�һ�־�ʹ��������֧������Ĳ���һֱ�����ӣ����Ĳ����ڳ��������ǿ�ҵ�������ͷײ���˴������о���˫�ų��أ�˫�ֽ���������һ��ץ����ʹ��    ����ʿ����ҽ����У���������æ�����и���ʿ�������������˽�����������������Щ���⣬���Ǹ��ݸ��ң��죡�㻹�ڵ�ʲô����    �и����������������У����¿���������ʲô���������˼��̨����ץס��������ʿ����š�    �������̶�ס����    �������ɣ�ҽ������̫ǿ׳�ˣ���ץ��ס����    ����Ҫȫѹ��ȥ�����Ū�����ģ���    ���¸е���֧�����󾱣���ʹ������ȫ���޴���������ʹ�����ļ����������ɳ������������������Դ����Ŀ޳��������ˡ�    ����о����������£�����ʿ˵��    ����˵�����������ǰ���̧�������ӣ������������������һЩ�������׵����顣    ҽ���������е㷢���������ǰ��ⶫ���Ž��⺢�ӵ������������ˣ����ǵ�����֪��Щʲô�����ǿ��ܻ�Ū�����ģ��ѵ����ǲ���������ǿ��ܻ�ʹ�����ֲ���˵ġ���    ����ҩʲôʱ��ʧЧ������ʿ�ʡ�    ����������������һСʱ�����������������ʮ������ڻ�����˵�����������̺��ҡ����ǿ��ܻ���Զ�˺����ģ����ֲ��ǳ��ˣ���    ����";
	}
}