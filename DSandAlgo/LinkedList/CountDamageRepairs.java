package DsAndAlgo.LinkedList;

/**
 * Created by nimbekl on 11/22/17.
 */
//9:33
import sun.awt.image.ImageWatched;

import java.util.Scanner;
public class CountDamageRepairs {
  public static void main(String args[]){
      Scanner in = new Scanner(System.in);
      int count = in.nextInt();
      int k = in.nextInt();
      int arr[] = new int[count];
      for(int i = 0;i<arr.length;i++){
         arr[i] = in.nextInt();
      }
      sort(arr);
      LinkedList list = new LinkedList();
      for(int i = 0;i<arr.length;i++){
          int number = arr[i];
          if(list.size != 0 && number - list.getLast()<k){
              int last = list.getLast();
            for(int j = 0;j<number - list.getLast();j++){
               last++;
               list.add(last);
            }
          }
          else if(number != 0){
              for(int j = 0;j<k;j++) {
                  list.add(number);
                  number++;
              }
          }
      }
      System.out.println(list.size);

  }
  static void sort(int arr[]){
      int n = arr.length;
      for(int i = n/2-1;i>=0;i--){
        heapify(arr,n,i);
      }
      for(int i = n-1;i>=0;i--){
          int temp = arr[0];
          arr[0] = arr[i];
          arr[i] = temp;
          heapify(arr,i,0);
      }
  }
  static void heapify(int arr[],int n,int i){
     int largest = i;
     int left = 2*i+1;
     int right = 2*i+2;
     if(left< n && arr[largest] < arr[left]){
         largest = left;
     }
     if(right < n && arr[largest] < arr[right]){
         largest = right;
     }
     if(i != largest){
         int swap = arr[i];
         arr[i] = arr[largest];
         arr[largest] = swap;
         heapify(arr,n,largest);
     }
  }
  static class Node{
      int data;
      Node next;
      Node prev;
      Node(int data){
        this.data = data;
      }
  }
  static class LinkedList{
      Node head;
      Node last;
      int size = 0;
      void add(int n){
          Node newNode = new Node(n);
          if(head == null){
            head = newNode;
            last = newNode;
          }else {
              last.next = newNode;
              newNode.prev = last;
              last = newNode;
          }
          size++;
      }
      int getLast(){
         if(head == null && last ==  null)return -1;
         else return last.data;
      }
  }
}
