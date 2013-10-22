package name.zwy.reader.model;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPaneBuilder;
import javafx.scene.control.Tab;
import javafx.scene.control.TabBuilder;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import name.zwy.reader.AllResource;

public class OpenedBook {
	public Book book = null;

	public int page_count = 0;
	
	public int row_count = 0;
	
	public int curr_pege_no = 0;
	
	public ArrayList<Page> pageList = null;
	
	public Tab docTab = null;
	
	public ScrollPane docSrcollPane = null;
	
	public VBox docContent = null;
	
	public HBox docTitle = null;
	

    private double yOffset = 0;
    private double srollVvalue = 0;
	
	public void buildBook() {
		// ÄÚÈÝ
		
		Region leftSpring = new Region();
		Region rightSpring = new Region();
		
		docContent = VBoxBuilder.create()
				.prefHeight(-1.0).prefWidth(-1.0).spacing(5.0)
				.build();
		
		docSrcollPane = ScrollPaneBuilder.create()
				.fitToHeight(false).fitToWidth(true)
//				.onKeyPressed(new EventHandler<KeyEvent>() {
//		            @Override
//		            public void handle(KeyEvent event) {
//		            	System.out.println(11);
//		            	KeyCode keyCode = event.getCode();
//		            	if (KeyCode.UP.equals(keyCode)) {
//		            		docSrcollPane.setVvalue(docSrcollPane.getVvalue() - 3.0/100);
//		            	} else if (KeyCode.DOWN.equals(keyCode)) {
//		            		docSrcollPane.setVvalue(docSrcollPane.getVvalue() + 3.0/100);
//		            	}
//		            }
//		        })
				.prefHeight(-1.0).prefWidth(-1.0)
				.style("-fx-background-color: null;")
				.content(
						HBoxBuilder.create()
						.maxHeight(Double.MAX_VALUE).maxWidth(Double.MAX_VALUE)
						.prefHeight(-1.0).prefWidth(600)
						.snapToPixel(true)
						.styleClass("reader-cursor")
						.onMouseDragged(new EventHandler<MouseEvent>() {
					
							@Override
							public void handle(MouseEvent event) {
								double a = event.getScreenY() - yOffset;
								docSrcollPane.setVvalue(srollVvalue - a);
							};
		
					    	 
						})
						.onMousePressed(new EventHandler<MouseEvent>() {

							@Override
							public void handle(MouseEvent event) {
						        yOffset = event.getSceneY();
						        srollVvalue = docSrcollPane.getVvalue();
							}
							
						})
						.children(
								leftSpring,
								docContent,
								rightSpring)
						.build())
				.build();
		HBox.setHgrow(leftSpring, Priority.ALWAYS);
		HBox.setHgrow(docContent, Priority.NEVER);
		HBox.setHgrow(rightSpring, Priority.ALWAYS);

		docSrcollPane.setVmax(1080.0 * page_count + 5 * (page_count - 1) - docSrcollPane.getHeight());
		
		
		Iterator<Page> iter = pageList.iterator();
		while (iter.hasNext()) {
			Page page = iter.next();
			docContent.getChildren().add(page.pageBP);
		}
		
		docTab = TabBuilder.create()
				.closable(true).text(book.title)
				
				.content(docSrcollPane)
				.build();
		
	}
	
	public void connectReader(AllResource allRes) {
		TabPane bookTP = allRes.docCtrl.getBookTP();
		bookTP.getTabs().add(docTab);
		
		allRes.bookList.put(docTab, this);
	}
}
