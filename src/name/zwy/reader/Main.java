package name.zwy.reader;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import name.zwy.reader.handle.BookLoader;
import name.zwy.reader.model.Book;
import name.zwy.reader.model.OpenedBook;
import name.zwy.reader.model.OpenedBookList;
import name.zwy.reader.model.PageSetting;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AllResource allRes = new AllResource();
			allRes.primaryStage = primaryStage;
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/themes/Reader.fxml"));

			BorderPane root = (BorderPane)loader.load();
			ReaderController ctrl = loader.getController();
			allRes.readerCtrl = ctrl;
			ctrl.allres = allRes;
			
			Scene scene = new Scene(root,1080,684);
			scene.getStylesheets().add(getClass().getResource("/themes/default.css").toExternalForm());
			
			ctrl.setTitle("欢迎使用小说阅读器");
//			ObservableList<Node> children = root.getChildren();
//			
//			Iterator<Node> iter = children.iterator();
//			while (iter.hasNext()) {
//				Node node = iter.next();
//				System.out.println(node.getClass().getName());
//				System.out.println(node.getId());
//			}
			
			FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/themes/Document.fxml"));
			BorderPane center = (BorderPane)loader2.load();
			DocumentController ctrl2 = loader2.getController();
			allRes.docCtrl = ctrl2;
			ctrl2.allRes = allRes;
			
			root.setCenter(center);
			BorderPane.setMargin(center, new Insets(0));
			
			OpenedBookList bookList = new OpenedBookList();
			allRes.bookList = bookList;
			
			Book testBk = new Book();
			testBk.title = "aaa";
			OpenedBook openedBook = BookLoader.load(testBk, new PageSetting(), allRes);
			
			// 切换
			ReaderController.selectOpenedBook(allRes, openedBook);
			
		    primaryStage.initStyle(StageStyle.UNDECORATED);//去除标题栏
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
