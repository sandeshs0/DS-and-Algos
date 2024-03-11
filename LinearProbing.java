public class LinearProbing {
    int[] keys; //to store the keys in hashtable
    int[] values; // to store the corresponding values
    int filledUpto; // kaa samma bhariyo vanera
    int size; // total size of the table

    LinearProbing(int size){
        this.keys= new int[size];
        this.values=new int[size];
        this.filledUpto=0;
        this.size=size;
    }

    int hashFunction(int key){
        return key % size;
    }
    
    void insert(int key, int value){
        int i= hashFunction(key);

        while(keys[i]!=0 && keys[i]!=key){ // checking the right spot
            i= (i+1)% size; // Hash function of linear probing h(K) + i mod n. i is the prob number
        }

        if(keys[i]==0){ // if the key doesnt already exits.
            keys[i]=key;
            values[i]=value;
            filledUpto++;
        }
        else{ // if it does, just update the value array.
            values[i]=value;
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
        LinearProbing lb= new LinearProbing(10);
        lb.insert(2, 78);
        lb.insert(1, 90);

        lb.print();
       
    }
}


// TC: O(n)

// Hashing- to store in key value pair eg databases. Retrieving is fast and easy in hashing. 

// Hash table is a data structre that maps keys to the cooresponding values. it used hash function to calculate in which index should the key should be stored and the value is mapped accordingly.

// To avoid collision, Linear probing is one of the  Closed Hashing techniques. 
// Hash Function is  h(k)=K Mod n. and to resolve any collision : {h(k)+i}mod n. i is the prob number(how many time you have tried to find a slot)

// In linear probing, if a collision happens, next available spot to store the key based on the abobe hash functions.
