package com.my.bookStore.category.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.my.bookStore.category.entity.Category;

/**
 * 分类模块dao接口
 * @author Administrator
 *
 */
public interface CategoryDao {
	/**
	 * 查询所有分类
	 * @return
	 */
	List<Category> findAll();
	/**
	 * 添加分类
	 * @param categoryName
	 */
	void addCategory(String categoryName);
	/**
	 * 删除分类
	 * @param categoryName
	 */
	void deleteCategory(String cid);
	/**
	 * 修改分类
	 */
	void updateCategory(@Param("nCategoryName")String nCategoryName,@Param("cid") String cid);
	/**
	 * 加载分类
	 * @param cid
	 * @return
	 */
	Category load(String cid);
}
