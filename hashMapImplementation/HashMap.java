import java.util.LinkedList;
public class HashMap {
    private class Node {
        Integer key = null;
        Integer value = null;

        Node(Integer key, Integer value){
            this.key = key;
            this.value = value;
        
        }

    }
        private LinkedList<Node>[] Buckets;
        private int bucketLen = 0;
        private int TotalNofNode = 0;


        private void intilize(int size){
            bucketLen = size;
            Buckets = new LinkedList[size];
            for(int i = 0; i < size; i++){
                Buckets[i] = new LinkedList<>();
            }
            TotalNofNode = 0;
        }

        public static boolean containsKey(Integer key){

        }
        
        private int  getHashCode(Integer key){
            return Math.abs(key.hashCode()) % 10;
            

        }

        public static int getGroup(Integer key){
            int group = getHashCode(key);
            return key;


        }
    


}



