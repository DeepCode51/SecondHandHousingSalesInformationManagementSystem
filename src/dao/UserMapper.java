package dao;

import Pojo.User;

public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);


    User selectByPrimaryKey(Integer id);
    
    User selectByUser(User user);
    

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}