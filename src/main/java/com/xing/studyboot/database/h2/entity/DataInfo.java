package com.xing.studyboot.database.h2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

/**
 *  实体对象
 * @author xing
 * @createTime
 */
@Entity//代表是该类是实体类。标注于实体类上，通常和@Table是结合使用的。
@Data
public class DataInfo {
	@Id //@Id注解表示这个字段是一个id
	@GeneratedValue//@GeneratedValue注解表示主键的自增长策略
	//对字段进行定制，可以使用@Column注解，去配置字段的名称，长度，是否为空等等
    private long id;
    private String name;
    private String age;
    
    public DataInfo() {
    }
    public DataInfo(String name, String age) {
    	this.name = name;
    	this.age = age;
    }
}
