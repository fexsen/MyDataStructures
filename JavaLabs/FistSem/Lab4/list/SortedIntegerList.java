package JavaLabs.FistSem.Lab4.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class SortedIntegerList {
    private final LinkedList<Integer> Sort_list;
    private final boolean Rep;

    public SortedIntegerList(boolean rep){
        Rep = rep;
        Sort_list = new LinkedList<>();
    }

    public void Add(int elem){

        ListIterator<Integer> iter = Sort_list.listIterator(0);
        if(!iter.hasNext()){
            Sort_list.add(elem);
            return;
        }
        while(iter.hasNext()){
            if(iter.hasPrevious()){
                ListIterator<Integer> iter_helper = Sort_list.listIterator(iter.nextIndex());
                int curr = iter.next();
                if(elem == curr && !Rep){
                    return;
                }
                if(curr >= elem){
                    iter_helper.add(elem);
                    return;
                }
            }else{
                int curr = iter.next();
                if(elem == curr && !Rep){
                    return;
                }
            }
        }
        Sort_list.add(elem);

    }
    public void Erase(int elem){

        ListIterator<Integer> iter = Sort_list.listIterator(0);
        while(iter.hasNext()){
            if(iter.next() == elem){
                iter.remove();
            }
        }
    }

    public SortedIntegerList Remove(SortedIntegerList lst){

        SortedIntegerList res = new SortedIntegerList(Rep);
        ListIterator<Integer> iter1 = Sort_list.listIterator(0);

        while(iter1.hasNext()){
            ListIterator<Integer> iter2 = lst.Sort_list.listIterator(0);
            int curr = iter1.next();
            boolean flag = true;
            while(iter2.hasNext()){
                if(curr == iter2.next()){
                    flag = false;
                    break;
                }
            }
            if(flag){
                res.Add(curr);
            }
        }
        return res;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void Print(){

        Iterator<Integer> iter = Sort_list.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
