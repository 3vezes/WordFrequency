package com.ericrgon;


import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class DocumentParser {

    /**
     * Parses a file into a collection of words. The problem did not
     * describe the size of the documents being parsed. I'm making the assumption that the
     * documents will fit in memory.
     *
     * @param file The file to parse
     * @return A list of words.
     * @throws IOException The file could not be opened.
     */
    public static List<String> getWords(File file) throws IOException {
        List<String> words = Lists.newArrayList();
        Path filePath = file.toPath();
        for(String line : Files.readAllLines(filePath, Charset.forName("UTF-8"))){
            for(String word : Splitter.on(" ").omitEmptyStrings().trimResults().split(line)){
                words.add(word);
            }
        }

        return words;
    }
}
