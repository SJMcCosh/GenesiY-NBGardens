package imslogic;


import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;


@Named("products")
@SessionScoped
public class ImsProductController implements Serializable{

	
	@Inject
	private ImsProductManagerInterface imsProdManager;
	
	private ImsProduct imsProduct;
	
	private DataModel<ImsProduct> imsDataModel = null;
	
	
	private void recreateModel(){
		imsDataModel = null;
	}
	
	
	public ImsProduct getImsProduct() {
		return imsProduct;
	}

	public void setImsProduct(ImsProduct product) {
		this.imsProduct = product;
	}
	
	
	
	
	
	

}
