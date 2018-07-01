package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        int key;
        DataItem dataItem;
        int size, n;

        // Ввод размеров
        System.out.println("Введите размер хэш таблицы: ");
        size = getInt();
        System.out.println("Введите начальное количество элементов: ");
        n = getInt();

        // Создание таблицы
        HashTable hashTable = new HashTable(size);

        // Вставка данных
        for(int i = 0; i < n; i++){
            key = (int)(Math.random() * 2 * size);
            dataItem = new DataItem(key);
            hashTable.insert(key, dataItem);
        }
/**
 *  Взаимодействие с пользователем
 */
        while (true){
            System.out.println("Введите первую букву ");
            System.out.println("show, insert, delete, find: ");
            char choice = getChar();
            switch (choice){
                case 's':
                    hashTable.displayTable();
                    break;
                case 'i':
                    System.out.println("Введите значение ключа для вставки: ");
                    key = getInt();
                    dataItem = new DataItem(key);
                    hashTable.insert(key, dataItem);
                    break;
                case 'd':
                    System.out.println("Введите значение ключа для удаления: ");
                    key = getInt();
                    hashTable.delete(key);
                    break;
                case 'f':
                    System.out.println("Введите значение ключа для поиска: ");
                    key = getInt();
                    dataItem = hashTable.find(key);
                    if(dataItem != null)
                        System.out.println("Найден " + key);
                    else
                        System.out.println("Не найден " + key);
                    break;
                default:
                    System.out.println("Неверный ввод");
            }
        }
    }
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException{
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException{
        String s = getString();
        return Integer.parseInt(s);
    }

}