package edu.xnxy.suqh.entity;

import java.util.Date;

/**
 * Description:记录用户访问实体
 *
 * Created by suqh on 17-5-5.
 */
public class UserAccess {

    /**
     * 主键编号，自增
     */
    private Integer id;

    /**
     * 访问时间
     */
    private Date accessDate;

    /**
     * 扩展字段1
     */
    private Integer ext1;

    /**
     * 扩展字段2
     */
    private String ext2;

    /**
     * 扩展字段3
     */
    private String ext3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(Date accessDate) {
        this.accessDate = accessDate;
    }

    public Integer getExt1() {
        return ext1;
    }

    public void setExt1(Integer ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    @Override
    public String toString() {
        return "UserAccess{" +
                "id=" + id +
                ", accessDate=" + accessDate +
                ", ext1=" + ext1 +
                ", ext2='" + ext2 + '\'' +
                ", ext3='" + ext3 + '\'' +
                '}';
    }
}
