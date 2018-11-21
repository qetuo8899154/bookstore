package com.my.bookStore.category.service;

import java.util.List;

import com.my.bookStore.category.entity.Category;
import com.my.bookStore.exception.CategoryException;

public interface CategoryService {
	/**
	 * 查找所有分类
	 * @return
	 */
	List<Category> findAll();
	/**
	 * 添加分类
	 */
	void addCategory(String categoryName);
	/**
	 * 删除分类
	 * @throws CategoryException 
	 */
	void deleteCategory(String category) throws CategoryException;
	/**
	 * 修改分类
	 * @throws CategoryException 
	 */
	void updateCategory(String nCategoryName,String categoryName) throws CategoryException;
	/**
	 * 加载分类
	 * @param cid
	 * @return
	 */
	Category load(String cid);
}
