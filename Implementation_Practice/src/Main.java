import Interfaces_Implementation.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        IIITGHostel obj = new IIITGHostel();
        obj.name = "Bijat" ;
        obj.NumberOfpeopleRoomsharing = 5 ;
        obj.roomNum = 234 ;
        obj.age = 20 ;
        obj.roomNumber(obj.roomNum);
    }

}
class IIITGHostel implements Hostel, studentDetails{
    String name ;
    int age ;
    int roomNum ;
    int NumberOfpeopleRoomsharing;
    @Override
    public int roomNumber(int num) {
        System.out.println("The Room number of the given student is : " + num);
        return num;
    }

    @Override
    public int numberOfPeopleInRoom(int num) {
        System.out.println("The number of people living in a room is :" + num);
        return num;
    }

    @Override
    public void nameOfTheStudent(String name) {
        System.out.println("Student Name : " + name);
    }

    @Override
    public void ageOfTheStudent(int age) {
        System.out.println("Student age : " + age);
    }
}