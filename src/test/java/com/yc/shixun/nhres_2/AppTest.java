package com.yc.shixun.nhres_2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.yc.shixun.nhres_2.service.ResfoodBiz;
import com.yc.shixun.nhres_2.service.ResorderBiz;
import com.yc.shixun.nhres_2.service.ResuserBiz;
import com.yc.shixun.nhres_2.utils.Encrypt;
import com.yc.shixun.nhres_2.web.entity.CartItem;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class) // 加载 spring整合 junit 的框架
										// ,spring容器就会自动运行，-> 自动创建对象，装配依赖.
@ContextConfiguration(classes = { AppConfig.class }) // 指定配置文件的类
public class AppTest extends TestCase {

	// 自动注入刚才配置的 @Bean对应的对象 javax.sql.DataSource; jdbc的数据源,
	@Autowired // 是否在spring的容器中有一个 DataSource的接口的实现类的对象.,如果，则自动给 dataSource赋值(
				// DI) 依赖注入.
	private DataSource dataSource; // 接口, -> DriverManagerDataSource

	//DAO: 测试
	@Autowired
	private ResfoodDao resfoodDao;
	@Autowired
	private ResorderDao resorderDao;
	@Autowired
	private ResorderitemDao resorderitemDao;
	@Autowired
	private ResuserDao resuserDao;
	
	//业务层测试:
	@Autowired
	private ResuserBiz resuserBiz;
	@Autowired
	private ResfoodBiz resfoodBiz;
	@Autowired
	private ResorderBiz resorderBiz;
	
	@Test
	public void testResorderBiz() {
		Resorder o=new Resorder();
		o.setAddress("湖南");
		o.setPs("快快...");
		o.setTel("13898989898");
		o.setUserid(1);
		
		int resfoodid=2;
		
		Map<Integer, CartItem> shopCart=new HashMap<Integer, CartItem>();
		Resfood r=new Resfood();
		r.setFid(    resfoodid  );
		r.setRealprice(100.0);
		
		CartItem ci=new CartItem();
		ci.setNum(2);
		ci.setFood(r);
		shopCart.put(    resfoodid, ci);
		
		r=new Resfood();
		r.setFid(  3    );
		r.setRealprice(200.0);
		CartItem ci2=new CartItem();
		ci2.setNum(1);
		ci2.setFood(r);
		
		shopCart.put( 3,  ci   );
		
		resorderBiz.completeOrder(o, shopCart);
		
	}
	
	@Test
	public void testResfoodrBiz() {
		List<Resfood> list=resfoodBiz.findAll();
		assertEquals(list.size(), 13);
		for (Resfood rf : list) {
			System.out.println(rf.getFname());
		}
	}
	
	@Test
	public void testResuserBiz() {
		Resuser u = new Resuser();
		u.setUsername("a");
		u.setPwd(   "a"  );
		Resuser result=resuserBiz.login(   u );
		assertNotNull(   result );
	}

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
