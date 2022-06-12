//import java.util.function.Predicate;
import java.util.List;
import java.util.ArrayList;

//import java.util.Comparator;
public class PredicateDemo {

    static class Person{

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + age;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            result = prime * result + yearOfService;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Person other = (Person) obj;
            if (age != other.age)
                return false;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            if (yearOfService != other.yearOfService)
                return false;
            return true;
        }

        String name;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getYearOfService() {
            return yearOfService;
        }

        public void setYearOfService(int yearOfService) {
            this.yearOfService = yearOfService;
        }

        int age;
        int yearOfService;

        public Person(String name, int age, int yearOfService){
            this.name= name;
            this.age = age;
            this.yearOfService = yearOfService;
        }

    }

    static List<Person> person = new ArrayList<>();
    
}
