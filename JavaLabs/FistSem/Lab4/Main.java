package JavaLabs.FistSem.Lab4;

import JavaLabs.FistSem.Lab4.list.SortedIntegerList;

public class Main {

    public static void main(String[] args){
        SortedIntegerList list = new SortedIntegerList(true);

        list.Add(-189778);
        list.Add(23243);
        list.Add(343224);
        list.Add(333333);
        list.Add(3413123);
        list.Add(-212);
        list.Add(-322);
        list.Add(0);
        list.Add(0);
        list.Add(0);

        System.out.println("Current list: ");
        list.Print();

        list.Erase(0);
        System.out.println("Erase 0 from list: ");
        list.Print();


    }
}
