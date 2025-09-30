public class Main {
    public static void main(String[] args) {
        PlayerLinkedList playerLinkedList = new PlayerLinkedList();

        playerLinkedList.addToFront(new Player(1, "Hornet", 99999));
        playerLinkedList.addToFront(new Player(2, "Shakra", 999));
        playerLinkedList.addToFront(new Player(3, "Knight", 999999));


        playerLinkedList.removeFromFront();

        playerLinkedList.printList();

        System.out.println(playerLinkedList.getSize());

        System.out.println(playerLinkedList.contains(new Player(2, "Shakra", 999)));

        System.out.println(playerLinkedList.indexOf(new Player(1, "Hornet", 99999)));

    }
}
