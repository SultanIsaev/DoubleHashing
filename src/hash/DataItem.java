package hash;

public class DataItem {
    private int iData; //Данные (ключ)

    public DataItem(int i){
        iData = i;
    }

    public int getKey(){
        return iData;
    }
}