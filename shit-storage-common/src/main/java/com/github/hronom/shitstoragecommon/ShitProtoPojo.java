package com.github.hronom.shitstoragecommon;

public class ShitProtoPojo {

    private String source;

    private String text;

    public ShitProtoPojo(String source, String text) {
        this.source = source;
        this.text = text;
    }

    public ShitProtoPojo() {

    }

    public String getSource() {
        return source;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Shit{" + "source='" + source + '\'' + ", text='" + text + '\'' + '}';
    }
}
