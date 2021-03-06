package com.wsq.webprj.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class NewlecSqlSessionFactoryBuilder {//모든 어플리케이션에서 접근가능
   
   static SqlSessionFactory ssf;
   
   static{
      String resource = "com/wsq/webprj/dao/mybatis/mybatisConfig.xml";
      InputStream inputStream = null;
   
   try{
      inputStream = Resources.getResourceAsStream(resource);
   }catch(IOException e){
      e.printStackTrace();
      }
   
      ssf = new SqlSessionFactoryBuilder().build(inputStream);
   }
   
   public static SqlSessionFactory getSqlSessionFactory(){
      return ssf;
   }
}