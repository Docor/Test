package com.test;

import com.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class test {
    @Test
    public void userTest() throws IOException {
        String resource="mybatis-config.xml";
        InputStream stream= Resources.getResourceAsStream(resource);
        //获得会话工厂
        SqlSessionFactory sf=new SqlSessionFactoryBuilder().build(stream);
        //会话
        SqlSession session=sf.openSession();
        //01.弱类型  通过命名空间唯一锁定要执行的sql
        //02.强类型
//        List<Map> list = session.selectList("com.mapper.UserMapper.selectAll");
        UserMapper dao = session.getMapper(UserMapper.class);
        List<Map> list = dao.aaa();
        for (Map item:list){
            System.out.println(item);
        }
        session.close();

    }
}
