package com.apassingment.bumblebee.service;

import java.sql.SQLException;
import java.util.List;
import com.apassingment.bumblebee.model.Category;
import com.apassingment.bumblebee.util.Status;
import com.apassingment.bumblebee.dao.CategoryDAO;

public class CategoryService extends IdGenImpl{
private static CategoryService categoryService;
	
	public static CategoryService getCategoryService() {
		categoryService=new CategoryService();
		return categoryService;		
	}
	
	private CategoryDAO getCategoryDAO() {
		return new CategoryDAO();
	}

	public List<Category> getallcatorys() throws ClassNotFoundException, SQLException {
		return getCategoryDAO().getAllCategorys();
	}

	public Category savecategory(Category category) throws ClassNotFoundException, SQLException {
		category.setId(getId());
		category.setStatus(Status.ACTIVE.getDatabaseValue());
		getCategoryDAO().saveCategory(category);
		return category;
	}

	public boolean getdelete(String id) throws ClassNotFoundException, SQLException {
		return getCategoryDAO().getdeletecat(id);
	}

	

	public Category geteditdetails(String id) throws ClassNotFoundException, SQLException {
		return getCategoryDAO().getEditCategoryDetails(id);
	}

	public List<Category> categorySearch(String categorySearch) throws ClassNotFoundException, SQLException {
		return getCategoryDAO().getCategorySearch(categorySearch);
	}

	
}
