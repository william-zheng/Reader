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
		return "  监视器关闭了。安德试着想像这个小仪器从他的后颈上被拿掉后的情形，以后在床上翻转时就不会压着脖子，在洗澡时也不会感觉到刺痛了。而且从此以后彼德也不会再恨我了，我要回家让他看看，我和他一样，是一个正常的孩子了。这倒不坏，他会原谅我比他晚一年拿掉监视器的，我们将会成为住在同一所房子里，但不会是朋友，决不会，彼德太危险了，我们不是敌人、不是朋友，只是兄弟。当他想玩太空战士打虫族游戏时，或许我会不得不陪他玩，或许我可以去看看书。    但安德很清楚，即使他这样想，彼得也不会放过他的。当彼得陷入疯狂状态时，他的眼里含着某种东西，不管何时安德看着他的眼神，就知道彼得是不会放过他的。安德仿佛又听见彼得在喊，我在弹钢琴，安德，来帮我翻乐谱，哦，这个戴着监视器的小子忙得顾不上他的哥哥了？还是他太聪明了？来杀死虫人吧，太空战士安德？不，不，我不需要你的帮助，我会自己做，你这个杂种，你这个多余的杂种！    “不会用很长时间的，安德。”医生说。    安德点点头。    “它是很容易拿掉的，不会有感染，不会有伤害，但会有一点痒。有些人会觉得他们失去了某些东西。你可能会寻找一些你找不到的东西，你不知道你在找什么，我告诉你吧，其实你要找的就是监视器，它不在了。过几天这种感觉就会消失的。”    医生在安德的后颈上拔弄着，安德突然感到一种剧痛，好象有支针从他的脖子一直到肚子，他的脖子在抽筋，身体向后强烈地弯曲，头撞到了床，他感觉到双脚沉重，双手紧紧地握在一起，抓得生痛。    “护士！”医生大叫，“快来帮忙！”有个护士气喘吁吁地跑了进来。“帮他放松这些肌肉，把那个递给我，快！你还在等什么！”    有个东西插入他的手中，安德看不到那是什么，他跌下了检查台。“抓住他！”护士尖叫着。    “把他固定住。”    “你来吧，医生，他太强壮了，我抓不住。”    “不要全压上去，你会弄死他的！”    安德感到有支针插入后颈，很痛，他的全身无处不充满剧痛，他的肌肉慢慢的松驰了下来，现在他可以大声的哭出声音来了。    “你感觉怎样，安德？”护士说。    安德说不话来，他们把他抬上了桌子，检查他的脉搏和其它一些他不明白的事情。    医生的声音有点发颤，“他们把这东西放进这孩子的身体有三年了，他们到底想知道些什么？我们可能会弄死他的，难道他们不清楚？我们可能会使他变成植物人的。”    “麻药什么时候失效？”护士问。    “把他留在这至少一小时，看着他，如果他在十五分钟内还不能说出话来，立刻喊我。我们可能会永远伤害他的，他又不是虫人！”    ※　";
	}
}
