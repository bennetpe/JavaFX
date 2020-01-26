package gui.pagination;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Callback;

public class View extends BorderPane {
	private Pagination pagination;
	private ToolBar tb;
	private Button secondStageBtn;
	private Button hideBtn;
	private Presenter p;
	private final static int ITEMSPERPAGE = 5;
	private String[] fonts = new String[] {};

	public void setPresenter(Presenter p) {
		this.p = p;
	}
	/**
	 * 
	 * @param pageIndex > wird in start als callback aufgerufen siehe Z52 und bekommt den PageIndex als parameter <br>
	 * wenn der Page index 1 => int page = 1 * 5 = 5 => page = 5 <br>
	 * nun wird in For-Schleife i = page; und geprüft ob (i=5) < (page=5) + (ITEMSPERPAGE=5) => 5 < 10. WAHR bis i = 9
	 *
	 * @return VBox mit 5 Elementen aus Fonts Array
	 */
	public VBox createPage(int pageIndex) {        
        VBox box = new VBox(5);
        int page = pageIndex * ITEMSPERPAGE;
        System.out.println(pageIndex + "*" + ITEMSPERPAGE + "= Page: "+ page);
        for (int i = page; i < page + ITEMSPERPAGE; i++) {
        	 System.out.println("i: "+ i + "= page :" + page +" ITEMSPERPAGE: "+ ITEMSPERPAGE +  "+ Page: " + page + " =>"+ page+ITEMSPERPAGE );
            Label font = new Label(fonts[i]);
            box.getChildren().add(font);
        }
        return box;
    }
	public void initView() {
		fonts = Font.getFamilies().toArray(fonts);
		secondStageBtn = new Button("show second stage");
		hideBtn = new Button("hide");
		tb = new ToolBar();
		tb.getItems().addAll(secondStageBtn, hideBtn);
		pagination = new Pagination(fonts.length / ITEMSPERPAGE, 0);
		pagination.setPageFactory(new Callback<Integer, Node>() {
			@Override
			public Node call(Integer param) {
				return createPage(param);
			}
		});
		 BorderPane.setAlignment(pagination, Pos.CENTER);
	     BorderPane.setMargin(pagination, new Insets(12,12,12,12));
		this.setCenter(pagination);
		
		this.setTop(tb);
		handleSecondButton();
		handleHide();
	}

    
	public Parent getView() {
		// TODO Auto-generated method stub
		return this;
	}

	public void onSecondStage() {
		p.showSecondStage();
	}

	public void onHide() {
		p.hide();
	}

	public void handleSecondButton() {
		secondStageBtn.setOnAction(e -> onSecondStage());
	}

	public void handleHide() {
		hideBtn.setOnAction(e -> onHide());
	}
}
