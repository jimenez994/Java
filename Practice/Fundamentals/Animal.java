public class Animal {
  String name;
  enum AnimalType{DOG,CAT,BIRD}

  AnimalType AnimalT;

  Animal type() {
    System.out.println(AnimalT);
    return this;
  }
  Animal name(){
    System.out.println("Hi my name is " + this.name);
    // return this.Animal;
    return this;
  };
  
}