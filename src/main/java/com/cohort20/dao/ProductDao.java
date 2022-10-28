package com.cohort20.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cohort20.db.DBUtils;
import com.cohort20.to.Product;
import com.cohort20.to.User;

public class ProductDao {

	public Product selectProduct(int productID) throws Exception {
		Connection conn = DBUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from product where productID = ?");
		pstmt.setInt(1, productID);
		Product product = null;
		ResultSet prs = pstmt.executeQuery();
		while (prs.next()) {
			product = (new Product(prs.getInt(1), prs.getString(2), prs.getDouble(3), prs.getInt(4)));
		}
		return product;
	}
	
//	public void updateStockCount(Integer productID, Integer unitCount) throws Exception {
//		Connection conn = DBUtils.getConnection();
//		PreparedStatement pstmt = conn.prepareStatement("update product set unitCount = ? where productID = ?");
//		pstmt.setInt(1, unitCount.intValue());
//		pstmt.setInt(2, productID.intValue());
//		pstmt.executeUpdate();
//}
	
	public Product updateStock(Product product, int productID) throws Exception {
		Connection conn = DBUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("update product set unitCount = ? where productID = ?");
		pstmt.setInt(1, (product.getUnitCount()-1));
		pstmt.setInt(2, productID);
		pstmt.executeUpdate();
		product = selectProduct(productID) ;
		return product;
}
	public Product replenishStock(Product product, int productID) throws Exception {
		Connection conn = DBUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("update product set unitCount = ? where productID = ?");
		pstmt.setInt(1, (product.getUnitCount()+1));
		pstmt.setInt(2, productID);
		pstmt.executeUpdate();
		product = selectProduct(productID) ;
		return product;
	}
	
	public void createProduct(Product product) throws Exception {
		Connection conn = DBUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("insert into product values (?,?,?,?) ");
		pstmt.setInt(1, product.getProductID());
		pstmt.setString(2, product.getName());
		pstmt.setDouble(3, product.getPrice());
		pstmt.setInt(4, product.getUnitCount());
		pstmt.execute();

	}
//	public Product getUser(int productID) throws Exception {
//		Connection conn = DBUtils.getConnection();
//		PreparedStatement pstmt = conn.prepareStatement("select * from product where productID = ?");
//		pstmt.setInt(1, productID);
//		ResultSet rs = pstmt.executeQuery();
//		Product product = null;
//		if (rs.next()) {
//			product = (new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4)));
//		}
//		return product;
//
//	}
}
