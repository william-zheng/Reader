package name.zwy.reader;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import name.zwy.reader.model.OpenedBook;


public class DocumentController {
	
	public AllResource allRes = null;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TabPane bookTP;
    
    @FXML
    private ScrollPane docSrcollPane;

	@FXML
    private BorderPane page1;

    @FXML
    private BorderPane page2;

    @FXML
    void keybdCtrl(KeyEvent event) {
    	KeyCode keyCode = event.getCode();
    	System.out.println(123);
    	if (KeyCode.UP.equals(keyCode)) {
        	System.out.println(docSrcollPane.getVvalue());
    		docSrcollPane.setVvalue(docSrcollPane.getVvalue() - 3.0/100);
    	} else if (KeyCode.DOWN.equals(keyCode)) {
        	System.out.println(docSrcollPane.getVvalue());
    		docSrcollPane.setVvalue(docSrcollPane.getVvalue() + 3.0/100);
    	}
    }

    public ScrollPane getDocSrcollPane() {
		return docSrcollPane;
	}

    public BorderPane getPage1() {
		return page1;
	}

	public BorderPane getPage2() {
		return page2;
	}
	
	public TabPane getBookTP() {
		return bookTP;
	}


	@FXML
    void initialize() {
        assert page1 != null : "fx:id=\"page1\" was not injected: check your FXML file 'Document.fxml'.";
        assert page2 != null : "fx:id=\"page2\" was not injected: check your FXML file 'Document.fxml'.";

        bookTP.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {  
            @Override  
            public void handle(KeyEvent event) {
            	KeyCode keyCode = event.getCode();
            	OpenedBook book = allRes.bookList.get(bookTP.getSelectionModel().getSelectedItem());
            	if (KeyCode.UP.equals(keyCode)) {
                	book.docSrcollPane.setVvalue(book.docSrcollPane.getVvalue() - 50);
            	} else if (KeyCode.DOWN.equals(keyCode)) {
                	book.docSrcollPane.setVvalue(book.docSrcollPane.getVvalue() + 50);
            	}
            	event.consume();
            }
        });
    }

}
