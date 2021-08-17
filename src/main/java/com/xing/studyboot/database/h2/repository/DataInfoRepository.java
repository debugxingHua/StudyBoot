package com.xing.studyboot.database.h2.repository;

import org.springframework.data.repository.CrudRepository;

import com.xing.studyboot.database.h2.entity.DataInfo;

/**
 * 增删改查
 * @author xing
 * @createTime
 */
public interface DataInfoRepository extends CrudRepository<DataInfo,Long> {

}
