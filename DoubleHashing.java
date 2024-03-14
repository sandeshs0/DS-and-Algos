public class DoubleHashing {
    int keys[];
    int values[];
    int size;

    DoubleHashing(int size){
        this.size=size;
        this.keys=new int[size];
        this.values=new int[size];
    }

    int hashFunction(int key){
        return key % size;
    }
    int hash2(int key){
        int prime=7;
        return prime - (key%prime);
    }

    void insert(int key, int value){
        int i =0;
        // h=
        // while (key[]) {
            
        }
    }
// }
