package edu.xnxy.suqh.entity;

/**
 * description:
 *
 * @author suqh
 *         Created by suqh on 2017/4/19.
 */
public class StaticData {
    /*
   * 数据类型
   * */
    private Integer codeType;

    /*
    * 数据ID
    * */
    private Integer codeId;

    /*
    * 数据名称
    * */
    private String codeName;

    /*
    * 数据注释
    * */
    private String notes;

    /*
    * 扩展字段ext1
    * */
    private Integer ext1;

    /*
    * 扩展字段ext2
    * */
    private String ext2;

    /*
    * 扩展字段ext3
    * */
    private String ext3;

    public Integer getCodeType() {
        return codeType;
    }

    public void setCodeType(Integer codeType) {
        this.codeType = codeType;
    }

    public Integer getCodeId() {
        return codeId;
    }

    public void setCodeId(Integer codeId) {
        this.codeId = codeId;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
        return "StaticData{" +
                "codeType=" + codeType +
                ", codeId=" + codeId +
                ", codeName='" + codeName + '\'' +
                ", notes='" + notes + '\'' +
                ", ext1=" + ext1 +
                ", ext2='" + ext2 + '\'' +
                ", ext3='" + ext3 + '\'' +
                '}';
    }
}
