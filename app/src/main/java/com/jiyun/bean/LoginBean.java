package com.jiyun.bean;

import java.util.List;

/**
 * Created by 灵风 on 2019/4/2.
 */

public class LoginBean {

    /**
     * ret : 登录成功
     * code : 200
     * data : [{"uid":"728","password":"123456","phone":"18716666666","sex":1,"name":"zz1","header":null,"id":733,"age":18}]
     */
    private String ret;
    private int code;
    private List<DataEntity> data;

    public void setRet(String ret) {
        this.ret = ret;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public String getRet() {
        return ret;
    }

    public int getCode() {
        return code;
    }

    public List<DataEntity> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "ret='" + ret + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }

    public class DataEntity {
        /**
         * uid : 728
         * password : 123456
         * phone : 18716666666
         * sex : 1
         * name : zz1
         * header : null
         * id : 733
         * age : 18
         */
        private String uid;
        private String password;
        private String phone;
        private int sex;
        private String name;
        private String header;
        private int id;
        private int age;

        public void setUid(String uid) {
            this.uid = uid;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setHeader(String header) {
            this.header = header;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getUid() {
            return uid;
        }

        public String getPassword() {
            return password;
        }

        public String getPhone() {
            return phone;
        }

        public int getSex() {
            return sex;
        }

        public String getName() {
            return name;
        }

        public String getHeader() {
            return header;
        }

        public int getId() {
            return id;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "DataEntity{" +
                    "uid='" + uid + '\'' +
                    ", password='" + password + '\'' +
                    ", phone='" + phone + '\'' +
                    ", sex=" + sex +
                    ", name='" + name + '\'' +
                    ", header='" + header + '\'' +
                    ", id=" + id +
                    ", age=" + age +
                    '}';
        }
    }
}
