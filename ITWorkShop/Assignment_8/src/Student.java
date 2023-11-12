import java.util.Comparator;

class Student implements Comparable<Student> {
    private String name;
    private int roll;
    private String birthYear;

    public Student(String name, int roll, String birthYear) {
        this.name = name;
        this.roll = roll;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public int getRoll() {
        return roll;
    }

    public String getBirthYear() {
        return birthYear;
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    public static final Comparator<Student> FirstNameComparator = new Comparator<Student>() {
        @Override
        public int compare(Student student1, Student student2) {
            return student1.name.compareTo(student2.name);
        }
    };

    public static final Comparator<Student> TitleComparator = new Comparator<Student>() {
        @Override
        public int compare(Student student1, Student student2) {
            // Assuming title is the part after the last space in the name
            String title1 = student1.name.substring(student1.name.lastIndexOf(" ") + 1);
            String title2 = student2.name.substring(student2.name.lastIndexOf(" ") + 1);
            return title1.compareTo(title2);
        }
    };

    public static final Comparator<Student> ReverseRollComparator = new Comparator<Student>() {
        @Override
        public int compare(Student student1, Student student2) {
            return Integer.compare(student2.roll, student1.roll);
        }
//        @Override
//        public int compare(Student std1 ,Student std2){
//            return Integer.compareTo(std1.roll,std1.roll);
//        }
    };

    public static final Comparator<Student> BirthYearComparator = new Comparator<Student>() {
        @Override
        public int compare(Student student1, Student student2) {
            return student1.birthYear.compareTo(student2.birthYear);
        }
    };
}
