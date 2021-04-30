package com.ServiceImpl;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.dao.BaseDao;
import com.daoImpl.DengLuDaoImpl;
import com.daoImpl.JueseDaoImpl;
import com.entity.Lr_bumeng;
import com.entity.User;
import com.service.BumenServiceZXD;
import com.utils.DataBaseUtil;

/*
 * 访问部门业务实现层
 */
public class BumenServiceImplZXD implements BumenServiceZXD {
	private static final Logger LOGGER = Logger.getLogger(BaseDao.class.getName());

	/*
	 * 获取部门列表 (non-Javadoc)
	 * 
	 * @see com.service.BumenServiceZXD#gitBumens()
	 */
	@Override
	public List<Lr_bumeng> gitBumens() {
		// TODO Auto-generated method stub
		// 创建连接对象
		Connection conn = null;
		// 创建结合
		List<Lr_bumeng> list = null;
		try {
			conn = DataBaseUtil.getConnection();

			list = new JueseDaoImpl(conn).Lr_bumengList();

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			// �ͷ���Դ��
			DataBaseUtil.closeAll(null, null, conn);
		}
		return list;
	}

}
