package virtual_pet;

import java.util.Random;

public class VirtualPet {
    private int hunger = 50;
    private int thirst = 40;
    private int tiredness = 20;
    private int boredom = 10;
    private int sickness = 0;
    Random random = new Random();

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
        if (value == 3) {
            if (hunger <= 100) {
                System.out.println("Mali ate.");
                hunger -= value;
                thirst += value;
            }
        } else {
            if (boredom >= random.nextInt(150))
                System.out.println("Mali is bored and refused to eat.");
            else {
                System.out.println("You fed Mali.");
                hunger -= value;
                thirst += value;
            }
        }
    }

    public void hydrate(int value) {
        if (value == 10) {
            System.out.println("You gave water to Mali.");
        } else {
            if (thirst <= 100) {
                System.out.println("Mali drank water.");
            }
        }
        thirst -= value;
    }

    public void rest(int value) {
        if (value == 10) {
            if (hunger >= random.nextInt(150))
                System.out.println("Mali is hungry and refused to sleep.");
            else {
                System.out.println("You put Mali to sleep.");
                tiredness -= value;
                boredom += value;
            }
        } else {
            if (tiredness <= 100) {
                System.out.println("Mali took a nap.");
                tiredness -= value;
                boredom += value;
            }
        }
    }

    public void play(int value) {
        if (value == 10) {
            if (sickness >= random.nextInt(150))
                System.out.println("Mali is sick and refused to play.");
            else {
                System.out.println("You played with Mali.");
                boredom -= value;
                tiredness += value;
                hunger += value;
                thirst += value;
                sickness += value;
            }
        } else {
            if (boredom <= 100) {
                System.out.println("Mali played.");
                boredom -= value;
                tiredness += value;
                hunger += value;
                thirst += value;
                sickness += value;
            }
        }
    }

    public void heal(int value) {
        if (value == 10)
            System.out.println("You made Mali feel better.");
        else {
            if (sickness <= 100) {
                System.out.println("Mali self medicated.");
            }
        }
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
        if (index == 0) {
            feed(3);
        } else if (index == 1) {
            hydrate(3);
        } else if (index == 2) {
            rest(3);
        } else if (index == 3) {
            play(3);
        } else {
            heal(3);
        }
    }
}
