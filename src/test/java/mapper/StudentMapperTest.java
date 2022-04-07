package mapper;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import data.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：Mybatis_Plus插件之性能分析插件
 * Package(包名): mapper
 * Class(测试类名): StudentMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/4/7
 * Time(创建时间)： 19:33
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class StudentMapperTest
{
    @Test
    public void select() throws Exception
    {
        String resource = "mybatis-config.xml";
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream(resource);
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Student student = new Student();
        List<Student> list = student.selectAll();

        /*Time：96 ms - ID：mapper.StudentMapper.selectList
        Execute SQL：
        SELECT
                student_no,
                name,
                sex,
                telephone_number,
                family_telephone_number,
                birthday,
                address,
                id_card,
                email,
                dormitory_number,
                class_no,
                state,
                remarks
        FROM
                student*/
    }

    @Test
    public void select1() throws Exception
    {
        String resource = "mybatis-config.xml";
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream(resource);
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Student student = new Student();
        Student student1 = student.selectById(1001L);

        /*Time：30 ms - ID：mapper.StudentMapper.selectById
        Execute SQL：
        SELECT
                student_no,
                name,
                sex,
                telephone_number,
                family_telephone_number,
                birthday,
                address,
                id_card,
                email,
                dormitory_number,
                class_no,
                state,
                remarks
        FROM
                student
        WHERE
                student_no=1001*/
    }
}