package com.mercari.mercaritest.data.model;

import java.util.List;

public class Response {
    public final String result;
    public final List<Item> data;

    public Response(String result, List<Item> data) {
        this.result = result;
        this.data = data;
    }
}