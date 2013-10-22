package name.zwy.reader.model;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderPaneBuilder;
import javafx.scene.layout.RegionBuilder;

public class Page {
	
	public PageSetting setting = null;
	
	public BorderPane pageBP = null;
	
	public Label lal = null;
	
	public int pageNo = 0;
	
	public Page(PageSetting setting) {
		this.setting = setting;
		
		lal = LabelBuilder.create()
				.alignment(Pos.TOP_LEFT)
				.styleClass("book_font")
				.prefWidth(setting.content_width)
				.prefHeight(setting.content_height)
				.wrapText(true)
				.text("").build();
		
		pageBP = BorderPaneBuilder.create()
				.styleClass("book_background")
				.prefWidth(setting.page_width)
				.prefHeight(setting.page_height)
//				.top(RegionBuilder.create().prefHeight(-1.0).prefWidth(-1.0).build())
//				.left(RegionBuilder.create().prefHeight(-1.0).prefWidth(-1.0).build())
				.center(lal)
//				.right(RegionBuilder.create().prefHeight(-1.0).prefWidth(-1.0).build())
//				.bottom(RegionBuilder.create().prefHeight(-1.0).prefWidth(-1.0).build())
				.build();
		
	}
	
	public Page setText(String content) {
		lal.setText(content);
		return this;
	}
}
