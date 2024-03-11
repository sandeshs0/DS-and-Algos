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
            hashValue=(hashValue+i*i)% size;
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
        QuadraticHashing qh= new QuadraticHashing(10);
        qh.insert(1, 978);
        qh.insert(2, 78);
        qh.insert(3, 766);
        qh.insert(4, 978);
        qh.insert(5, 978);
        qh.insert(6, 978);
        qh.insert(7, 978);
        qh.insert(8, 978);
        qh.insert(9, 978);
        qh.insert(10, 978);
        qh.insert(10, 978);
        qh.print();
    }
}


// Disadv: not sure to find a spot while inserting
// Serach is in O(n)
