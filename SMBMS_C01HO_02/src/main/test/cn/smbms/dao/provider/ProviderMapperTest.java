package cn.smbms.dao.provider;

import cn.smbms.pojo.Provider;
import cn.smbms.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProviderMapperTest {
    private Logger logger = Logger.getLogger(ProviderMapperTest.class);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {
        SqlSession sqlSession = null;
        int count = 0;
        try {
            sqlSession = MyBatisUtil.createSqlSession();

            //第一种方式:调用selectOne方法执行查询操作
            //count = sqlSession.selectOne("cn.smbms.dao.provider.ProviderMapper.count");

            //第二种方式:调用getMapper(Mapper.class)执行dao接口方法来实现对数据库的查询操作
            count = sqlSession.getMapper(ProviderMapper.class).countProvider();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            MyBatisUtil.closeSqlSession(sqlSession);
        }

        logger.debug("ProviderDaoTest testCount---> " + count);
    }

    @Test
    public void testGetProviderList(){
        SqlSession sqlSession = null;
        List<Provider> providerList = new ArrayList<Provider>();
        try {
            sqlSession = MyBatisUtil.createSqlSession();

            //第一种方式:调用selectList方法执行查询操作
            //providerList = sqlSession.selectList("cn.smbms.dao.provider.ProviderMapper.getProviderList");

            //第二种方式:调用getMapper(Mapper.class)执行dao接口方法来实现对数据库的查询操作
            providerList = sqlSession.getMapper(ProviderMapper.class).getProviderList();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        for(Provider provider: providerList){
            logger.debug("testGetProviderList proCode: " + provider.getProCode() + " and proName: " + provider.getProName());
        }
    }
}
