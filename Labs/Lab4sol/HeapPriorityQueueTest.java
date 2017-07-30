/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
/**
 * Test of a priority queue
 * @author Lachlan Plant
 */
public class HeapPriorityQueueTest {

    static String alpha = "abcdefghijklmnopqrstuvwxyz";
    public static ArrayList<Entry<Integer,Character>> gen(int n){
        Random rng = new Random();
        ArrayList<Entry<Integer,Character>> a = new ArrayList<Entry<Integer,Character>>();
        for(int i=0; i< n; i++)
            
            a.add(new Entry<>(i,alpha.charAt(rng.nextInt(26))));
        return a;
    }
    
    public static void shuffle(ArrayList<Entry<Integer,Character>> a){
        Random rng = new Random();
        for(int j = a.size() -1; j>0; j--){
            int next = rng.nextInt(j);
            Entry<Integer,Character> temp = a.get(j);
            a.set(j, a.get(next));
            a.set(next, temp);
        }
    }
    
    public static void testRemoveMin(){
        boolean res = true;
        ArrayList<Entry<Integer,Character>> test = HeapPriorityQueueTest.gen(10);
        HeapPriorityQueueTest.shuffle(test);        
        HeapPriorityQueue<Integer,Character> pq = new HeapPriorityQueue<>(10);
        try{
            for(Entry<Integer,Character> e : test) {
                pq.insert(e.key,e.value);
            }  
            for(int i =0; i< 10; i++){
                Entry<Integer,Character> e = pq.removeMin();
                if(e.key != i) res = false;
            }
        }
        catch(ArrayIndexOutOfBoundsException e1){
            System.out.println("removeMin() Test Failed, ArrayIndexOutOfBounds");
            return;
        }
        catch(NullPointerException e1){
            System.out.println("removeMin() Test Failed, NullPointer");
            return;
        }
        if(res){
            System.out.println("removeMin() Test Passed");
        }
        else{
            System.out.println("removeMin() Test Failed, Order does not match");
        }
    }
    
    public static void testRemoveMinEmpty(){
        
             
        HeapPriorityQueue<Integer,Character> pq = new HeapPriorityQueue<>(10);
        Entry<Integer,Character> e;
        try{
            e = pq.removeMin();
        }
        catch(ArrayIndexOutOfBoundsException e1){
            System.out.println("removeMinEmpty() Test Failed, ArrayIndexOutOfBounds");
            return;
        }
        catch(NullPointerException e1){
            System.out.println("removeMinEmpty() Test Failed, NullPointer");
            return;
        }
        if(e == null){
            System.out.println("removeMinEmpty() Test Passed");
        }
        else{
            System.out.println("removeMinEmpty() Test Failed, min value not null");
        }
        
    }
    
    public static void testMinEmpty(){
             
        HeapPriorityQueue<Integer,Character> pq = new HeapPriorityQueue<>(10);
        Entry<Integer,Character> e;
        try{
            e = pq.min();
        }
        catch(ArrayIndexOutOfBoundsException e1){
            System.out.println("minEmpty() Test Failed, ArrayIndexOutOfBounds");
            return;
        }
        catch(NullPointerException e1){
            System.out.println("minEmpty() Test Failed, NullPointer");
            return;
        }
        if(e == null){
            System.out.println("minEmpty() Test Passed");
        }
        else{
            System.out.println("minEmpty() Test Failed, min not null");
        }
    }
    
    public static void testIsEmpty(){
        boolean res = true;
        ArrayList<Entry<Integer,Character>> test = HeapPriorityQueueTest.gen(10);
        HeapPriorityQueueTest.shuffle(test);        
        HeapPriorityQueue<Integer,Character> pq = new HeapPriorityQueue<>(10);
        if(!pq.isEmpty()) res = false;
        for(Entry<Integer,Character> e : test) {
            pq.insert(e.key,e.value);
        }  
        if(pq.isEmpty()) res = false;
        for(int i =0; i< 10; i++){
            Entry<Integer,Character> e = pq.removeMin();
        }
        if(!pq.isEmpty()) res = false;
        
        if(res){
            System.out.println("isEmpty() Test Passed");
        }
        else{
            System.out.println("isEmpty() Test Failed");
        }
    }
    
