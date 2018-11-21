package com.my.bookStore.category.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.bookStore.book.dao.BookDao;
import com.my.bookStore.category.dao.CategoryDao;
import com.my.bookStore.category.entity.Category;
import com.my.bookStore.category.service.CategoryService;
import com.my.bookStore.exception.CategoryException;


@Service
public class CategoryServiceImp implements CategoryService{
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private BookDao bookDao;
	/*
	 * 查询所有分类
	 * @see com.my.bookStore.category.service.CategoryService#findAll()
	 */
	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}
	/*
	 * 添加分类
	 * @see com.my.bookStore.category.service.CategoryService#addCategory(java.lang.String)
	 */
	@Override
	public void addCategory(String categoryName) {
		if(categoryName==null||categoryName.trim().isEmpty()) {
			return;
		}
		List<Category> categoryList = categoryDao.findAll();
		for(Category category:categoryList) {
			if(category.getCategoryName()==categoryName) {
				return;
			}
		}
		categoryDao.addCategory(categoryName);
	}
	/*
	 * 删除分类
	 * @see com.my.bookStore.category.service.CategoryService#deleteCategory(java.lang.String)
	 */
	@Override
	public void deleteCategory(String cid) throws CategoryException {
			int count = bookDao.getCountByCid(cid);
			if(count>0) {
				throw new CategoryException("该分类下还有图书，不能删除！");
			}
			categoryDao.deleteCategory(cid);
	}
	
	/*
	 * 修改分类
	 * @see com.my.bookStore.category.service.CategoryService#updateCategory(java.lang.String, java.lang.String)
	 */
	@Override
	public void updateCategory(String nCategoryName, String cid) throws CategoryException {
		List<Category> categoryList = categoryDao.findAll();
		for(Category category:categoryList) {
			if(nCategoryName==category.getCategoryName()) {
				throw new CategoryException("该分类已存在！");
			}
		}
		categoryDao.updateCategory(nCategoryName, cid);
		
	}
	@Override
	public Category load(String cid) {
		return categoryDao.load(cid);
	}
	
}
