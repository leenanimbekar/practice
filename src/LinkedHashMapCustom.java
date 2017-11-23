
/**
 * Created by nimbekl on 11/3/17.
 */
public class LinkedHashMapCustom<K,V> {
    Entry<K,V> header;
    Entry<K,V> last;
    Entry[] table;
    int capacity;
    LinkedHashMapCustom(int capacity){
        header = null;
        last = null;
        capacity = this.capacity;
        table = new Entry[capacity];
    }
    static class Entry<K,V>{
        K key;
        V value;
        Entry<K,V> before;
        Entry<K,V> after;
        Entry<K,V> next;
        Entry(K key,V value){
           key = this.key;
           value = this.value;
        }
    }

    int getHash(K key){
     return Math.abs(key.hashCode())%capacity;
    }

    void put(K key,V value){
        Entry entry = new Entry(key,value);
        int hash = getHash(key);
        Entry current = table[hash];
        if(current == null){
            table[hash] = current;
            return;
        }
        maintainOrderAfterInsert(entry);
        if(current != null){
            Entry prev = null;
            while(current != null){
               if(current.key.equals(key)){
                    if(prev == null){
                        entry.next = current.next;
                        table[hash] = entry;
                        return;
                    }else {
                        entry.next = current.next;
                        prev.next = entry;
                        return;
                    }
               }
               prev = current;
               current = current.next;
            }
            prev.next = entry;
        }
    }
    void maintainOrderAfterInsert(Entry<K,V> entry){
        if(header == null){
            header = entry;
            last = entry;
            return;
        }else {
            if(header.key.equals(entry.key)){
                deleteFirst();
                insertFirst(entry);
                return;
            }
            if(last.key.equals(entry.key)){
                deleteLast();
                insertLast(entry);
                return;
            }
            Entry<K,V> currentEntry = deleteSpecificEntry(entry);
            if(currentEntry == null){
                insertLast(entry);
            }else insertAfter(currentEntry,entry);
        }
    }
    Entry<K,V> deleteSpecificEntry(Entry<K,V> entry){
       Entry current = header;
       while(!current.key.equals(entry.key)){
           if(current.after == null){
               return null;
           }
            current = current.after;
       }
        Entry beforeEntry = current.before;
        current.before.after = current.after;
        current.after.before = current.before;
        return beforeEntry;
    }

    void insertAfter(Entry<K,V> beforeEntry,Entry<K,V> entry){
        Entry current = header;
        while(current != beforeEntry){
            current = current.after;
        }
        entry.after = beforeEntry.after;
        beforeEntry.after.before = entry;
        entry.before = beforeEntry;
        beforeEntry.after = entry;
    }

    void deleteLast(){
      if(header == last){
        header=last=null;
        return;
      } else{
          last = last.before;
          last = null;
      }
    }
    void insertLast(Entry<K,V> entry){
        if(header == null){
            header = last = entry;
            return;
        }
        entry.after = last;
        last.after = entry;
        last = entry;
    }

    void deleteFirst(){
        if(header == last){
           header= last=null;
            return;
        }else {
           header = header.after;
           header = null;
        }
    }

    void insertFirst(Entry<K,V> entry){
        if(header == null){
            header = last = entry;
            return;
        }
        entry.after = header;
        header.before = entry;
        header = entry;
    }
    public static void main(String args[]){
        LinkedHashMapCustom<Integer,Integer> mp = new LinkedHashMapCustom<>(4);
    }
}