    public static void testMin(){
        Entry<Integer,Character> min;
        ArrayList<Entry<Integer,Character>> test = HeapPriorityQueueTest.gen(10);
        HeapPriorityQueueTest.shuffle(test);        
        HeapPriorityQueue<Integer,Character> pq = new HeapPriorityQueue<>(10);
        try{
            for(Entry<Integer,Character> e : test) {
                pq.insert(e.key,e.value);
            }
            min = pq.min();
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("min() Test Failed, ArrayIndexOutOfBounds");
            return;
        }
        catch(NullPointerException e){
            System.out.println("min() Test Failed, NullPointer");
            return;
        }
        if(min.key == 0){
            if(pq.size()!= 10){
                System.out.println("min() Test Failed, size is wrong");
            }
            System.out.println("min() Test Passed");
        }
        else{
            System.out.println("min() Test Failed, min value not as expected");
        }
    }
    
    public static void testInsert(){
        ArrayList<Entry<Integer,Character>> test = HeapPriorityQueueTest.gen(10);
        HeapPriorityQueueTest.shuffle(test);        
        HeapPriorityQueue<Integer,Character> pq = new HeapPriorityQueue<>(20);
        try{
            for(Entry<Integer,Character> e : test) {
                pq.insert(e.key,e.value);
            }  
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("insert() Test Failed, ArrayIndexOutOfBounds");
            return;
        }
        catch(NullPointerException e){
            System.out.println("insert() Test Failed, NullPointer");
            return;
        }
        catch(IllegalArgumentException e){
            System.out.println("insert() Test Failed, Should not be full");
            return;
        }
        if(pq.size() == 10){
            System.out.println("insert() Test Passed");
        }
        else{
            System.out.println("insert() Test Failed, size wrong");
        }
    }
    
    public static void testInsertFull(){
        try{
            ArrayList<Entry<Integer,Character>> test = HeapPriorityQueueTest.gen(10);
            HeapPriorityQueueTest.shuffle(test);        
            HeapPriorityQueue<Integer,Character> pq = new HeapPriorityQueue<>(10);
            for(Entry<Integer,Character> e : test) {
                pq.insert(e.key,e.value);
            }  
            pq.insert(11, Character.MIN_VALUE);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("insertFull() Test Failed, ArrayIndexOutOfBounds");
            return;
        }
        catch(NullPointerException e){
            System.out.println("insertFull() Test Failed, NullPointer");
            return;
        }
        catch(IllegalArgumentException e){
            System.out.println("insertFull() Test Passed");
            return;
        }
        System.out.println("insertFull() Test Failed, no exception thrown");
    }
    
    public static void genShuffleAndPrint(){
        ArrayList<Entry<Integer,Character>> test = HeapPriorityQueueTest.gen(26);
        HeapPriorityQueueTest.shuffle(test);        
        HeapPriorityQueue<Integer,Character> pq = new HeapPriorityQueue<>(26);
        System.out.println("Order of Insertion");
        for(Entry<Integer,Character> e : test) {
            System.out.print("("+e.key.toString()+","+e.value.toString()+"), ");
        }
        System.out.println();
        for(Entry<Integer,Character> e : test) {
            pq.insert(e.key,e.value);
        }
        System.out.println("Order of returnMin");
        while(!pq.isEmpty()){
            Entry<Integer,Character> e = pq.removeMin();
            System.out.print("("+e.key.toString()+","+e.value.toString()+"), ");
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Testing method results:");
        System.out.println("------------------------");
        testInsertFull();
        testInsert();
        testInsertFull();
        testIsEmpty();
        testMin();
        testMinEmpty();
        testRemoveMin();
        testRemoveMinEmpty();
        System.out.println();
        System.out.println();
        System.out.println("Running Full Insert and removal of 26 Elements (Key,Value)");
        System.out.println("------------------------");
        genShuffleAndPrint();
        
    }
    
}
