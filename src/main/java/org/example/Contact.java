package org.example;

import java.util.*;

import java.util.logging.Logger;

public class Contact {
    public static void main(String[] args) {

        Logger l = Logger.getLogger("kawin");
        Scanner inp = new Scanner(System.in);
        LinkedList<Details> ll = new LinkedList<>();
        while (true) {


            l.info("enter chioce\n1 -> insert a contact\n2 -> delete a contact\n3 -> search a contact\n4 -> Display all contacats\n5 -> Exit");
            int choice = inp.nextInt();
            switch (choice) {
                case 1:

                    int size = ll.size();

                    l.info("enter Name:");
                    String namee = inp.next();

                    l.info("enter Phone:");
                    String phone = inp.next();
                    l.info("enter Email:");
                    String email = inp.next();
                    int i = 0;
                    Details ob1 = new Details(namee, phone, email);
                    if (size > 0) {
                        for (Details element : ll)
                        {
                            String nam = element.name;
                            l.info(nam);
                            if (nam.equals(namee)||element.phone.equals(phone) || element.email.equals(email)) {
                                l.info("This name or phone number or email is already given");
                            } else {
                                //l.info("---------");
                                i++;
                                break;
                            }
                        }
                        if (i == size) {
                            ll.add(ob1);
                        }
                    }
                    else
                    {
                        ll.add(ob1);
                    }

                    break;
                case 2:

                    i=-1;
                    if(ll.size()==0)
                    {
                        l.info("Contacct is empty");
                    }
                    else {
                        l.info("enter the contact name to delete");
                        String name = inp.next();
                        for (Details element : ll) {
                            i++;
                            if (element.name.equals(name))
                            {
                                ll.remove(i);
                                l.info("Contact removed");
                            }
                        }
                    }
                    break;
                case 3:
                    if(ll.size()==0)
                    {
                        l.info("Contact is empty");
                    }
                    else {
                        l.info("enter the contact name to search");
                        String name = inp.next();
                        for (Details element : ll)
                        {
                            if (element.name.equals(name))
                            {
                                l.info(element.tostring());
                                l.info("Contact searched");
                                break;
                            }
                        }
                    }

                case 4:
                    if(ll.size()==0)
                    {
                        l.info("Contacct is empty");
                    }
                    else {
                        for (Details element : ll)
                            l.info(element.tostring());
                    }

                    break;
                default:
                    l.info("Invalid choice");
                    break;
            }
            if (choice == 5) {
                break;
            }
        }
    }


}

class Details
{
    String name;
    String phone;
    String email;
    Details(String name,String phone,String email)
    {
        this.name=name;
        this.phone=phone;
        this.email=email;
    }
    String tostring()
    {
        return "Name:"+name+"\nPhoneNumber:"+phone+"\nEmail:"+email;
    }
}