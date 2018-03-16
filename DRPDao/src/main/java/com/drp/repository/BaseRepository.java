/**
 * @Title: BaseRepository.java
 * @Package com.drp.repository
 * @author 小灰灰    日期：2017年11月10日
 * @version V1.0
 */
package com.drp.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName: BaseRepository
 * @Description: TODO
 * @author 小灰灰
 * @date 2017年11月10日 下午1:10:46 
 *
 */
public interface BaseRepository<T, ID extends Serializable> extends JpaSpecificationExecutor<T>, JpaRepository<T, ID> {

}
