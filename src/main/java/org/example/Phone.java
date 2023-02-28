package org.example;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


class Phone {
    LinkedList<Details> ll = new LinkedList<>();
    Logger l = Logger.getLogger("contacts");
    Scanner inputobject = new Scanner(System.in);

    void insert() {

        int size = ll.size();
        l.info("enter Name:");
        String name = inputobject.next();

        l.info("enter Phone:");
        String phone = inputobject.next();
        l.info("enter Email:");
        String email = inputobject.next();
        Details ob1 = new Details(name, phone, email);
        if(size==0)
        {
            ll.add(ob1);
        }
        else
        {
            insertrecursive(ll.size(),ob1,0);
        }
    }
    int insertrecursive(int size,Details ob1,int i)
    {
        Details element;
        String name=ob1.name;
        String phone=ob1.phone;
        String email=ob1.email;
        if (size >= 1)
        {
            element = ll.get(i);
            String nam = element.name;
            if (nam.equals(name) || element.phone.equals(phone) || element.email.equals(email)) {
                l.info("This name or phone number or email is already given");
                return 0;
            }
            else
            {
                i++;
            }
            size=size-1;
            insertrecursive( size, ob1,i);
        }
        else
        {
            l.info("stoped");
            ll.add(ob1);
        }
        return 0;
    }


    void delete() {
        if(ll.isEmpty())
        {
            l.info("Contacct is empty");
        }
        else
        {
            l.info("enter the contact name to delete");
            String chkname = inputobject.next();
            deleterecursive(chkname,0,ll.size());
        }
    }

    int deleterecursive(String chkname,int i,int size)
    {
        Details element;
        if(size>0)
        {
            element=ll.get(i);
            if (element.name.equals(chkname))
            {
                ll.remove(i);
                l.info("Contact removed");
                return 0;
            }
            deleterecursive(chkname,i+1,size-1);
        }
        else
        {
            l.info("Given Name not found");
        }
        return 0;
    }

    void search() {
        if(ll.isEmpty())
        {
            l.info("Contact is empty");
        }
        else
        {
            l.info("enter the contact name to search");
            String schname = inputobject.next();
            searchrecursive(schname,0,ll.size());
        }
    }

    int searchrecursive(String schname,int i,int size)
    {
        Details element;
        if(size>0)
        {
            element=ll.get(i);
            if (element.name.equals(schname))
            {
                l.log(Level.INFO, ()->"Name:"+element.name+"\nPhone Number:"+element.phone+"\nEmail "+element.email);
                l.info("Contact searched");
                return 0;
            }
            searchrecursive(schname,i+1,size-1);
        }
        else
        {
            l.info("Given Name not found");
        }
        return 0;
    }

    void display() {
        if(ll.isEmpty())
        {
            l.info("Contacct is empty");
        }
        else
        {
            displayrecursive(0,ll.size());
        }

    }

    int displayrecursive(int i, int size)
    {
        Details element;
        if(size>0)
        {
            element=ll.get(i);
            l.log(Level.INFO, ()->"Name:"+element.name+"\nPhone Number:"+element.phone+"\nEmail:"+element.email);
            i++;
            displayrecursive(i,size-1);
        }
        return 0;
    }
}
