public class QuadraticHashing {
    int keys[];
    int values[];
    int size;

    QuadraticHashing(int size){
        this.size=size;
        this.keys=new int[size];
        this.values=new int[size];
    }

    int hashFunction(int key){
        return key % size;
    }

    void insert(int key, int value){

        int hashValue=hashFunction(key); //hashvalue 
        int i=1; //initially prob number is set to 1

        while (keys[hashValue]!=0 && keys[hashValue]!=key) {
            hashValue=(hashValue+i*i) % size;
            i++;
        }
        if(keys[hashValue]==0){ // if the key is not already there
            keys[hashValue]=key;
            values[hashValue]=value;
        }
        else{ //if the key is there just update the value
            values[hashValue]=value;
        }
    }
    void print(){
        for (int i = 0; i < size; i++) {
            if (keys[i] != 0) {
                System.out.println("Key: " + keys[i] + ", Value: " + values[i]);
            }
        }
    }

    public static void main(String[] args) {
        QuadraticHashing hashTable= new QuadraticHashing(11);
        hashTable.insert(101, 80);
        hashTable.insert(201, 10);
        hashTable.insert(301, 20);
        hashTable.insert(102, 30);
        hashTable.insert(202, 40);
        hashTable.insert(302, 43);
        hashTable.insert(103, 33);
        hashTable.insert(203, 50);
        hashTable.insert(303, 3);
        hashTable.insert(104, 2);
        hashTable.print();
    }
}


// Disadv: not sure to find a spot while inserting
// Serach is in O(n)
