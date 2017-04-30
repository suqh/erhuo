package edu.xnxy.suqh.entity;

/**
 * description:
 *
 * @author suqh
 *         Created by suqh on 2017/4/19.
 */
public class UserInfo {

    /*
    * 用户ID
    * */
    private Integer userId;

    /*
    * 用户姓名
    * */
    private String userName;

    /*
    * 用户密码
    * */
    private String userPassword;

    /*
    * 用户性别
    * */
    private String userGender;

    /*
    * 用户年龄
    * */
    private Integer userAge;

    /*
    * 用户邮箱
    * */
    private String userEmail;

    /*
    * 用户地址
    * */
    private String userAdderss;

    /*
    * 用户手机号码
    * */
    private Long userPhone;


    /*
    * 用户的状态
    * */
    private Integer userStatus;

    /*
    * 用户等级
    * */
    private String userGradeid;

    /*
    * 用户是否在线
    * */
    private Integer userIsonline;

    /*
    * 用户积分
    * */
    private Integer userPoint;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAdderss() {
        return userAdderss;
    }

    public void setUserAdderss(String userAdderss) {
        this.userAdderss = userAdderss;
    }

    public Long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

   /* public Integer getUserCollege() {
        return userCollege;
    }

    public void setUserCollege(Integer userCollege) {
        this.userCollege = userCollege;
    }

    public Integer getUserMajor() {
        return userMajor;
    }

    public void setUserMajor(Integer userMajor) {
        this.userMajor = userMajor;
    }*/

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserGradeid() {
        return userGradeid;
    }

    public void setUserGradeid(String userGradeid) {
        this.userGradeid = userGradeid;
    }

    public Integer getUserIsonline() {
        return userIsonline;
    }

    public void setUserIsonline(Integer userIsonline) {
        this.userIsonline = userIsonline;
    }

    public Integer getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(Integer userPoint) {
        this.userPoint = userPoint;
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
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userGender='" + userGender + '\'' +
                ", userAge=" + userAge +
                ", userEmail='" + userEmail + '\'' +
                ", userAdderss='" + userAdderss + '\'' +
                ", userPhone=" + userPhone +
                ", userStatus=" + userStatus +
                ", userGradeid='" + userGradeid + '\'' +
                ", userIsonline=" + userIsonline +
                ", userPoint=" + userPoint +
                ", ext1=" + ext1 +
                ", ext2='" + ext2 + '\'' +
                ", ext3='" + ext3 + '\'' +
                '}';
    }
}
