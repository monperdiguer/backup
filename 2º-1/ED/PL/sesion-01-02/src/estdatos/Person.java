package estdatos;

public class Person implements Comparable<Person>{
	    private String name;
	    private int age;

	    public Person(String name, int age) {
	        this.name = name;
	        this.age = age;
	    }

	    public void setName(String name) {
			this.name = name;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getName() { return name; }
	    public int getAge() { return age; }

	    @Override
	    public int compareTo(Person p) {
	        return name.compareTo(p.name); //orden natural basado en en nombre(ascendente)
	    }

		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + "]";
		}

	   
}