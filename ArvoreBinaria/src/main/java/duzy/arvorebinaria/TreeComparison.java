package duzy.arvorebinaria;

import java.util.Random;
import java.util.Scanner;

public class TreeComparison {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        BinaryTree bt = new BinaryTree();
        AVLTree avl = new AVLTree();

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Comparar árvores");
            System.out.println("2. Inserir valor nas árvores");
            System.out.println("3. Remover valor das árvores");
            System.out.println("4. Printar árvores");
            System.out.println("5. Sair");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    int[] sizes = {100, 500, 1000, 10000, 20000};
                    for (int size : sizes) {
                        int[] randomNumbers = new int[size];
                        for (int i = 0; i < size; i++) {
                            randomNumbers[i] = random.nextInt(100000);
                        }

                        long startBT = System.nanoTime();
            for (int number : randomNumbers) {
                bt.setRoot(bt.insertRec(bt.getRoot(), number));
            }
            long endBT = System.nanoTime();

            long startAVL = System.nanoTime();
            for (int number : randomNumbers) {
                avl.setRoot(avl.insert(avl.getRoot(), number));
            }
            long endAVL = System.nanoTime();

            System.out.println("Tempo de inserção para " + size + " elementos:");
            System.out.println("BinaryTree: " + (endBT - startBT) + " nanosegundos.");
            System.out.println("AVLTree: " + (endAVL - startAVL) + " nanosegundos.");

            // Busca
            int searchNumber = randomNumbers[random.nextInt(size)];  // Pegar um número aleatório da lista para busca

            startBT = System.nanoTime();
            bt.contains(searchNumber);
            endBT = System.nanoTime();

            startAVL = System.nanoTime();
            avl.contains(searchNumber);
            endAVL = System.nanoTime();

            System.out.println("Tempo de busca para " + size + " elementos:");
            System.out.println("BinaryTree: " + (endBT - startBT) + " nanosegundos.");
            System.out.println("AVLTree: " + (endAVL - startAVL) + " nanosegundos.");

            // Remoção
            int deleteNumber = randomNumbers[random.nextInt(size)];  // Pegar um número aleatório da lista para remoção

            startBT = System.nanoTime();
            bt.setRoot(bt.removeRec(bt.getRoot(), deleteNumber));
            endBT = System.nanoTime();

            startAVL = System.nanoTime();
            avl.setRoot(avl.deleteNode(avl.getRoot(), deleteNumber));
            endAVL = System.nanoTime();

            System.out.println("Tempo de remoção para " + size + " elementos:");
            System.out.println("BinaryTree: " + (endBT - startBT) + " nanosegundos.");
            System.out.println("AVLTree: " + (endAVL - startAVL) + " nanosegundos.");
            
            //Remoção de um valor especifico
           
            int specificDeleteNumber = 42; 

            long startBTSingle = System.nanoTime();
            bt.setRoot(bt.removeRec(bt.getRoot(), specificDeleteNumber));
            long endBTSingle = System.nanoTime();

            long startAVLSingle = System.nanoTime();
            avl.setRoot(avl.deleteNode(avl.getRoot(), specificDeleteNumber));
            long endAVLSingle = System.nanoTime();

            System.out.println("Tempo de remoção do número " + specificDeleteNumber + ":");
            System.out.println("BinaryTree: " + (endBTSingle - startBTSingle) + " nanosegundos.");
            System.out.println("AVLTree: " + (endAVLSingle - startAVLSingle) + " nanosegundos.");

                        System.out.println("==========================================");
                    }
                    System.out.println("Comparação concluída!");
                    break;
                case 2:
                    System.out.print("Informe o valor para inserção: ");
                    int insertValue = scanner.nextInt();
                    bt.insert(insertValue);
                    avl.setRoot(avl.insert(avl.getRoot(), insertValue));
                    System.out.println("Valor inserido nas duas árvores.");
                    break;
                case 3:
                    System.out.print("Informe o valor para remoção: ");
                    int removeValue = scanner.nextInt();
                    bt.remove(removeValue);
                    avl.setRoot(avl.deleteNode(avl.getRoot(), removeValue));
                    System.out.println("Valor removido das duas árvores.");
                    break;
                case 4:
                    System.out.println("BinaryTree:");
                    printTree(bt.getRoot());
                    System.out.println("\nAVLTree:");
                    printTree(avl.getRoot());
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void printTree(Node node) {
        if (node != null) {
            printTree(node.getLeft());
            System.out.print(node.getData() + " ");
            printTree(node.getRight());
        }
    }

    public static void printTree(AVLNode node) {
        if (node != null) {
            printTree(node.getLeft());
            System.out.print(node.getData() + " ");
            printTree(node.getRight());
        }
    }
}