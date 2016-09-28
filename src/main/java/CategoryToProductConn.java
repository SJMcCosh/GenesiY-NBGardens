import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Outline class connecting Categories and Products
 * @author Thomas Chatterjee
 *
 */
public class CategoryToProductConn {
	@ManyToOne
	@Id
	@JoinColumn (name = "productID", nullable = false)
	@NotNull
	private Product product;
	@ManyToOne
	@Id
	@JoinColumn (name = "category", nullable = false)
	@NotNull
	private Category category;
}
