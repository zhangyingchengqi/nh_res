package com.yc.shixun.nhres_2;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.shixun.nhres_2.bean.Resfood;
import com.yc.shixun.nhres_2.bean.Resorder;
import com.yc.shixun.nhres_2.bean.Resorderitem;
import com.yc.shixun.nhres_2.bean.Resuser;
import com.yc.shixun.nhres_2.config.AppConfig;
import com.yc.shixun.nhres_2.dao.ResfoodDao;
import com.yc.shixun.nhres_2.dao.ResorderDao;
import com.yc.shixun.nhres_2.dao.ResorderitemDao;
import com.yc.shixun.nhres_2.dao.ResuserDao;
import com.yc.shixun.nhres_2.utils.Encrypt;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class) // 加载 spring整合 junit 的框架
										// ,spring容器就会自动运行，-> 自动创建对象，装配依赖.
@ContextConfiguration(classes = { AppConfig.class }) // 指定配置文件的类
public class AppTest extends TestCase {

	// 自动注入刚才配置的 @Bean对应的对象 javax.sql.DataSource; jdbc的数据源,
	@Autowired // 是否在spring的容器中有一个 DataSource的接口的实现类的对象.,如果，则自动给 dataSource赋值(
				// DI) 依赖注入.
	private DataSource dataSource; // 接口, -> DriverManagerDataSource

	@Autowired
	private ResfoodDao resfoodDao;
	@Autowired
	private ResorderDao resorderDao;
	@Autowired
	private ResorderitemDao resorderitemDao;
	@Autowired
	private ResuserDao resuserDao;

	@Test
	public void testDataSource() {
		// 断言.
		assertNotNull(dataSource);
	}

	@Test
	public void testResfoodDao() {
		List<Resfood> list = resfoodDao.findAllFood();
		assertEquals(list.size(), 13);
		for (Resfood rf : list) {
			System.out.println(rf.getFname());
		}

	}

	@Test
	public void testResuserDao() {
		Resuser u = new Resuser();
		u.setUsername("a");
		u.setPwd(    Encrypt.md5("a")   );
		Resuser result = resuserDao.login(u);
		assertNotNull(result);
	}

	@Test
	public void testResorderDao() {
		Resorder o = new Resorder();
		o.setAddress("湖南");
		o.setOrdertime("2020-06-02");
		o.setPs("");
		o.setStatus(0);
		o.setTel("123");
		o.setUserid(1);
		Resorder result = resorderDao.insertResorder(o);
		assertNotNull(result.getRoid());
		System.out.println(result.getRoid());

	}

	@Test
	public void testResorderitemDao() {
		Resorderitem ri = new Resorderitem();
		ri.setDealprice(20.0);
		ri.setFid(1);
		ri.setNum(1);
		ri.setRoid(1);      //    注意，一定要先操作  testResorderDao  生成一个订单号   后，再执行这个测试
		resorderitemDao.insertResorderitem(ri);
	}

}
