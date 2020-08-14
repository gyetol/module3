package kr.co.dinner41.vo;

import java.sql.Timestamp;

public class MenuVO {

	private int id;
	private StoreVO store;
	private OfferTypeVO offerType;
	private String name;
	private int price;
	private int amount;
	private String notice;
	private String tag;
	private String photo;
	private Timestamp removeDate;
	
	public MenuVO() {}

	public MenuVO(int id, StoreVO store, OfferTypeVO offerType, String name, int price, int amount, String notice,
			String tag, String photo, Timestamp removeDate) {
		super();
		this.id = id;
		this.store = store;
		this.offerType = offerType;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.notice = notice;
		this.tag = tag;
		this.photo = photo;
		this.removeDate = removeDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StoreVO getStore() {
		return store;
	}

	public void setStore(StoreVO store) {
		this.store = store;
	}

	public OfferTypeVO getOfferType() {
		return offerType;
	}

	public void setOfferType(OfferTypeVO offerType) {
		this.offerType = offerType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Timestamp getRemoveDate() {
		return removeDate;
	}

	public void setRemoveDate(Timestamp removeDate) {
		this.removeDate = removeDate;
	}
	
}


