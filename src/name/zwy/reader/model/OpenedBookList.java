package name.zwy.reader.model;

import java.util.HashMap;

import javafx.scene.control.Tab;

public class OpenedBookList {
	HashMap<Tab, OpenedBook> bookList = new HashMap<Tab, OpenedBook>();
	
	public OpenedBook get(Tab tab) {
		return bookList.get(tab);
	}
	
	public void put(Tab tab, OpenedBook book) {
		bookList.put(tab, book);
	}
}
