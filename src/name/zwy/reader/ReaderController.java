package name.zwy.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.UUID;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuItemBuilder;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import name.zwy.reader.model.Book;
import name.zwy.reader.model.OpenedBook;


public class ReaderController {
    private double xOffset = 0;
    private double yOffset = 0;
    
    public AllResource allres = null;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane bp_root;
    
    @FXML
    private MenuButton btn_main_menu;

    @FXML
    private Label lbl_page_count;

    @FXML
    private Label lbl_title;

    @FXML
    private TextField tf_curr_page;
    
    @FXML
    private Menu menu_recent_file;

    @FXML
    void systemClose(MouseEvent event) {
    	Platform.exit();
    }
    
    @FXML
    void onClick_MinBtn(MouseEvent event) {
    	allres.primaryStage.setIconified(true);
    }
    
    @FXML
    void onClick_MaxBtn(MouseEvent event) {
    	boolean isMax = allres.primaryStage.isFullScreen();
    	if (!isMax) {
    		allres.primaryStage.setFullScreen(true);
    	} else {
    		allres.primaryStage.setFullScreen(false);
    	}
    }
    
    
    @FXML
    void main_menu_m_entered(MouseEvent event) {
    	DropShadow shadow = new DropShadow();
    	btn_main_menu.setEffect(shadow);
    }

    @FXML
    void main_menu_m_exited(MouseEvent event) {
    	btn_main_menu.setEffect(null);
    }
    
    @FXML
    void onWindowDragged(MouseEvent event) {
    	allres.primaryStage.setX(event.getScreenX() - xOffset);  
    	allres.primaryStage.setY(event.getScreenY() - yOffset);  
    }
    
    @FXML
    void onWindowPressed(MouseEvent event) {
    	xOffset = event.getSceneX();  
        yOffset = event.getSceneY();  
    }
    
    @FXML
    void gotoPage(KeyEvent event) {
    	if (KeyCode.ENTER.equals(event.getCode())) {
    		String text = ((TextField)event.getSource()).getText();
    		try {
    			int pageNo = Integer.parseInt(text);
    			Tab selectTab = allres.docCtrl.getBookTP().getSelectionModel().getSelectedItem();
    			OpenedBook book = allres.bookList.get(selectTab);
    			book.docSrcollPane.setVvalue(pageNo * 1080 + 5 * (pageNo - 1));
//    			allres.docCtrl.getPage2().requestFocus();
//    			allres.docCtrl.getDocSrcollPane().setVvalue(0.25);
    		} catch (NumberFormatException e) {
    			
    		}
    	}
    }
    
    @FXML
    void openFile(ActionEvent event) {
    	File f = showFileChooser();
		if (f == null)
			return;
		
    	Book book = new Book();
    	book.id = UUID.randomUUID().toString();
    	book.title = f.getName();
    	book.last_read_time = new Date();
    	book.path = f.getPath();
    	book.percent = 0.0;

    	StringBuilder content = new StringBuilder();
    	try {
			BufferedReader reader = new BufferedReader(new FileReader(f));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
                // 显示行号
				content.append(tempString);
            }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	book.content = content.toString();
    	
    	MenuItem item = MenuItemBuilder.create().id(book.id).text(book.title).build();
    	menu_recent_file.getItems().add(item);
    }

    @FXML
    void initialize() {
        assert bp_root != null : "fx:id=\"bp_root\" was not injected: check your FXML file 'Reader.fxml'.";
        assert lbl_title != null : "fx:id=\"lbl_title\" was not injected: check your FXML file 'Reader.fxml'.";

    }
    
    public void setTitle(String title) {
    	lbl_title.setText(title);
    }
    
    public int getCurrPageNo() {
		return Integer.valueOf(this.tf_curr_page.getText());
	}

	public void setCurrPageNo(int pageNo) {
		this.tf_curr_page.setText("" + pageNo);
	}

	public void setBookPageCount(int pageCount) {
		this.lbl_page_count.setText("/ " + pageCount);
	}

	public static void selectOpenedBook(AllResource allRes, OpenedBook ob) {
    	allRes.docCtrl.getBookTP().getSelectionModel().select(ob.docTab);
    	allRes.readerCtrl.setBookPageCount(ob.page_count);
    	allRes.readerCtrl.setCurrPageNo(ob.curr_pege_no);
    }
	
	/**
	 * Show a file chooser, returning a File.
	 * 
	 * @return File or null if canceled
	 */
	private File showFileChooser() {
		FileChooser fc = new FileChooser();
		fc.setTitle("打开");
		fc.getExtensionFilters().add(
				new FileChooser.ExtensionFilter("文本文件txt", "*.txt"));
		return fc.showOpenDialog(allres.primaryStage.getOwner());
	}

}
