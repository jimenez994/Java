public class Animal {
  String name;
  enum AnimalType{DOG,CAT,BIRD}

  AnimalType type;

  Animal type() {
    System.out.println(this.type);
    return this;
  }
  Animal name(){
    System.out.println("Hi my name is " + this.name);
    // return this.Animal;
    return this;
  };
  Animal(String name){
    this.name = name;  
  };
}