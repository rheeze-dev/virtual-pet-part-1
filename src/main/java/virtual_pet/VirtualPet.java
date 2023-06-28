package virtual_pet;

public class VirtualPet {
    private int hunger = 50;
    private int thirst = 50;
    private int tiredness = 50;
    private int boredom = 50;
    private int sickness = 50;

    public int getHunger() {
        return this.hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getThirst() {
        return this.thirst;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public int getTiredness() {
        return this.tiredness;
    }

    public void setTiredness(int tiredness) {
        this.tiredness = tiredness;
    }

    public int getBoredom() {
        return this.boredom;
    }

    public void setBoredom(int boredom) {
        this.boredom = boredom;
    }

    public int getSickness() {
        return this.sickness;
    }

    public void setSickness(int sickness) {
        this.sickness = sickness;
    }

    public void tick() {
        hunger += 2;
        thirst += 2;
        tiredness += 2;
        boredom += 2;
        sickness += 2;

        int max = 0;
        int index = 0;
        int[] arr = { hunger, thirst, tiredness, boredom, sickness };
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        // System.out.println(index);
    }

    public void feed() {
        System.out.println("You fed Mali.");
        hunger -= 10;
        thirst += 10;
    }

    public void hydrate() {
        System.out.println("You gave water to Mali.");
        thirst -= 10;
    }

    public void rest() {
        System.out.println("You put Mali to sleep.");
        tiredness -= 10;
        boredom += 10;
    }

    public void play() {
        System.out.println("You played with Mali.");
        boredom -= 10;
        tiredness += 10;
        hunger += 10;
        thirst += 10;
        sickness += 10;
    }

    public void heal() {
        System.out.println("You made Mali feel better.");
        tiredness -= 10;
        hunger -= 10;
        thirst -= 10;
        boredom -= 10;
        sickness -= 10;
    }

    public void displayStats() {
        System.out.println("Hunger: " + hunger + "%");
        System.out.println("Thirst: " + thirst + "%");
        System.out.println("Tiredness: " + tiredness + "%");
        System.out.println("Boredom: " + boredom + "%");
        System.out.println("Sickness: " + sickness + "%");
    }

}
