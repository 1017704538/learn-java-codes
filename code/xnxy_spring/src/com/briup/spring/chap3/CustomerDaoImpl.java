package com.briup.spring.chap3;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

public class CustomerDaoImpl implements CustomerDao {

	//dateSource��ȡ���ݿ�������Ӳ���
	//ͨ�������ļ����������ע�뵽dateSource������
	private DataSource dataSource;
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public void saveCustomer(Customer customer) {
		Connection connection = DataSourceUtils.getConnection(dataSource);
		System.out.println(connection);
		String sql = "insert into customer values(?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, customer.getId());
			ps.setString(2, customer.getName());
			ps.setInt(3, customer.getAge());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void deleteCustomer(Customer customer) {
		
	}
	
}
