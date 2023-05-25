package customer;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CustomerDAO {
	// 메소드를 넣기위해 '싱글톤' ( static {} 블럭킹을 만들어서 CustomerDAO가 사용될때 무조건 먼저 실행 될 코드를 넣어둠)
	// Connection <- conn 열고 닫고를 수동으로함.
	// 외부에서 사용할수있는 (인스턴스멤버에서 SqlSession<-만 사용함. 따라서 인스턴스멤버나 스태틱멤버로
	// ↑ 를 만들어줌
	private static SqlSession sql;
	static {
		
		String resource = "mybatis/conn.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		sql = sqlSessionFactory.openSession(); // Connection 객체를 이용해서 통신 여는 처리같음.
	}
	
	public void test() {
		// 1. 마이바티스 매퍼를 이용하여 dual테이블로 숫자 1 가져오기.
		 int dualInt = sql.selectOne("kyg.dual");
		 System.out.println(dualInt);
	}
	public CustomerVO test1(int id) {
		CustomerVO vo = sql.selectOne("cu.detail", id);
		System.out.println(vo.getName());
		System.out.println(vo.getGender());
		return vo;
	}
	
	public List<CustomerVO> listSelect() {
		// 마이바티스 매퍼를 이용하여 customer 테이블의 전체 내용을 가져오기.
		List<CustomerVO> list = sql.selectList("cu.list");
		System.out.println(list.size());
		return list;
	}
	public void update(String id, String email, String phone) {
		CustomerVO vo = new CustomerVO();
		vo.setId(Integer.parseInt(id));
		vo.setEmail(email);
		vo.setPhone(phone);
		int result = sql.update("cu.update",vo);
		sql.commit();
		System.out.println(result);
	}
//	public void insert(String id, String email, String phone) {
//		CustomerVO vo = new CustomerVO();
//		vo.setId(Integer.parseInt(id));
//		vo.setEmail(email);
//		vo.setPhone(phone);
//		int result = sql.insert("cu.insert", vo);
//		sql.commit();
		
//	}
	public void insert(CustomerVO vo) {
		int result = sql.insert("cu.insert", vo);
		sql.commit();
		System.out.println(result);
		
	}
	
	
}
