package com.mercari.mercaritest.data.model;

public class Item {

    public final String id;
    public final String name;
    public final String status;
    public final long num_likes;
    public final long num_comments;
    public final long price;
    public final String photo;

    public Item(String id, String name, long num_likes, long num_comments, long price, String photo, String status) {
        this.id = id;
        this.name = name;
        this.num_likes = num_likes;
        this.num_comments = num_comments;
        this.price = price;
        this.photo = photo;
        this.status = status;
    }
}
