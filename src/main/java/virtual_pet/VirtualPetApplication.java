package virtual_pet;

import java.util.Scanner;

public class VirtualPetApplication {

    public static void main(String[] args) {
        VirtualPet virtualPet = new VirtualPet();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mali the monkey");
        while (virtualPet.getHunger() <= 100 && virtualPet.getThirst() <= 100 && virtualPet.getTiredness() <= 100
                && virtualPet.getBoredom() <= 100 && virtualPet.getSickness() <= 100) {
            virtualPet.displayStats();
            System.out.println();
            System.out.println("What do you want to do?");
            System.out.println("1. Give food to Mali");
            System.out.println("2. Give water to Mali");
            System.out.println("3. Make Mali rest");
            System.out.println("4. Play with Mali");
            System.out.println("5. Cure Mali");
            System.out.println("6. Do nothing");
            System.out.println();
            System.out.print("> ");

            int toDo = scanner.nextInt();
            System.out.println();

            if (toDo == 1) {
                virtualPet.feed(10);
            } else if (toDo == 2) {
                virtualPet.hydrate(10);
            } else if (toDo == 3) {
                virtualPet.rest(10);
            } else if (toDo == 4) {
                virtualPet.play(10);
            } else if (toDo == 5) {

                virtualPet.heal(10);
            } else
                System.out.println("Did nothing.");
            virtualPet.tick();
        }
        if (virtualPet.getHunger() >= 100)
            System.out.println("Mali starved!");
        else if (virtualPet.getThirst() >= 100)
            System.out.println("Mali got dehydrated!");
        else if (virtualPet.getTiredness() >= 100)
            System.out.println("Mali got soo tired!");
        else if (virtualPet.getBoredom() >= 100)
            System.out.println("Mali got soo bored!");
        else if (virtualPet.getSickness() >= 100)
            System.out.println("Mali got soo sick!");

        scanner.close();
    }

}
