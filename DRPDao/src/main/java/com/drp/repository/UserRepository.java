package com.drp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.drp.pojo.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 刘江涛
 * @ClassName: UserRepository
 * @Description: 用户的持久层
 * @date 2017年11月1日 下午3:58:57
 */

public interface UserRepository extends JpaSpecificationExecutor<User>, JpaRepository<User, Integer> {

    /**
     * 修改用户密码
     *
     * @param userPassword 用户新密码
     * @param uId          用户id
     */
    @Modifying
    @Query( "update User u set u.userPassword=?1 where u.uId=?2" )
    void updateUserPassword(String userPassword, Integer uId);

    /**
     * 修改用户密码
     * @param userPassword 用户新密码
     * @param userCode 用户代码
     */
//	@Modifying
//	@Query("update User u set u.userPassword=?1 where u.userCode=?2")
//	void updateUserPassword(String userPassword, String userCode);

    /**
     * 修改用户
     * @param username 新的用户名
     * @param userPassword    新的密码
     * @param userTel 新的联系电话
     * @param userEmail 新的邮箱
     * @param userCode 用户代码
     */
//	@Modifying
//	@Query("update User u set u.username=?1, u.userPassword=?2, u.userTel=?3, u.userEmail=?4 where u.userCode=?5")
//	void updateUser(String username,String userPassword,String userTel,String userEmail,String userCode);

    /**
     * 修改用户
     *
     * @param userName     新的用户名
     * @param userPassword 新的密码
     * @param userTel      新的联系电话
     * @param userEmail    新的邮箱
     * @param uId          用户id
     */
    @Modifying
    @Transactional
    @Query( "update User u set u.userName=?1, u.userPassword=?2, u.userTel=?3, u.userEmail=?4 where u.uId=?5" )
    void updateUser(String userName, String userPassword, String userTel, String userEmail, Integer uId);

    /**
     * 通过用户名查找用户
     *
     * @param userName 用户名
     * @return user 对象
     */
    @Query( "select u from User u where u.userName = ?1" )
    User findByUserName(String userName);

    @Query( "select u from User u where u.userCode = ?1" )
    User findByUserCode(String userCode);

    /**
     * 通过电话号查找
     *
     * @param userTel
     * @return
     */
    @Query( "select u from User u where u.userTel = ?1" )
    User findByUserTel(String userTel);

    /**
     * 通过邮箱进行查找
     *
     * @return
     */
    @Query( "select u from User u where u.userEmail = ?1" )
    User findByUserEmail(String userEmail);

    /**
     * 通过用户代码进行查找
     *
     * @return
     */
//	 @Query("select u from User u where u.userCode = ?1")
//	 User findByUserCode(String userCode);
    @Query( "select u from User u order by u.createDate desc " )
    Page<User> findAllOrderByCreateTime(Pageable pageable);

    @Modifying
    @Transactional
    @Query( "delete from User u where u.userCode = ?1" )
    void deleteAllByUserCode(String userCodes);
}
