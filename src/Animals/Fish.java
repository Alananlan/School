package Animals;

public class Fish extends Animal {

    @Override
    public void type() {
        type = "fish";
        name = "Salmon";
    }

    @Override
    public void locomotion() {
        locomotion = "Swimming";
        legs = 0;
    }
}
