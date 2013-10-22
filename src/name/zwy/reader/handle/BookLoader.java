package name.zwy.reader.handle;

import java.util.ArrayList;

import name.zwy.reader.AllResource;
import name.zwy.reader.model.Book;
import name.zwy.reader.model.OpenedBook;
import name.zwy.reader.model.Page;
import name.zwy.reader.model.PageSetting;

public class BookLoader {
	public static OpenedBook load(Book book, PageSetting pgSet, AllResource allRes) {
		getBookContent(book);
		
		ContentIterator iter = new ContentIterator(pgSet, book.content);
		
		ArrayList<Page> pageList = new ArrayList<Page>();
		
		while (iter.hasNextPage()) {
			pageList.add(iter.nextPage());
		}
		
		OpenedBook ob = new OpenedBook();
		ob.book = book;
		ob.curr_pege_no = 1;
		ob.page_count = pageList.size();
		ob.row_count = ob.page_count * pgSet.row_count;
		ob.pageList = pageList;
		
		ob.buildBook();
		ob.connectReader(allRes);
		
		return ob;
	}
	
	public static void getBookContent(Book book) {
		if (book.content == null) {
			book.content = "asdjfa;lsdkjf";
		}
	}
}
