package virtual_pet;

public class VirtualPet {
    private int hunger = 50;
    private int thirst = 50;
    private int tiredness = 30;
    private int boredom = 0;
    private int sickness = 10;

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
        hunger += 1;
        thirst += 1;
        tiredness += 1;
        boredom += 1;
        sickness += 1;
        performPriorityNeed();
    }

    public void feed(int value) {
        hunger -= value;
        thirst += value;
    }

    public void hydrate(int value) {
        thirst -= value;
    }

    public void rest(int value) {
        tiredness -= value;
        boredom += value;
    }

    public void play(int value) {
        boredom -= value;
        tiredness += value;
        hunger += value;
        thirst += value;
        sickness += value;
    }

    public void heal(int value) {
        tiredness -= value;
        hunger -= value;
        thirst -= value;
        boredom -= value;
        sickness -= value;
    }

    public void displayStats() {
        System.out.println("Hunger: " + hunger + "%");
        System.out.println("Thirst: " + thirst + "%");
        System.out.println("Tiredness: " + tiredness + "%");
        System.out.println("Boredom: " + boredom + "%");
        System.out.println("Sickness: " + sickness + "%");
    }

    public void performPriorityNeed() {
        int[] arr = { hunger, thirst, tiredness, boredom, sickness };
        int max = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        System.out.println(index);
        if (index == 0) {
            System.out.println("Mali ate.");
            feed(3);
        } else if (index == 1) {
            System.out.println("Mali drank water.");
            hydrate(3);
        } else if (index == 2) {
            System.out.println("Mali took a nap.");
            rest(3);
        } else if (index == 3) {
            System.out.println("Mali played.");
            play(3);
        } else {
            System.out.println("Mali self medicated.");
            heal(3);
        }
    }
}
