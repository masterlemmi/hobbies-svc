package com.lemzki.common.reader;


public interface ResourceReader<R> {

    /**
     * @param  fileName name of file to read
     * @return the read resource
     */
    R read(String fileName);
}
