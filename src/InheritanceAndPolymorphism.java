public class InheritanceAndPolymorphism {
    public static class Person{
        String name;
        String address;
        String phoneNumber;
        String emailAddress;

        public void setName(String name) {
            this.name = name;
        }

        public String toString(){
            return this.getClass().getSimpleName()+": "+this.name;
        }
    }
    public static class Student extends Person{
        Status status;

    }

    public static class Employee extends Person{
        String office;
        String salary;
        String dateHired;
    }

    public static class Faculty extends Employee{
        String officeHours;
        String rank;
    }

    public static class Staff extends Employee{
        String title;
    }

    public static enum Status{
        FRESHMAN, SOPHOMORE, JUNIOR, SENIOR;
        public String getStatus(){
            switch(this){
                case FRESHMAN: return "Freshman";
                case SOPHOMORE: return "Sophomore";
                case JUNIOR: return "Junior";
                case SENIOR: return "Senior";
                default: return "Wrong";
            }
        }
    }
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("I'm a Person");
        System.out.println(person);

        Student student = new Student();
        student.setName("I'm a Student");
        System.out.println(student);

        Employee employee = new Employee();
        employee.setName("I'm an Employee");
        System.out.println(employee);

        Faculty faculty = new Faculty();
        faculty.setName("I'm a Faculy");
        System.out.println(faculty);

        Staff staff = new Staff();
        staff.setName("I'm a Staff");
        System.out.println(staff);

    }
}
