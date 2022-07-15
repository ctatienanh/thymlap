package service;

import models.Category;
import models.Customer;

import java.util.ArrayList;

public class CustomerService {
    public ArrayList<Customer> list = new ArrayList<>();
    public CategoryService categoryService = new CategoryService();

    public CustomerService() {
        list.add(new Customer(1,"lg3",3000,"https://photographer.vn/wp-content/uploads/2016/06/nhung-bi-quyet-de-co-nhung-buc-anh-dep5.jpg",categoryService.categories.get(0),false ));
    }

    public int finid( int id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

    public Customer finbyid(int id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id){
                return list.get(i);
            }
        }
        return null;
    }

    public void save(Customer customer){
        list.add(customer);
    }


    public void edit(Customer customer,int index){
        list.set(index,customer);
    }
    public void delete(int index){
        list.remove(index);
    }
}
