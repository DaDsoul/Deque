package com.akezhanmussa.deque_adt;

import com.akezhanmussa.adt.Deque;
import com.akezhanmussa.impl.LinkedListDeque;

public class Main {

    public static Deque<Integer> merge(Deque<Integer> d1, Deque<Integer> d2) {


 /* assuming d1 and d2 are sorted, merge their contents
       into a single sorted Deque, and return it */

        Deque<Integer> unity = new LinkedListDeque();

        int sizeD1 = d1.getSize();
        int sizeD2 = d2.getSize();
        int size = sizeD1 + sizeD2;
        boolean isD1empty = false;
        boolean isD2empty = false;



        try{
            while(unity.getSize() != size){
                int elemD1 = d1.popFromFront();
                int elemD2 = d2.popFromFront();

                if (elemD1 >= elemD2){
                    unity.pushToBack(elemD2);
                    d1.pushToFront(elemD1);
                } else {
                    unity.pushToBack(elemD1);
                    d2.pushToFront(elemD2);
                }

                if (d1.getSize() == 0 && d2.getSize() != 0){
                    isD1empty = true;
                    break;
                } else if (d2.getSize() == 0 && d1.getSize() != 0){
                    isD2empty = true;
                    break;
                }
            }


            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }

        if (isD1empty){
            while(d2.getSize() != 0){
                try{
                    unity.pushToBack(d2.popFromFront());
                } catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }

        if (isD2empty){
            while(d1.getSize() != 0){
                try{
                    unity.pushToBack(d1.popFromFront());
                } catch(Exception ex){
                    System.out.println(ex.getMessage());
                }                }
        }
        return unity;
    }


    public static Deque<Integer> mergeSort(Deque<Integer> deq) {


     /* Step 0:  base case???
        Step 1:  split deq into two Deques of relatively equal size
        Step 2:  pass both of these Deques into mergeSort
        Step 3:  pass the resulting Deques into merge, and return the result
     */

        int size = deq.getSize();

        Deque<Integer> d1 = new LinkedListDeque();
        Deque<Integer> d2 = new LinkedListDeque();

        if (size >= 2){

            for(int i = 0; i < size/2;i++){
             try{
                 d1.pushToFront(deq.popFromBack());
                 d2.pushToBack(deq.popFromFront());
             }catch(Exception ex){
                  System.out.println(ex.getMessage());
              }
          }

          if (size % 2 == 1){
              try{
                  d1.pushToFront(deq.popFromBack());
              }catch(Exception ex){
                  System.out.println(ex.getMessage());
              }
          }

          return merge(mergeSort(d1), mergeSort(d2));

        } else return deq;

    }

    public static void main(String[] args) {


        Deque<Integer> someDeque = new LinkedListDeque();

        try{
            someDeque.popFromBack();

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        try{
            someDeque.popFromFront();

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        System.out.println();
        System.out.println(someDeque);
        System.out.println(someDeque.getSize());

        for(int i = 0; i<5; i++){
            someDeque.pushToFront(i + 1);
            System.out.println(someDeque);
            System.out.println(someDeque.getSize());
        }

        System.out.println();

        try{
         for(int i = 0; i<5; i++){
             someDeque.popFromFront();
             System.out.println(someDeque);
             System.out.println(someDeque.getSize());

          }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        for(int i = 0; i<6; i++){
            someDeque.pushToFront(i + 1);
            System.out.println(someDeque);
            System.out.println(someDeque.getSize());
        }

        try{
            for(int i = 0; i<6; i++){
                someDeque.popFromFront();
                System.out.println(someDeque);
                System.out.println(someDeque.getSize());

            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        for(int i = 0; i<6; i++){
            someDeque.pushToBack(i + 1);
            System.out.println(someDeque);
            System.out.println(someDeque.getSize());
        }

        try{
            for(int i = 0; i<6; i++){
                someDeque.popFromBack();
                System.out.println(someDeque);
                System.out.println(someDeque.getSize());

            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        for(int i = 0; i<8; i++){
            someDeque.pushToBack(i + 1);
            System.out.println(someDeque);
            System.out.println(someDeque.getSize());
        }


        try{
            for(int i = 0; i<8; i++){
                someDeque.popFromFront();
                System.out.println(someDeque);
                System.out.println(someDeque.getSize());

            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }


        for(int i = 0; i< 10; i++){
            someDeque.pushToBack(i);
            someDeque.pushToFront(i);
        }

        System.out.println(someDeque);
        System.out.println(someDeque.getSize());

        try{
            for(int i = 0; i<8; i++){
                someDeque.popFromFront();
                someDeque.popFromBack();
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        System.out.println(someDeque);
        System.out.println(someDeque.getSize());

        System.out.println();

        someDeque.clear();
        System.out.println(someDeque);
        System.out.println(someDeque.getSize());

        someDeque.pushToBack(22);
        someDeque.pushToFront(12121);
        someDeque.pushToFront(2);
        System.out.println(someDeque);
        System.out.println(someDeque.getSize());

        System.out.println();

        someDeque.clear();

        someDeque.pushToBack(1);
        someDeque.pushToBack(2);
        someDeque.pushToBack(3);
        someDeque.pushToBack(29);
        System.out.println(someDeque);
        System.out.println(someDeque.getSize());

        System.out.println();

        Deque<Integer> anotherDeque = new LinkedListDeque();
        anotherDeque.pushToBack(4);
        anotherDeque.pushToBack(5);
        anotherDeque.pushToBack(6);
        anotherDeque.pushToBack(12);
        System.out.println(anotherDeque);
        System.out.println(anotherDeque.getSize());

        System.out.println();

        Deque<Integer> unity = merge(someDeque,anotherDeque);
        System.out.println(unity);

        Deque<Integer> sortedDeque = new LinkedListDeque();
        sortedDeque.pushToBack(3);
        sortedDeque.pushToBack(5);
        sortedDeque.pushToBack(2);
        sortedDeque.pushToBack(1);
        sortedDeque.pushToBack(15);
        sortedDeque.pushToBack(7);
        sortedDeque.pushToBack(222);
        sortedDeque.pushToBack(12);




        sortedDeque = mergeSort(sortedDeque);

        System.out.println();
        System.out.println(sortedDeque);

        for(int i = 0; i < 200000; i++){
            sortedDeque.pushToFront(33);
            System.out.println(someDeque);
            try{                sortedDeque.popFromBack();

            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }

        }

    }

}
