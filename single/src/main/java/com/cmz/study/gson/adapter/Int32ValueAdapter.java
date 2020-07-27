package com.cmz.study.gson.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.protobuf.Int32Value;

import java.io.IOException;

public class Int32ValueAdapter extends TypeAdapter<Int32Value> {
    @Override
    public void write(JsonWriter out, Int32Value value) throws IOException {
        out.beginObject();
        out.name("name").value(value.getValue());
        out.endObject();
    }

    @Override
    public Int32Value read(JsonReader in) throws IOException {
        Int32Value.Builder builder = Int32Value.newBuilder();
        in.beginObject();
        while (in.hasNext()) {
            if(in.nextName().equals("type")) {
                builder.setValue(in.nextInt());
            }
        }
        return builder.build();
    }
}
