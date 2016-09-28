import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * Purchase Order Line Outline
 * @author Thomas Chatterjee
 *
 */
@Entity
@Table (name = "PurchaseOrderLine")
public class PurchaseOrderLine {
	
	@ManyToOne
	@Id
	@JoinColumn(name = "purchaseOrderID_fk", nullable = false)
	@NotNull
	private PurchaseOrder purchaseOrder;
	
	@ManyToOne
	@Id
	@JoinColumn(name = "productID_fk", nullable = false)
	@NotNull
	private Product product;
	
	@Column (name = "quantity", nullable = false)
	@NotNull
	private int quantity;
	@Column (name = "price", nullable = false, length = 8)
	@Size (min = 1, max = 8)
	@NotNull
	private double price;
	

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
