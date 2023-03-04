package org.example;

import codes.Buyer;
import codes.Seller;
import codes.Store;

public class TestStore {
    public static void main(String[] args){
        Store store  = new Store();
        Seller seller = new Seller(store);
        Buyer [] buyers = new Buyer[10];

        for(int i = 0 ; i < buyers.length; i++){
            buyers[i] = new Buyer("손님" + i,store);
            buyers[i].start();
        }

        seller.start();

    }
}
