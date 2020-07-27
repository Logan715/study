package com.cmz.study.ams.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class BooleanAdapter  extends TypeAdapter<Boolean> {
    @Override
    public void write(JsonWriter out, Boolean value) throws IOException {

    }

    @Override
    public Boolean read(JsonReader in) throws IOException {
        return null;
    }
}
