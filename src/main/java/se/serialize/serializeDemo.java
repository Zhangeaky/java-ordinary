package se.serialize;

import se.serialize.beans.SingletonDoctorStrange;
import se.serialize.beans.employee;
import se.serialize.beans.manager;

import java.io.*;

/**
 * @Author: zhangyikai
 * @Date: 2022/2/12 11:13 下午
 * @address: hangzhou
 * @description: java 标准序列化方法
 *                  readResolve 方法
 * @Version 1.0
 */
public class serializeDemo {

    public static final String FILE = "file.txt";

    public static void main(String[] args) throws Exception{

        employee employee = new employee("eaky", "IBG", 328153);
        manager manager = new manager("mayun", "alibaba", 0);

        manager.setMember(employee);

        employee[] staffs = new employee[2];

        staffs[0] = employee;
        staffs[1] = manager;

        try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.txt"))) {

            out.writeObject(staffs);

        }

        System.out.println("before serialize ... ");
        for (int i =0; i < staffs.length; i++) {
            System.out.println("object "+ i + " " + staffs[i].hashCode());
        }

        System.out.println("after serialize ... ");

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.txt"))) {
            Object o = in.readObject();

            System.out.println(o);

            System.out.println("after cast ...");

            employee[] newStaffs =  (employee[])o;


            for (int i = 0 ; i < newStaffs.length; i++) {
                //System.out.println(newStaffs[i].getName());
                //System.out.println(newStaffs[i].getDepartment());
                //System.out.println(newStaffs[i].getId());
                //System.out.println(newStaffs[i].get);
                System.out.println(newStaffs[i].hashCode());
            }

        }



    }

    static class singletonObjectSituationTest{

        public static void singleTestBeforeOptimize(SingletonDoctorStrange instance) {

        }

        public static void singleTestAfterOptimize(SingletonDoctorStrange instance) {

//            try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE));) {
//
//                out.writeObject(instance);
//
//            }

        }


        public static void main(String[] args) throws Exception{

            SingletonDoctorStrange instance = SingletonDoctorStrange.INSTANCE;


            try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE));) {

                out.writeObject(instance);

            }

            System.out.println("before serialze ... ");
            System.out.println("hashcode : " + instance.hashCode());

            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE))) {
                Object o = in.readObject();
                if (o instanceof SingletonDoctorStrange) {
                    SingletonDoctorStrange doctor = (SingletonDoctorStrange) o;
                    System.out.println("after serialze ... ");
                    System.out.println("hashcode : " + doctor.hashCode());
                    //System.out.println(doc);
                } else {
                    System.err.println(" unknown type !!");
                    System.out.println(o);
                }
            }
        }
    }





}
