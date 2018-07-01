package hash;

public class HashTable {
    private DataItem[] hashArray;   // Массив ячеек хеш-таблицы
    private int arraySize;
    private DataItem nonItem;   // Для удаленных элементов

    public HashTable(int size){
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }

    /**
     * Вывод таблицы в консоль
     */
    public void displayTable(){
        System.out.println("Table: ");
        for (int i = 0; i < arraySize; i++){
            if(hashArray[i] != null)
                System.out.print(hashArray[i].getKey()+" ");
            else
                System.out.print("** ");
        }
        System.out.println("");
    }

    public int hashFunc1(int key){
        return key % arraySize;
    }

    /**
     * Возвращаемое значение отлично от нуля, меньше размера массива,
     * функция отлична от хеш-функции 1
     * Размер массива должен быть простым (в моем случае, например, по отношению к 5)
     * @param key
     * @return
     */
    public int hashFunc2(int key){
        return 5 - key % 5;
    }

    /**
     * Вставка элемента данных
     * Метод предполагает, что таблица не заполнина
     * @param key
     * @param item
     */
    public void insert(int key, DataItem item){
        int hashVal = hashFunc1(key);   // Хеширование ключа
        int stepSize = hashFunc2(key);  // Вычисление смещения

        while(hashArray[hashVal] != null && // Пока не будет найдена пустая ячейка
                hashArray[hashVal].getKey() != -1){ // или -1
            hashVal += stepSize;    // Прибавление смещения
            hashVal %= arraySize;   // Возврат к началу
        }
        hashArray[hashVal] = item;  // Вставка элемента
    }

    /**
     * Удаление элемента с заданным ключом
     * @param key
     * @return
     */
    public DataItem delete(int key){
        int hashVal = hashFunc1(key);   // Хэширование ключа
        int stepSize = hashFunc2(key);  // Вычисление смещения

        while (hashArray[hashVal] != null){ // Пока не найдена пустая ячейка
            // Ключ найден?
            if(hashArray[hashVal].getKey() == key){
                DataItem temp = hashArray[hashVal]; // Временное сохранение
                hashArray[hashVal] = nonItem;       // Удаление элемента
                return temp;
            }
            hashVal += stepSize;    // Прибавление смещения
            hashVal %= arraySize;   // Возврат к началу
        }
        return null;    // Элемент не найден
    }

    /**
     * Поиск элемента с заданным ключом
     * Метод предполагает, что таблица не заполнена
     * @param key
     * @return
     */
    public DataItem find(int key){
        int hashVal = hashFunc1(key);   // Хэширование ключа
        int stepSize = hashFunc2(key);  // Вычилсение смещения
         while (hashArray[hashVal] != null){    // Пока не найдена пустая ячейка
             if(hashArray[hashVal].getKey() == key)
                 return hashArray[hashVal]; // Да, метод возвращает элемент
             hashVal += stepSize;   // Прибавление смещения
             hashVal %= arraySize;  // Возврат к началу
         }
         return null;   // Элемент не найден
    }
}