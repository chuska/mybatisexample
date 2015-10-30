package com.bit2015.mybatisexample;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit2015.mybatisexample.vo.EmailListVo;
import com.bit2015.mybatisexample.vo.GuestbookVo;

public class App {

	public static void main(String[] args) throws IOException {
		test2();
	}

	public static void test1() throws IOException {
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(Resources
						.getResourceAsStream("mybatis/configuration.xml"));

		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<EmailListVo> list = sqlSession.selectList("emaillist.list");
		sqlSession.close();

		for (EmailListVo vo : list) {
			System.out.println(vo);
		}

	}

	public static void test2() throws IOException {
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(Resources
						.getResourceAsStream("mybatis/configuration.xml"));

		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Map<String, Object>> list = sqlSession
				.selectList("member.joinlist");
		sqlSession.close();

		for (Map<String, Object> map : list) {
			map.get("NO");
			System.out.println(map);
		}

	}

	public static void test3() throws IOException {
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(Resources
						.getResourceAsStream("mybatis/configuration.xml"));

		SqlSession sqlSession = sqlSessionFactory.openSession();
		GuestbookVo vo = sqlSession.selectOne("guestbook.select", 126);
		sqlSession.close();
		System.out.println(vo);
	}

	public static void test4() throws IOException {
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(Resources
						.getResourceAsStream("mybatis/configuration.xml"));

		SqlSession sqlSession = sqlSessionFactory.openSession();
		GuestbookVo vo = new GuestbookVo();
		vo.setName("최상규");
		vo.setPassword("1234");
		vo.setMessage("하이!");
		sqlSession.insert("guestbook.insert", vo);
		sqlSession.commit();
		sqlSession.close();
		System.out.println(vo);
	}
}