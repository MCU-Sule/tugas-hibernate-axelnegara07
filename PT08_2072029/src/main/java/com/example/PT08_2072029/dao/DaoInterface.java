package com.example.PT08_2072029.dao;

import java.util.List;

public interface DaoInterface<T> {
    List<T> getData();
    void addData(T data);
    void deleteData(T data);
    void updateData(T data);
}
