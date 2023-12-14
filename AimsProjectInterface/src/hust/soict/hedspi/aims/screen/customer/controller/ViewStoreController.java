package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import hust.soict.hedspi.aims.cart.Cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ViewStoreController {
	private Store store;
	private Cart cart;
	public  ViewStoreController(Store store) {
		this.store = store;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane gridPane;

    @FXML
    void btnViewCartPressed(ActionEvent event) {
    	try {
    		final String CART_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
    		fxmlLoader.setController(new CartController(store, cart));
    		Parent root = fxmlLoader.load();
    		
    		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		stage.setScene(new Scene(root));
    		stage.setTitle("Cart");
    		stage.show();	
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    public void initialize() {
        final String ITEM_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Item.fxml";
        int column = 0;
        int row = 1;
        for(int i=0; i<store.getItemsInStore().size(); i++) {
        	try {
        		FXMLLoader fxmlLoader = new FXMLLoader();
        		fxmlLoader.setLocation(getClass().getResource(ITEM_FXML_FILE_PATH));
        		
				ItemController itemController = new ItemController(cart);
        		fxmlLoader.setController(itemController);
        		AnchorPane anchorPane = new AnchorPane();
        		anchorPane = fxmlLoader.load();
        		itemController.setData(store.getItemsInStore().get(i));
        		
        		gridPane.add(anchorPane, column++, row);
        		if(column == 3) {
        			column = 0;
        			row++;
        		}
        		
        		GridPane.setMargin(anchorPane, new Insets(20, 10, 10, 10));
        	} catch(IOException e){
        		e.printStackTrace();
        	}
        }
    }
}
