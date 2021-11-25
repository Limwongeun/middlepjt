package vo;

public class CartVO {

	private String order_no;
	private String prod_id;
	private int cart_qty;
	private int cart_price;
	private String cart_set;
	private String prod_url;
	private String prod_name;
	private String lprod_name;
	
	public final String getLprod_name() {
		return lprod_name;
	}
	public final void setLprod_name(String lprod_name) {
		this.lprod_name = lprod_name;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getProd_url() {
		return prod_url;
	}
	public void setProd_url(String prod_img) {
		this.prod_url = prod_img;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public int getCart_qty() {
		return cart_qty;
	}
	public void setCart_qty(int cart_qty) {
		this.cart_qty = cart_qty;
	}
	public int getCart_price() {
		return cart_price;
	}
	public void setCart_price(int cart_price) {
		this.cart_price = cart_price;
	}
	public String getCart_set() {
		return cart_set;
	}
	public void setCart_set(String cart_set) {
		this.cart_set = cart_set;
	}
	
	
}
