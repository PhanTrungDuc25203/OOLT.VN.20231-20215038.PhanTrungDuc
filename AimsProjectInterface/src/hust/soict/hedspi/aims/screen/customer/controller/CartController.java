package hust.soict.hedspi.aims.screen.customer.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import hust.soict.hedspi.aims.cart.Cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartController {
	private Cart cart;
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	private Store store;
	private FilteredList<Media> listItems;
	public CartController(Cart cart) {
		this.cart = cart;
		this.listItems = new FilteredList<Media>(cart.getItemOrdered());
	}

    public CartController(Store store, Cart cart) {
		// TODO Auto-generated constructor stub
    	this.store = store;
    	this.cart = cart;
	}

	public FilteredList<Media> getListItems() {
		return listItems;
	}

	public void setListItems(FilteredList<Media> listItems) {
		this.listItems = listItems;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnViewStorePressed;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;
    
    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TextField tfFilter;

    @FXML
    void btnPlayPressed(ActionEvent event) {

    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    }

    @FXML
    void initialize() {
//        assert btnPlay != null : "fx:id=\"btnPlay\" was not injected: check your FXML file 'Cart.fxml'.";
//        assert btnRemove != null : "fx:id=\"btnRemove\" was not injected: check your FXML file 'Cart.fxml'.";
//        assert btnViewStorePressed != null : "fx:id=\"btnViewStorePressed\" was not injected: check your FXML file 'Cart.fxml'.";
//        assert colMediaCategory != null : "fx:id=\"colMediaCategory\" was not injected: check your FXML file 'Cart.fxml'.";
//        assert colMediaCost != null : "fx:id=\"colMediaCost\" was not injected: check your FXML file 'Cart.fxml'.";
//        assert colMediaId != null : "fx:id=\"colMediaId\" was not injected: check your FXML file 'Cart.fxml'.";
//        assert colMediaTitle != null : "fx:id=\"colMediaTitle\" was not injected: check your FXML file 'Cart.fxml'.";
//        assert costLabel != null : "fx:id=\"costLabel\" was not injected: check your FXML file 'Cart.fxml'.";
//        assert filterCategory != null : "fx:id=\"filterCategory\" was not injected: check your FXML file 'Cart.fxml'.";
//        assert tblMedia != null : "fx:id=\"tblMedia\" was not injected: check your FXML file 'Cart.fxml'.";
        
        
        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        if(cart.getItemOrdered() != null) {
        	tblMedia.setItems(listItems);
        } else {
        	
        }
        	
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        
        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {

			@Override
			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
				// TODO Auto-generated method stub
				updateButtonBar(newValue);
			}
        });
        
        tfFilter.textProperty().addListener(new ChangeListener<String>(){

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				showFilteredMedia(newValue);
			}
        });
    }

	protected void showFilteredMedia(String filter) {
		// TODO Auto-generated method stub
		RadioButton selectedButton = (RadioButton)filterCategory.getSelectedToggle();
		if(selectedButton == radioBtnFilterId) {
//			int temp = Integer.parseInt(filter);
			listItems.setPredicate(item -> item.getIdInString().contains(filter));
		} else {
			listItems.setPredicate(item -> item.getTitle().contains(filter));
		}
	}

	void updateButtonBar(Media media) {
		// TODO Auto-generated method stub
		if(media == null) {
			btnPlay.setVisible(true);
			btnRemove.setVisible(true);
		} else {
			btnRemove.setVisible(true);
			if(media instanceof Playable) {
				btnPlay.setVisible(true);
			} else {
				btnPlay.setVisible(false);
			}
		}
	}

}
