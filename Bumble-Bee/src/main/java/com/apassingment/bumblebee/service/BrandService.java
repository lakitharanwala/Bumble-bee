package com.apassingment.bumblebee.service;

import java.sql.SQLException;
import java.util.List;

import com.apassingment.bumblebee.dao.BrandDAO;
import com.apassingment.bumblebee.model.Brand;
import com.apassingment.bumblebee.model.Products;
import com.apassingment.bumblebee.util.Status;


public class BrandService extends IdGenImpl{

private static BrandService brandService;
	
	public static BrandService getBrandServiceService() {
		brandService=new BrandService();
		return brandService;		
	}
	
	private BrandDAO getBrandDAO() {
		return new BrandDAO();
	}

	public List<Brand> getallBrands() throws ClassNotFoundException, SQLException {
		return getBrandDAO().getAllbrands();
	}

	public Brand saveBrand(Brand brand) throws ClassNotFoundException, SQLException {
		brand.setId(getId());
		brand.setStatus(Status.ACTIVE.getDatabaseValue());
		getBrandDAO().saveBrand(brand);
		return brand;
		
	}

	public boolean getdelete(String id) throws ClassNotFoundException, SQLException {
		return getBrandDAO().getDeleteBarnd(id);
	}

	public List<Brand> brandSearch(String barndSearch) throws ClassNotFoundException, SQLException {
		return getBrandDAO().getBrandSearch(barndSearch);
	}

	public Brand SaveEdit(Brand brand) throws ClassNotFoundException, SQLException {
		return getBrandDAO().getSaveEditor(brand);
	}


	
	
}
