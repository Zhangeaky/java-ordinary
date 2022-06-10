package se.serialize.beans;

/**
 * @Author: jiegege
 * @Date: 2022/2/12 11:26 下午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class manager extends employee{

    private employee member;

    public manager(String name, String department, long id) {
        super(name, department, id);
        //this.member = member;
    }

    public void setMember(employee member) {
        this.member = member;
    }

    public employee getMember() {
        return member;
    }
}
