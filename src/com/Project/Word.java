package com.Project;public class Word {
    private int length;
    protected String content;

    public int getLength() {
        return length;
    }

    public String getContent() {
        return content;
    }

    public Word(int length, String content) {
        this.length = length;
        this.content = content;
    }
}
