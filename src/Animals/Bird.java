package Animals;

public class Bird extends Animal{




    Bird() {

    }
    @Override
    public void type() {
        type = "Bird";
        name = "Eagle, Robin";
    }

    @Override
    public void locomotion() {
        locomotion = "Flying";
        legs = 2;
    }



}
